package com.xbang.oauthserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/tRoleInfo/**").permitAll()
            .antMatchers("/oauth/**").permitAll()
            .antMatchers("/oauth/authorize").permitAll()
            .antMatchers("/oauth/token").permitAll()
            .antMatchers("/oauth/check_token").permitAll()
            .antMatchers("/tUserInfo/**").permitAll()
            .antMatchers("/tRoleInfo/**").permitAll()
            .antMatchers("/tUserRoleMap/**").permitAll()
            .antMatchers("/limit/**").hasRole("MEMBER")
            .antMatchers("/**").hasRole("ORDINARY")
            .and()
            .formLogin();
        http.csrf().disable();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

    }
}
