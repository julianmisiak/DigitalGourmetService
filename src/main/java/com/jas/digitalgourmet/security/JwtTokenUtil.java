package com.jas.digitalgourmet.security;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jas.digitalgourmet.controller.dto.JwtCredentials;
import static com.jas.digitalgourmet.util.Constant.ISSUER_INFO;
import static com.jas.digitalgourmet.util.Constant.SUPER_SECRET_KEY;

@Component
public class JwtTokenUtil {

    public String generateJWT(JwtCredentials jwtCredentials) throws UnsupportedEncodingException {
        return JWT.create()
                .withHeader(this.headerClaims())
                .withIssuer(ISSUER_INFO)
                .withClaim("username", jwtCredentials.getUserName())
                .withClaim("password", jwtCredentials.getPassword())
                .withExpiresAt(new Date(System.currentTimeMillis() + (4 * 60 * 1000))) // 5 minutos
                .sign(Algorithm.HMAC512(SUPER_SECRET_KEY));
    }

    private Map<String, Object> headerClaims() {
        Map<String, Object> headerClaims = new HashMap<>();
        headerClaims.put("typ", "JWT");

        return headerClaims;
    }

    JwtCredentials getDatosToken(String header) throws UnsupportedEncodingException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC512(SUPER_SECRET_KEY))
                                                    .withIssuer(ISSUER_INFO)
                                                    .build();
        DecodedJWT jwt = verifier.verify(header);
        return new JwtCredentials(jwt.getClaim("username").asString(), jwt.getClaim("password").asString());
    }
}
