package com.example.demospringsecurityjwt.generic.config.security.jwt;

import com.example.demospringsecurityjwt.member.domain.MemberRole;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtTokenProvider {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    private static final String AUTHORITIES_KEY = "role";

    private static final String NICK_NAME = "nick_name";

    public String generateToken(Long id, String role, String nickName) {

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(Long.toString(id))
                .claim(AUTHORITIES_KEY, role)
                .claim(NICK_NAME, nickName)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public JwtMember getJwtMemberData(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        Long id = Long.parseLong(claims.getSubject());
        String nickName = claims.get(NICK_NAME).toString();
        String role = claims.get(AUTHORITIES_KEY).toString();
        MemberRole memberRole = MemberRole.findRole(role);

        return JwtMember.of(id, nickName, memberRole);
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature", e);
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token", e);
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT token", e);
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JWT token", e);
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty.", e);
        }
        return false;
    }
}
