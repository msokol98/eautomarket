package io.sokol.eautomarket.controller;

import io.sokol.eautomarket.entity.Customer;
import io.sokol.eautomarket.exceptions.UserAlreadyExistsException;
import io.sokol.eautomarket.service.auth.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class SignupController {

    @Autowired
    private SignupService signupService;

    @PostMapping("/customer")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) throws UserAlreadyExistsException {
        return signupService.registerUser(customer);
    }

}


