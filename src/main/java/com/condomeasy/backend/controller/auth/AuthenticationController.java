package com.condomeasy.backend.controller.auth;

import com.condomeasy.backend.dto.authentication.AuthenticationRequestDto;
import com.condomeasy.backend.dto.authentication.AuthenticationResponseDto;
import com.condomeasy.backend.service.auth.DefaultUserDetailsService;
import com.condomeasy.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DefaultUserDetailsService defaultUserDetailsService;

    @PostMapping("/authenticate")
    public AuthenticationResponseDto authenticate(@RequestBody AuthenticationRequestDto authenticationRequestDto) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequestDto.getUsername(),
                            authenticationRequestDto.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid credentials", e);
        }

        final UserDetails userDetails = defaultUserDetailsService.loadUserByUsername(authenticationRequestDto.getUsername());
        final String token = jwtUtil.generateToken(userDetails);

        return new AuthenticationResponseDto(token);
    }

}
