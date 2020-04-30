package com.wordcounter;

import com.translator.TranslatorMethods;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCounter {

    private int noFuncThreadPoolSize;
    private List<String> wordList = new ArrayList<>();
    private TranslatorMethods translatorMethods = new TranslatorMethods();

    public WordCounter(int noFuncThreadPoolSize) {
        this.noFuncThreadPoolSize = noFuncThreadPoolSize;
    }

    public void add(String word) throws WordCounterException {
        if (StringUtils.isAlpha(word) && StringUtils.isNotEmpty(word)) {
            wordList.add(word);
        } else {
            throw new WordCounterException("Not Alphabet");
        }

    }

    public int getCount(String word) throws WordCounterException {
        Map<String, Long> wordMap;
        String finalWord;
        try {
            finalWord = translatorMethods.translate(word);
            wordMap = wordList.parallelStream().map(x -> translatorMethods.translate(x))
                    .filter(x -> x.equalsIgnoreCase(finalWord)).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
            return wordMap.get(finalWord.toLowerCase()).intValue();
        } catch (Exception e) {
            throw new WordCounterException(e.getMessage(), e.getCause());
        }

    }

    public int getSize() {
        return wordList.size();
    }

}
