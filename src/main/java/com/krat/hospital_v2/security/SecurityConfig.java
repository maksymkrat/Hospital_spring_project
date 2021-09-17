package com.krat.hospital_v2.security;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource);



        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("max").password("max").roles("ADMIN"))
                .withUser(userBuilder.username("patient").password("patient").roles("PATIENT"))
                .withUser(userBuilder.username("doctor").password("doctor").roles("DOCTOR"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("ADMIN", "PATIENT", "DOCTOR")
                .antMatchers("/patient_info/**").hasRole("PATIENT")
                .antMatchers("/doctor_info/**").hasRole("DOCTOR")
                .and().formLogin().permitAll();
    }
}
