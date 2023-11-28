package com.dealer.data.exceptions;

/**
 * Thrown when loading data from resources fail
 * @author Prabhjot Aulakh, Safin Haque
 */
public class LoaderException extends Exception {
    /**
     * Constructor
     * @param t The exception that caused this class to instantiate
     */
    public LoaderException(Throwable t) {
        super(t);
    }
}
