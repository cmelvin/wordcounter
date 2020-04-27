package com.translator;

public class Translator {

    TranslatorMethods translatorMethods = new TranslatorMethods();

    public String translate(String input) {
        return translatedWord(translatorMethods::translate, input);

    }

    public String translatedWord(TranslatorFunction tf, String input) {
        return tf.translate(input);
    }
}
