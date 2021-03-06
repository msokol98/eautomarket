package io.sokol.eautomarket.service.auth;

import io.sokol.eautomarket.pojo.AuthRequest;
import io.sokol.eautomarket.pojo.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service("authService")
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authManager;

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    @Override
    public ResponseEntity<?> authenticate(AuthRequest authRequest) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch(BadCredentialsException e) {
            return ResponseEntity.badRequest().body("Given authentication credentials were not correct.");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }

}
