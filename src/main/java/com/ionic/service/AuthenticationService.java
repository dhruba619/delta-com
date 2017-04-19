package com.ionic.service;

import java.util.Collections;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.ionic.model.Token;
import com.ionic.repository.ITokenRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class AuthenticationService {

    @Autowired
    ITokenRepository tokenRepository;

    static final long EXPIRATIONTIME = 864_000_000; // 10 days
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    /**
     * 
     * @param res
     * @param username
     */
    public void addAuthentication(HttpServletResponse res, String username) {
        Token token = new Token();
        String tokenSecret = UUID.randomUUID()
            .toString();
        String JWT = Jwts.builder()
            .setSubject(username)
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
            .signWith(SignatureAlgorithm.HS512, tokenSecret)
            .compact();

        token.setAccessToken(JWT);
        token.setEmail(username);
        token.setTokenSecret(tokenSecret);
        token.setTtl(String.valueOf(EXPIRATIONTIME));
        tokenRepository.save(token);
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    /**
     * 
     * @param request
     * @return
     */
    public Authentication getAuthentication(HttpServletRequest request) {
        String tokenString = request.getHeader(HEADER_STRING);
        if (null != tokenString) {
            Token token = tokenRepository.findOne(tokenString.replace(TOKEN_PREFIX, ""));
            if (null != token) {
                String user = Jwts.parser()
                    .setSigningKey(token.getTokenSecret())
                    .parseClaimsJws(tokenString.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

                return user != null ? new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) : null;
            }
        }
        return null;
    }
    
    
    /**
     * 
     * @param request
     * @return
     */
    public boolean removeAuthentication(HttpServletRequest request){
        tokenRepository.delete(request.getHeader(HEADER_STRING));
        return true;
        
    }
}
