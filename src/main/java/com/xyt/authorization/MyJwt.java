package com.xyt.authorization;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.xyt.annotation.GetToken;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
@Component
public class MyJwt {
    @GetToken
    public String createToken(String email,String type) throws NoSuchAlgorithmException {
      return JWT.create().withIssuer("auth0").withClaim("email",email).withClaim("type",type)
               .sign(JWTConfig.getAlgrithom());
    }
    public JWTVerifier jwtVerifier(String email,String type) throws NoSuchAlgorithmException {
       JWTVerifier jwtVerifier = JWT.require(JWTConfig.getAlgrithom()).withIssuer("auth0")
               .withClaim("type",type).withClaim("email",email).build();
       return jwtVerifier;
    }
}
