package com.translator;

public class TranslatorMethods {

    public String translate(String input) {

        if (input.equalsIgnoreCase("flower")
                || input.equalsIgnoreCase("flor")
                || input.equalsIgnoreCase("blume"))
            return "flower";

        return input.toLowerCase();
    }
}
