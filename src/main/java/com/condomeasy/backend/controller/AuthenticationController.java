package com.condomeasy.backend.controller;

import com.condomeasy.backend.dto.AuthenticationRequestDTO;
import com.condomeasy.backend.dto.AuthenticationResponseDTO;
import com.condomeasy.backend.service.impl.DefaultUserDetailsService;
import com.condomeasy.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private DefaultUserDetailsService defaultUserDetailsService;

    @PostMapping("/authenticate")
    public AuthenticationResponseDTO authenticate(@RequestBody AuthenticationRequestDTO authenticationRequestDto) throws Exception {

        final UserDetails userDetails = defaultUserDetailsService.loadUserByCredentials(
                authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword());
        final String token = jwtUtil.generateToken(userDetails);

        return new AuthenticationResponseDTO(token);
    }

}
