package com.med.rest.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.med.rest.domain.entitys.User;

@Service
public class TokenService {

    //Puxando valor da application.properties
    @Value("${security.token.secret}")
    private String secret;

    public TokenJWTDTO createTokenJWT(User user) throws Exception {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                              .withIssuer("API Medic")
                              .withSubject(user.getLogin())
                              .withExpiresAt(this.expiredDate())
                              .sign(algorithm);

            return new TokenJWTDTO(user.getLogin(), token);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private Instant expiredDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String getSubject(String tokenJWT) {
        try {
            Algorithm algorithm =Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("API Medic")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("TokenJWT inválido ou expirado");
        }
    }
}
