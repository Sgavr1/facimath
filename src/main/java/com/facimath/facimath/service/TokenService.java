package com.facimath.facimath.service;

import com.facimath.facimath.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;

    public String generation(User user) {
        return Jwts.builder()
                .claim("user", user)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public User getUser(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody().get("user", User.class);
    }

    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}