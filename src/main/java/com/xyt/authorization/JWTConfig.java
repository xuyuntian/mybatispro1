package com.xyt.authorization;

import com.auth0.jwt.algorithms.Algorithm;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class JWTConfig {
    private static Algorithm algorithm = null;
    static {
        resetAlgorithm();
    }
    public static void resetAlgorithm(){
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keyPairGenerator.initialize(1024,new SecureRandom());
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        algorithm = Algorithm.RSA256(publicKey, privateKey);
    }
    public static Algorithm getAlgrithom() throws NoSuchAlgorithmException {
       return algorithm;
    }
}
