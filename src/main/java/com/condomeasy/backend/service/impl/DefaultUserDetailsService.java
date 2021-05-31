package com.condomeasy.backend.service.impl;

import com.condomeasy.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        var user = userService.findByUsername(userName);

        if (user == null) throw new UsernameNotFoundException("username " + userName + " not found");

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getProfile().getName()));
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
    
    public UserDetails loadUserByUsernameAndPassoword(String userName, String password) throws UsernameNotFoundException {

        var user = userService.findByUsernameAndPassoword(userName, password);

        if (user == null) throw new UsernameNotFoundException("username " + userName + " not found");

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getProfile().getName()));
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

}
