package io.ana.julia.listinha.exception;

public class IdNotExistsException extends IllegalArgumentException{

    private String message;

    public IdNotExistsException(String message) {
        super(message);
    }
}
