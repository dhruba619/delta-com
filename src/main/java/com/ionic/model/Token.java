package com.ionic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="auth_store")
public class Token {
    
    @NotNull
    private String email;
    
    @NotNull
    @Id
    private String accessToken;
    
    @NotNull
    private String tokenSecret;
    
    @NotNull
    @NumberFormat
    private String ttl;
    
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getTokenSecret() {
        return tokenSecret;
    }
    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }
    public String getTtl() {
        return ttl;
    }
    public void setTtl(String ttl) {
        this.ttl = ttl;
    }
    
}
