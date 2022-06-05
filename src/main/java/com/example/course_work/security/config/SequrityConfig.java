package com.example.course_work.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SequrityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/users").authenticated()
                .antMatchers("/addUsers").permitAll()
                .and().formLogin()
                .loginPage("/signIn")
                .usernameParameter("lastName")
                .defaultSuccessUrl("/users")
                .failureUrl("/signIn")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth_b) throws Exception{
        auth_b.userDetailsService(userDetailsService);
    }
}
