package ma.enset.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LogAspect {
//    @Before("execution(* ma.enset.service.*.*(..))")
    @Around("execution(* ma.enset.service.*.*(..))")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long t1 = System.currentTimeMillis();
        System.out.println("From Logging Aspects ... Before " + proceedingJoinPoint.getSignature());
        Object result = proceedingJoinPoint.proceed();
        System.out.println("From Logging Aspects ... After " + proceedingJoinPoint.getSignature());
        System.out.println("Duration : " + (System.currentTimeMillis() - t1));
        return result;

    }
}
