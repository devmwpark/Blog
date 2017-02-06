package com.blog.aspect;

import com.blog.web.error.exception.BindingResultHasErrorsException;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.Arrays;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */
@Component
@Aspect
@Slf4j
public class AspectBindingResultError {

    @Pointcut("execution(* com.blog.web.*Controller.*(..))")
    public void methodInControllers() {
    }

    @Before("methodInControllers()")
    public void aspectCheckBindingResultError(JoinPoint joinPoint) {
        Arrays.stream(joinPoint.getArgs())
                .filter(arg -> arg instanceof BindingResult)
                .findAny()
                .ifPresent(arg -> {
                    BindingResult result = (BindingResult)arg;
                    if( result.hasErrors() ){
                        log.debug("BindingResult hasErrors(), target: [{}], count: [{}]", result.getTarget(), result.getErrorCount());
                        throw new BindingResultHasErrorsException(result);
                    }
                });
    }
}
