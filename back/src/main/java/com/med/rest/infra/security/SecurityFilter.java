package com.med.rest.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.med.rest.domain.repository.UserRepository;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired(required = false)
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenJWT = this.requestToken(request);
        if(StringUtils.isNotBlank(tokenJWT)) {
            String subject = tokenService.getSubject(tokenJWT);
            UserDetails user = userRepository.findByLogin(subject);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        //Chamar o próximo filtro e continuar o processo
        filterChain.doFilter(request, response);
    }

    private String requestToken(HttpServletRequest request) {
        String authotiServletRequest = request.getHeader("Authorization");
        if(StringUtils.isNotBlank(authotiServletRequest)) {
            return authotiServletRequest.replace("Bearer ", "");
        }

        return null;
    }

}
