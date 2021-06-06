package com.condomeasy.backend.service.impl;

import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws BusinessException {

        var dto =  service.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(dto.getProfileName()));

        return new User(dto.getUsername(), dto.getPassword(), grantedAuthorities);
    }

    public UserDetails loadUserByCredentials(String username, String password) throws BusinessException {

        var dto = service.findByCredentials(username, password);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(dto.getProfileName()));

        return new User(dto.getUsername(), dto.getPassword(), grantedAuthorities);
    }

}
