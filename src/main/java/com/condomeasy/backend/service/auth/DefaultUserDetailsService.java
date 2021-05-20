package com.condomeasy.backend.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    private DefaultUserDetailsService defaultUserDetailsService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //TODO get user from db

        return new User("user", "user", new ArrayList<>());
    }
}
