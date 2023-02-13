package dev.schulte.exceptions;

public class NoComplaintFoundException extends RuntimeException{

    public NoComplaintFoundException(String message){
        super(message);
    }
}
