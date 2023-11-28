package com.dealer.data.exceptions;

/**
 * Thrown when loading data from resources fail
 * @author Prabhjot Aulakh, Safin Haque
 */
public class LoaderException extends Exception {
    /**
     * Constructor
     * @param t The exception that this class to fire
     */
    public LoaderException(Throwable t) {
        super(t);
    }

    /**
     * Constructor with error message
     * @param message Error message
     */
    public LoaderException(String message) {
        super(message);
    }
}
