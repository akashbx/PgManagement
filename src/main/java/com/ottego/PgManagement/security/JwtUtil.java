package com.ottego.PgManagement.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf"; // store securely
    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours

    // Generate token with phone, id, and role
    public String generateToken(Long id, String phone, String role) {
        return Jwts.builder()
                .setSubject(phone)
                .claim("id", id)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }


    public Long extractId(String token) {
        return extractAllClaims(token).get("id", Long.class);
    }

    public String extractPhone(String token) {
        return getClaims(token).getSubject();
    }

    public Integer extractUserId(String token) {
        return (Integer) getClaims(token).get("id");
    }

    public String extractRole(String token) {
        return (String) getClaims(token).get("role");
    }

    public boolean validateToken(String token, String phone) {
        return phone.equals(extractPhone(token)) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
