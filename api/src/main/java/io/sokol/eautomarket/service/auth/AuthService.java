package io.sokol.eautomarket.service.auth;

import io.sokol.eautomarket.pojo.AuthRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> authenticate(AuthRequest request);
}
