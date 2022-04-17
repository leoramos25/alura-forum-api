package br.com.leords.forum.configuration.security;

import br.com.leords.forum.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    
    private static final String API_NAME = "FORUM";
    @Value("${forum.jwt.expiration}")
    private String expiration;
    @Value("${forum.jwt.secret}")
    private String secret;
    
    public String generateToken(Authentication authenticate) {
        Date today = new Date();
        Date expirationDate = new Date(today.getTime() + Long.parseLong(expiration));
        User loggedUser = (User) authenticate.getPrincipal();
        return Jwts.builder()
                .setIssuer(API_NAME)
                .setSubject(loggedUser.getId().toString())
                .setIssuedAt(today)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    
    public boolean isValid(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception error) {
            return false;
        }
    }
    
    public Long getUserId(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
