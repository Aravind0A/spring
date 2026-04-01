package com.example.register.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
   
   
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
   
   
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable())
            .authorizeHttpRequests(request -> request
                .requestMatchers("/registration", "/css/**", "/js/**","/api/**").permitAll() 
                .anyRequest().permitAll())
            .formLogin(form -> form
                .defaultSuccessUrl("/create", true).permitAll())
				.formLogin(form -> form.disable())
				.httpBasic(httpBasic -> httpBasic.disable())
            .logout(form -> form
                .invalidateHttpSession(true).clearAuthentication(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout").permitAll());
           
        return http.build();
    }
}
