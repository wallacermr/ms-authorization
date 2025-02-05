package com.quote.authorization.controller;

import com.quote.authorization.model.AuthRequest;
import com.quote.authorization.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<String> createAuthenticationToken(@RequestBody AuthRequest authentication) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authentication.username(), authentication.password()));
        final var userDetail = userDetailsService.loadUserByUsername(authentication.username());

        return ResponseEntity.ok(jwtUtil.generateToken(userDetail));
    }

}
