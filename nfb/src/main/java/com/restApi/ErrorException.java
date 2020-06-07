package com.restApi;

/**
 * @author : Nelson Flores B.
 * @version: 1.0
 * @created: 07-jun.-2020  15:28
 */

public class ErrorException extends Exception {

    public ErrorException() {
    }

    public ErrorException(String string) {
        super(string);
    }

    public ErrorException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ErrorException(Throwable thrwbl) {
        super(thrwbl);
    }
}

