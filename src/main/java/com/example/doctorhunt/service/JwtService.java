package com.example.doctorhunt.service;


import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")  
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expirationMs;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false; 
        }
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    public Long extractUserId(String token) {
        String userId = extractClaim(token, Claims::getSubject);
        return Long.parseLong(userId); 
    }
    

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }
}
