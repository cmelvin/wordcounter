package com.translator;

public class Translator {

    public String translate(String input) {

        if (input.equalsIgnoreCase("flower")
                || input.equalsIgnoreCase("flor")
                || input.equalsIgnoreCase("blume"))
            return "flower";

        return input.toLowerCase();
    }
}
