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

    public int getCount(String word) {
        Map<String, Long> wordMap;
        String finalWord;
        finalWord = translator.translate(word);


        wordMap = wordList.parallelStream().map(x -> translator.translate(x)).parallel()
                .filter(x -> x.equalsIgnoreCase(word)).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        return wordMap.get(finalWord.toLowerCase()).intValue();


    }

    public int getSize() {
        return wordList.size();
    }

}
