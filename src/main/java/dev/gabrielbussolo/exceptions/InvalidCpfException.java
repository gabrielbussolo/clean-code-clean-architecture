package dev.gabrielbussolo.exceptions;

public class InvalidCpfException extends RuntimeException{
    public InvalidCpfException(String message) {
        super(message);
    }
}
