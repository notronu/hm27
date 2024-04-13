package com.example.Algoritms2;

public class IndexValueIsInvalidException extends RuntimeException {

    public IndexValueIsInvalidException() {

    }


    public IndexValueIsInvalidException(String message) {

        super(message);

    }


    public IndexValueIsInvalidException(String message, Throwable cause) {

        super(message, cause);

    }


    public IndexValueIsInvalidException(Throwable cause) {

        super(cause);
    }
}
