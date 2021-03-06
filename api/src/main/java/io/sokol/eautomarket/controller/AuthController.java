package io.sokol.eautomarket.controller;

import io.sokol.eautomarket.pojo.AuthRequest;
import io.sokol.eautomarket.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> auth(@RequestBody AuthRequest authRequest) throws Exception {
        return authService.authenticate(authRequest);
    }

}
