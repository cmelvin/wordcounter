package com.wordcounter;

import com.translator.Translator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class WordCounter {

    List<String> wordList = new ArrayList<String>();

    public void add(String word) {

            wordList.add(word);

    }

    public int getCount(String word){
        Map<String, Long> wordMap;

        Translator translator = new Translator();

        wordMap = wordList.parallelStream().map(x -> translator.translate(x)).parallel()
                .filter(x -> x.equalsIgnoreCase(word)).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        return wordMap.get(word).intValue();


    }

    public int getSize() {
        return wordList.size();
    }

}
