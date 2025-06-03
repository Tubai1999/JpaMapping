package com.springDataJpaMapping.Mapping.service;

import com.springDataJpaMapping.Mapping.Entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    String key = "sjdfbjsbfjsebjfdjfhgburbgdjhbdejg";

    SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
    public String generateToken(User user){
            return Jwts.builder()
                    .setSubject(user.getId().toString())
                    .claim("email",user.getEmail())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis()+1000*60))
                    .signWith(secretKey)
                    .compact();
    }

//    public Long geyKey(String token){
//        Claims claims = Jwts.parserBuilder()
//                .setSigningKey(secretKey)
//                .build()
//                .
//    }
}
