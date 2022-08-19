package com.uxpsystems.assignment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SPRING SECURITY
 */
@Configuration
@EnableWebSecurity
public class UserSecurity extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf()
                .disable()
                .authorizeHttpRequests()
                .antMatchers("/users/**")
                .authenticated()
                .and()
                .httpBasic();
    }
}
