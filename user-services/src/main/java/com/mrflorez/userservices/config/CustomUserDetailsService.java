package com.mrflorez.userservices.config;

import com.mrflorez.userservices.model.UserSeg;
import com.mrflorez.userservices.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserSeg userSeg = userService.getUserByUserName(username);
        return new CustomUserDetails(userSeg.getUsername(), userSeg.getPassword());
    }


}
