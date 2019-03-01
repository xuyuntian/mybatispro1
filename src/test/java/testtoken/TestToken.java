package testtoken;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.xyt.Application;
import com.xyt.authorization.JWTConfig;
import com.xyt.authorization.MyJwt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestToken {
    @Autowired
    private MyJwt myJwt;
    @Test
    public void testType() throws NoSuchAlgorithmException {
        String token = myJwt.createToken(1,0);
        myJwt.jwtVerifier().verify(token);
    }
    @Test
    public void TestToken() throws NoSuchAlgorithmException {

        Algorithm algorithm = JWTConfig.getAlgrithom();
        String token = null;
        try {
            token = JWT.create()
                    .withIssuer("auth0")
                    .sign(algorithm);
            System.out.println(token);//eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJhdXRoMCJ9.NkxkTvDFlDyGcldQjcQxfA4MoUQo_sAiUuo_9ssiwPW4PfbitcnUsFperFwVT3A3CodamMpGjzxx6FoS_CXG49OlnOn2a3Un6XSQq-aC8FNlMgELHod-nzuybATz9oucnnMp-7WAwcpvdTF9ER_LlL1qasRp8m1a8CWfVQ3DxDg
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
            exception.printStackTrace();
        }
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(token);

    }
    @Test
    public void testExample() throws NoSuchAlgorithmException {
        String token = null;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Algorithm algorithm = Algorithm.RSA256(publicKey, privateKey);
        try {
              token = JWT.create()
                    .withIssuer("auth0")
                    .sign(algorithm);
            System.out.println(token);//eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJhdXRoMCJ9.VM5OvENJqH-ZDeho54FBh1d_teAjr66vfghNQ3WUaZiU-DUGMtF7wgoh2GBaiqMeYe6kA2PUZc5KRifm4KBU2xDH8SFhpJ8WGQutsXFsUu7mQmJ5_jX5nsawIIHOh3jNkPd9scKvpAqXgAdPXrCcalfeJObh9ZhxUCx6jyMRNhs
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
            exception.printStackTrace();
        }
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);

    }
}
