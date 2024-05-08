package io.ana.julia.listinha.exception;

public class DescriptionAlreadyExistsException extends IllegalArgumentException{
    private String message;

    public DescriptionAlreadyExistsException(String message) {
        super(message);
    }
}
