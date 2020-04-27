package com.wordcounter;

import com.translator.Translator;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class WordCounter {

    private int noFuncThreadPoolSize;
    private List<String> wordList = new ArrayList<>();
    private Translator translator = new Translator();

    public WordCounter(int noFuncThreadPoolSize) {
        this.noFuncThreadPoolSize = noFuncThreadPoolSize;
    }

    public void add(String word) throws WordCounterException {
        if (StringUtils.isAlpha(word)) {
            wordList.add(word);
        } else {
            throw new WordCounterException("Not Alphabet");
        }

    }

    public int getCount(String word) throws WordCounterException {
        Map<String, Long> wordMap;
        String finalWord;
        try {
            finalWord = translator.translate(word);
            ForkJoinPool customThreadPool = new ForkJoinPool(noFuncThreadPoolSize);
            wordMap = customThreadPool.submit(() -> wordList.parallelStream().map(x -> translator.translate(x)).parallel()
                    .filter(x -> x.equalsIgnoreCase(finalWord)).collect(Collectors.groupingBy(e -> e, Collectors.counting()))).get();
            return wordMap.get(finalWord.toLowerCase()).intValue();
        } catch (Exception e) {
            throw new WordCounterException(e.getMessage(), e.getCause());
        }

    }

    public int getSize() {
        return wordList.size();
    }

}
