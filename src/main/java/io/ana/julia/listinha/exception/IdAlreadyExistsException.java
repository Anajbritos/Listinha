package io.ana.julia.listinha.exception;

public class IdAlreadyExistsException extends IllegalArgumentException{
    private String message;

    public IdAlreadyExistsException(String message) {
        super(message);
    }
}
