package com.med.rest.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations implements WebMvcConfigurer{

    @Autowired(required = false)
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // .csrf().disable() - Desativar esta segurança pois o próprio Token JWT é uma segurança contra CSRF - Cross-site Request Forgery
        // .sessionCreationPolicy(SessionCreationPolicy.STATELESS) - Desativar autenticação por forms, pois é uma API Rest, portanto autenticar Stateless
        // .requestMatchers(HttpMethod.POST, "/login").permitAll() - Por ser Stateless, eu libero a request login ser efetuada sem token e as demais eu bloqueio
        // .and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) - Ajusto a ordem dos filtros para que a minha autenticação seja a primeira na fila do Spring
        // .requestMatchers(HttpMethod.DELETE, "/medicos").hasRole("ADMIN") - Garante que só vai ser permitido deletar para tal URL quem tiver a Role ADMIN

        return httpSecurity.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/login").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/medicos").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder  passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}
