package com.ionic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.NumberFormat;

import com.ionic.util.UniqueEmail;

@Entity
@Table(name = "cust_regis")
public class Customer {

    @NotNull
    @Size(min = 1)
    @Email(message="Please provide a valid email address")
    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
   // @UniqueEmail(message="Email already registered")
    private String email;
    
    @NotNull
    @Size(min = 1)
    private String password;
    
    @NotNull
    @NumberFormat
    @Size(min = 10)
    @Id
    private String mobile;
    
    private String location;
    
    @NotNull
    private boolean active;
    
    private String regDate;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

}
