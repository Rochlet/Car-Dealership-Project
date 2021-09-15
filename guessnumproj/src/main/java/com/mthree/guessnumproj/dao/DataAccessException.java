package com.mthree.guessnumproj.dao;

/**
 *
 * @author Eric
 */
class DataAccessException extends Exception {

    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(String message,
            Throwable cause) {
        super(message, cause);
    }
}