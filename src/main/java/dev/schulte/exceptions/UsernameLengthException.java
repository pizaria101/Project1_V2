package dev.schulte.exceptions;

public class UsernameLengthException extends RuntimeException{

    public UsernameLengthException(String message){
        super(message);
    }
}
