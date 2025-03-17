//package com.ecommerceProject.ecom.utils;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//@Component
//public class JwtUtil {
//
//    @Value("${jwt.secret:defaultBase64EncodedSecretKey}") // Default to avoid null issues
//    private String secretKeyString;
//
//    private SecretKey secretKey;
//
//    @PostConstruct
//    public void init() {
//        if (secretKeyString == null || secretKeyString.equals("defaultBase64EncodedSecretKey")) {
//            throw new IllegalStateException("JWT secret key is not set! Check application.properties or environment variables.");
//        }
//        byte[] keyBytes = Decoders.BASE64.decode(secretKeyString);
//        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
//    }
//
//    public String generateToken(String userName) {
//        Map<String, Object> claims = new HashMap<>();
//        return createToken(claims, userName);
//    }
//
//    private String createToken(Map<String, Object> claims, String userName) {
//        return Jwts.builder()
//                .claims(claims)
//                .subject(userName)
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + 1000L * 60 * 30))
//                .signWith(secretKey)
//                .compact();
//    }
//
//    public String extractUserName(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
//    }
//
//    private Boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    public Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//
//    public boolean validateToken(String token, UserDetails userDetails) {
//        final String username = extractUserName(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//}
