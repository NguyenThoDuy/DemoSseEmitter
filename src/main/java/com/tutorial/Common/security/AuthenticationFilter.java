package com.tutorial.Common.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        String email = obtainUsername(request);
        String password = obtainPassword(request);

        final UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
                email, password);

        setDetails(request, result);
        return this.getAuthenticationManager().authenticate(result);
    }
}
