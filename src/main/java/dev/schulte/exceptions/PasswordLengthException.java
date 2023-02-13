package dev.schulte.exceptions;

public class PasswordLengthException extends RuntimeException{

    public PasswordLengthException(String message){
        super(message);
    }
}
