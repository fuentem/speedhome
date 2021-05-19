package com.speedhome.property.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	//temporarily hardcoded for sample user access
        auth.inMemoryAuthentication()
          .withUser("admin").password(passwordEncoder().encode("admin"))
          .authorities("ROLE_USER");
    }
    
    @Override
    public void configure(WebSecurity web)  {
    	//enable access to swagger and h2-console for api and data visibility
        web.ignoring().antMatchers("/v3/api-docs",
                "/swagger-ui.html",
                "/swagger-ui/**",
                "/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .csrf().disable()
        .authorizeRequests().anyRequest().authenticated()
        .and()
        .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}