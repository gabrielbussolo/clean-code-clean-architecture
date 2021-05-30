package dev.gabrielbussolo.exceptions;

public class StudentAlreadyEnrolledException extends RuntimeException{
    public StudentAlreadyEnrolledException(String message) {
        super(message);
    }
}
