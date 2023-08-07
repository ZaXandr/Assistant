package com.zakharov.dairy.crypto.exception;

public class UserNotFoundException extends RuntimeException {

    private Long id;

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Long id) {
        super("User with id: " + id + " not found");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
