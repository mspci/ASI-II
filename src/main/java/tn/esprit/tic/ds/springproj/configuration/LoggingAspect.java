package tn.esprit.tic.ds.springproj.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before("execution(* tn.esprit.tic.ds.springproj.services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In Method: " + name + " : ");
    }

    @After("execution(* tn.esprit.tic.ds.springproj.services.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of Method: " + name + " : ");
    }

    @AfterReturning("execution(* tn.esprit.tic.ds.springproj.services.*.*(..))")
    public void logMethodExitAfterReturn(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Method: " + name + " returned successfully.");
    }

    @AfterThrowing("execution(* tn.esprit.tic.ds.springproj.services.*.*(..))")
    public void logMethodExitAfterThrowing(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Method: " + name + " threw an exception.");
    }

    @Around("execution(* tn.esprit.tic.ds.springproj.services.*.*(..))")
    public Object logMethodAround(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }
}
