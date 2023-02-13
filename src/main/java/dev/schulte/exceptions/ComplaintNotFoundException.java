package dev.schulte.exceptions;

public class ComplaintNotFoundException extends RuntimeException{

    public ComplaintNotFoundException(String message){
        super(message);
    }
}
