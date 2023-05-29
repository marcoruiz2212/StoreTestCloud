package com.mrflorez.userservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;

    public String generateToken(final String username){
        return jwtService.generateToken(username);
    }

    public void validateToken(final String token){
        jwtService.validateToken(token);
    }

}
