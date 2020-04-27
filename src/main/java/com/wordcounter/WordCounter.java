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

    public int getCount(String input){
        Map<String, Long> wordMap;

        Translator translator = new Translator();

            return 1;

    }

    public int getSize() {
        return wordList.size();
    }

}
