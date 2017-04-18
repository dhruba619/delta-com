package com.ionic.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.ionic.service.AuthenticationService;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

    
    AuthenticationService authenticationService;

    public LoginFilter(String string, AuthenticationManager authenticationManager, AuthenticationService authenticationService) {
        super(new AntPathRequestMatcher(string));
        setAuthenticationManager(authenticationManager);
        this.authenticationService=authenticationService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws AuthenticationException, IOException, ServletException {
        String email = httpRequest.getParameter("email");
        String password = httpRequest.getParameter("password");
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(email, password, Collections.emptyList()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException {
        authenticationService.addAuthentication(res, auth.getName());
    }
}
