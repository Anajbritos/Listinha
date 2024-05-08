package io.ana.julia.listinha.exception;

public class DescriptionNotExistsException extends IllegalArgumentException{
    private String message;
    public DescriptionNotExistsException(String message){
        super(message);
    }
}
