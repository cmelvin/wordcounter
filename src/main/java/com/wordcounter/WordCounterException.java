package com.wordcounter;

public class WordCounterException extends Exception{


    private static final long serialVersionUID = 7718828512143293558L;

    public WordCounterException(String message) {
        super(message);
    }

    public WordCounterException(String message, Throwable cause) {
        super(message, cause);
    }

}
