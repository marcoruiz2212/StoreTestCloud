package com.mrflorez.userservices.service;

import com.mrflorez.userservices.model.UserSeg;
import com.mrflorez.userservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public List<UserSeg> getAllUsers(){
        return userRepository.findAll();
    }

    public UserSeg save(final UserSeg userSeg){
        userSeg.setPassword(passwordEncoder.encode(userSeg.getPassword()));
        return userRepository.save(userSeg);
    }

    public UserSeg getUserByUserName(final String username){
        final UserSeg userSeg = userRepository.findByUsername(username);
        if(Objects.isNull(userSeg)){
            throw  new UsernameNotFoundException("user not found with name :" + username);
        }
        return userSeg;
    }

}
