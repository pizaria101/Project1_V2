package dev.schulte.exceptions;

public class BlankDescriptionException extends RuntimeException{

    public BlankDescriptionException(String message){
        super(message);
    }
}
