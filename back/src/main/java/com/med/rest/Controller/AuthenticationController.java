package com.med.rest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.med.rest.domain.entitys.User;
import com.med.rest.domain.user.LoginDTO;
import com.med.rest.infra.security.TokenJWTDTO;
import com.med.rest.infra.security.TokenService;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired(required = false)
    private AuthenticationManager authenticManager;

    @Autowired(required = false)
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity doLogin(@RequestBody LoginDTO loginDTO) throws Exception {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDTO.getLogin(), loginDTO.getSenha());
        Authentication authentication = authenticManager.authenticate(token);
        User user = (User) authentication.getPrincipal();

        TokenJWTDTO tokenJWTDTO = tokenService.createTokenJWT(user);
        return ResponseEntity.ok(tokenJWTDTO);
    }
}
