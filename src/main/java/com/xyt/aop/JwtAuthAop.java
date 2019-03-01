package com.xyt.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class JwtAuthAop {
    @Pointcut("@annotation(com.xyt.annotation.GetToken)")
    private void getToken(){}
    @Before("getToken()&&args(userId,type)")
    public void beforegetToken(Integer userId,int type){
        System.out.println("The userId is"+userId+"The type is"+type);
    }
}
