package com.maximus.simpleSpringSecurity.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure (HttpSecurity http) throws Exception {

        http.csrf().disable()

                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/private-data").hasRole("ADMIN")
                .antMatchers("/public-data").authenticated()
//                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER")
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        Map<String,PasswordEncoder> myEncoders = new HashMap<>();
        myEncoders.put("bcrypt", new BCryptPasswordEncoder());
        return new DelegatingPasswordEncoder("bcrypt", myEncoders);
    }

}
