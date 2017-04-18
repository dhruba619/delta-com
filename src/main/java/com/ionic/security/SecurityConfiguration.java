package com.ionic.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ionic.service.AuthenticationService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource datasource;
    
    @Autowired
    AuthenticationService authenticationService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/")
            .permitAll()
            .antMatchers(HttpMethod.POST, "/api/v1.0/login")
            .permitAll()
            .antMatchers("/api/v1.0/register")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .addFilterBefore(new LoginFilter("/api/v1.0/login", authenticationManager(),authenticationService), UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(new AuthenticationFilter(authenticationService), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(datasource)
            .usersByUsernameQuery("select email,password,active from cust_regis where email=?")
            .authoritiesByUsernameQuery("select email,active from cust_regis where email=?");

    }

}
