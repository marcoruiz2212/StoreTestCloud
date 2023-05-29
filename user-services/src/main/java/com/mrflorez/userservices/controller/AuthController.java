package com.mrflorez.userservices.controller;

import com.mrflorez.userservices.model.AuthRequest;
import com.mrflorez.userservices.model.UserSeg;
import com.mrflorez.userservices.service.JwtService;
import com.mrflorez.userservices.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    @GetMapping(value = "/token")
    public String getToken(@RequestBody final AuthRequest authRequest) throws UserPrincipalNotFoundException {
        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authentication != null && authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }
        throw new UserPrincipalNotFoundException("User doesn't exists");
    }

    @GetMapping(value = "/validate")
    public void validateToken( @RequestParam("token") final String token){
        jwtService.validateToken(token);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserSeg> saveUser(@RequestBody final UserSeg userSeg){
        return new ResponseEntity<>(userService.save(userSeg), HttpStatus.CREATED);
    }
}
