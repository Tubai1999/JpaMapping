package com.springDataJpaMapping.Mapping.service;

import com.springDataJpaMapping.Mapping.Entities.User;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {


    public String generateToken(User user){
            return Jwts.builder()
                    .setSubject(user.getId().toString())
                    .claim("email",user.getEmail())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis()+1000*60))
                    .compact();
    }
}
