package com.example.Algoritms2;

public class NoFreeCellsArrayIsFullException extends RuntimeException{

    public NoFreeCellsArrayIsFullException() {
    }


    public NoFreeCellsArrayIsFullException(String message) {

        super(message);
    }


    public NoFreeCellsArrayIsFullException(String message, Throwable cause) {

        super(message, cause);
    }


    public NoFreeCellsArrayIsFullException(Throwable cause) {

        super(cause);
    }
}
