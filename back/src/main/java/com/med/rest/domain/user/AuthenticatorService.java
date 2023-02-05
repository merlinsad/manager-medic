package com.med.rest.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.med.rest.domain.repository.UserRepository;

@Service
public class AuthenticatorService implements UserDetailsService {
    // Classe responsável por autenticar o usuário implementando classe padrão de
    // autenticação do Spring Security

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }

}