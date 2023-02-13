package dev.schulte.exceptions;

public class UsernamePasswordMismatchException extends RuntimeException{

    public UsernamePasswordMismatchException(String message){
        super(message);
    }
}
