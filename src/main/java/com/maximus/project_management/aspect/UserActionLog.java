package com.maximus.project_management.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class UserActionLog {

    @Around("@annotation(com.maximus.project_management.aspect.TrackUserAction)")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Вызывается метод  " + methodName + " с параметрами " + Arrays.asList(args));
        Object retMethod =  joinPoint.proceed(args);
        return retMethod;
    }

}
