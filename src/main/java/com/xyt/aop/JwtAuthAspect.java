package com.xyt.aop;

import com.xyt.authorization.ModifyState;
import com.xyt.authorization.MyJwt;
import com.xyt.authorization.RequestBodyData;
import com.xyt.entity.MyUser;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;

@Component
@Aspect
public class JwtAuthAspect {
    @Autowired
    private MyJwt myJwt;
    @Pointcut("@annotation(com.xyt.annotation.CheckModified)")
    private void needCertification(){}
    @Pointcut("@annotation(com.xyt.annotation.CheckDelete)")
    private void checkDel(){}
    @Before("needCertification()&&args(requestBodyData)")
    public void authToken(RequestBodyData requestBodyData) throws Throwable {
        String email = requestBodyData.getMyUser().getEmail();
        String type = requestBodyData.getMyUser().getType();
        String token = requestBodyData.getToken();
        try {
            myJwt.jwtVerifier(email,type).verify(token);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    @Before("checkDel()&&args(email,type,id,token)")
    public void ckeckDelete(String email,String type,Integer id,String token){
        try {
            myJwt.jwtVerifier(email,type).verify(token);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
