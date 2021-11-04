package com.condomeasy.backend.controller;

import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.condomeasy.backend.dto.AuthenticationRequestDTO;
import com.condomeasy.backend.dto.AuthenticationResponseDTO;
import com.condomeasy.backend.service.impl.DefaultUserDetailsService;
import com.condomeasy.backend.util.JwtUtil;

import static com.condomeasy.backend.constant.MessageBundle.INVALID_CREDENTIALS;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private DefaultUserDetailsService defaultUserDetailsService;

    @Autowired
    private UserService userService;

    @PostMapping("/authenticate")
    public AuthenticationResponseDTO authenticate(@RequestBody AuthenticationRequestDTO authenticationRequestDto) throws Exception {

        if(userService.findByUsername(authenticationRequestDto.getUsername()) == null) {
            throw new BusinessException(INVALID_CREDENTIALS, HttpStatus.BAD_REQUEST.value());
        }

        final UserDetails userDetails = defaultUserDetailsService.loadUserByCredentials(
                authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword());
        final String token = jwtUtil.generateToken(userDetails);

        return new AuthenticationResponseDTO(token);
    }

}
