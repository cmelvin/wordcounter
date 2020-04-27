package com.wordcounter;

import com.translator.Translator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCounter {

    List<String> wordList = new ArrayList<String>();
    Translator translator = new Translator();

    public void add(String word) {

        wordList.add(word);

    }

    public int getCount(String word) throws WordCounterException {
        Map<String, Long> wordMap;
        String finalWord;
        try{
        finalWord = translator.translate(word);


        wordMap = wordList.parallelStream().map(x -> translator.translate(x)).parallel()
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
