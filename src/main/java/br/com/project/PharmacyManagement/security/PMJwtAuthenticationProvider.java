package br.com.project.PharmacyManagement.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

@Component
public class PMJwtAuthenticationProvider {

    private int expirationTime = 24 * 60 * 60 * 2;

    private String ultraPassword = "AMaeDeMariaTemTresFilhosJoseEJoaoQualONomeDoTerceiro";

    public String generateToken (String username){
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(new Date().getTime() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, ultraPassword)
                .compact();
        return token;
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(this.ultraPassword).parseClaimsJwt(token).getBody().getSubject();
    }

    public boolean isTokenValid(String token){
        try {
            Jwts.parser()
                    .setSigningKey(this.ultraPassword)
                    .parseClaimsJwt(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public String getToken(String authorization) {
        String token = authorization;

        if (StringUtils.hasText(token) && token.startsWith("Bearer")) {
            return token.substring(7,token.length());
        }
        return null;
    }
}
