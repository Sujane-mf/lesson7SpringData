package ru.geekbrains.lesson7SpringData.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
