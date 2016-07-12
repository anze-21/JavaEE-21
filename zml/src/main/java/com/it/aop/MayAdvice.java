package com.it.aop;

/**
 * Created by xieyue on 2016/7/2.
 * MayAdvice
 */


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;

@Named
@Aspect
public class MayAdvice {
    Logger logger = LoggerFactory.getLogger(MayAdvice.class);

    @Pointcut("execution(* com.it.mapper..*.*(..))")
    public void myPointCut(){}

    @Before("myPointCut()")
    public void beforeAdvice() {
        logger.debug("前置通知++++++++++++");
    }
    @AfterReturning(pointcut ="myPointCut()",returning = "result")
    public void afterReturningAdvice(Object result) {
        logger.debug("后置通知++++++++++++{}", result);
    }
    @AfterThrowing(pointcut = "myPointCut()",throwing = "e")
    public void exceptionAdvice(Exception e) {
        logger.debug(" encounter exception and detail is {}", e.getMessage());
    }
    @After("myPointCut()")
    public void finallyAdvice() {
        logger.debug(" this is the end ===========");
    }

    //@Around("myPointCut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        Object object = null;
        try {
            logger.debug(" this is aroundAdvice start");
            object = joinPoint.proceed();
            logger.debug("this is aroundAdvice normal over");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.debug(" this is aroundAdvice exception");
        } finally {
            logger.debug("this is aroundAdvice end ");
        }
        return object;
    }

}
