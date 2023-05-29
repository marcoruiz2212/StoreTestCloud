package com.mrflorez.userservices.controller;

import com.mrflorez.userservices.model.UserSeg;
import com.mrflorez.userservices.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/auth/user")
@RequiredArgsConstructor
public class UserSegController {

    private final UserService userService;
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<UserSeg>> getAll(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.ACCEPTED);
    }

}
