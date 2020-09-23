package io.sokol.eautomarket.service.auth;

import io.sokol.eautomarket.entity.User;
import io.sokol.eautomarket.exceptions.UserAlreadyExistsException;
import io.sokol.eautomarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("signupService")
public class SignupServiceImpl implements SignupService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public ResponseEntity<?> registerUser(User u) throws UserAlreadyExistsException {
        Optional<User> optU = userRepo.findByUserName(u.getUserName());
        Optional<User> optU2 = userRepo.findByEmail(u.getEmail());

        if(optU.isPresent() || optU2.isPresent())
            throw new UserAlreadyExistsException();

        userRepo.save(u);
        return ResponseEntity.ok().build();
    }
}
