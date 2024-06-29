package com.facimath.facimath.service;

import com.facimath.facimath.dto.UserDto;
import com.facimath.facimath.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;

    public String generation(UserDto user) {
        return Jwts.builder()
                .claim("firstName", user.getFirstName())
                .claim("lastName", user.getLastName())
                .claim("id", user.getId())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public UserDto getUser(String token) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);

        UserDto user = new UserDto();
        user.setFirstName(claims.getBody().get("firstName", String.class));
        user.setLastName(claims.getBody().get("lastName", String.class));
        user.setId(claims.getBody().get("id", Long.class));

        return user;
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