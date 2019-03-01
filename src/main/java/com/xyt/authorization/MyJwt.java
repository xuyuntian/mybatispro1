package com.xyt.authorization;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xyt.annotation.GetToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
@Component
public class MyJwt {
    @GetToken
    public String createToken(Integer userId,int type) throws NoSuchAlgorithmException {
      return JWT.create().withIssuer("auth0").withClaim("userId",userId).withClaim("type",0)
               .sign(JWTConfig.getAlgrithom());
    }
    public JWTVerifier jwtVerifier() throws NoSuchAlgorithmException {
       JWTVerifier jwtVerifier = JWT.require(JWTConfig.getAlgrithom()).withIssuer("auth0")
               .withClaim("type",0).build();
       return jwtVerifier;
    }
}
