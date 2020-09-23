package io.sokol.eautomarket.exceptions;

public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException() {
        super("User with given username or email already exists.");
    }
}
