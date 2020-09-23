package io.sokol.eautomarket.service.auth;

import io.sokol.eautomarket.entity.User;
import io.sokol.eautomarket.exceptions.UserAlreadyExistsException;
import org.springframework.http.ResponseEntity;

public interface SignupService {
    ResponseEntity<?> registerUser(User u) throws UserAlreadyExistsException;
}
