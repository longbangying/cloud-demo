package com.xbang.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //http.authorizeRequests().mvcMatchers("/oauth/**").permitAll();

        http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/oauth/**").permitAll()
                .antMatchers("/tProduct/**").permitAll()
                .antMatchers("/registered","/tRoleInfo/**","/wechat/**").permitAll()
                .antMatchers("/user/**").hasRole("ADMIN")
                .antMatchers("/limit/**").hasRole("MEMBER")
                .antMatchers("/**").hasRole("ORDINARY")
                .and()
                .formLogin();
    }
}
