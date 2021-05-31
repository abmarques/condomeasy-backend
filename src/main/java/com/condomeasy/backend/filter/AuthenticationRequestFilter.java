package com.condomeasy.backend.filter;

import com.condomeasy.backend.service.impl.DefaultUserDetailsService;
import com.condomeasy.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationRequestFilter extends OncePerRequestFilter {

    @Autowired
    private DefaultUserDetailsService defaultUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {

        String authorization = httpServletRequest.getHeader("Authorization");
        String username = null;
        String token = null;

        if (authorization != null && authorization.startsWith("Bearer ")) {
            token = authorization.substring(7);
            username = jwtUtil.getUsername(token);
        }
        
        if(token != null) {
        	
        	if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        		UserDetails userDetails = defaultUserDetailsService.loadUserByUsername(username);
        		
        		if (jwtUtil.validateToken(token, userDetails)) {
        			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
        					new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        			
        			usernamePasswordAuthenticationToken.setDetails(
        					new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
        			
        			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        		}
        		
        	}
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}
