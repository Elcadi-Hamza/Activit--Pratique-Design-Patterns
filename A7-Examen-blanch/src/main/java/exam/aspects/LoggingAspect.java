package exam.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    @Around("execution(* exam..*.*(..)) && !within(exam.aspects..*)")
    public Object log(ProceedingJoinPoint jp) throws Throwable {
        String name = jp.getSignature().toShortString();
        logger.info("-> " + name);
        long start =  System.currentTimeMillis();
        try {
            Object result = jp.proceed();
            long duration = System.currentTimeMillis() - start;
            logger.info("[LOG] <- " + name + " (" + duration + " ms)");
            return result;
        } catch (Throwable e) {
            logger.severe("[LOG] !! " + name + " : " + e);
            throw e;
        }
    }
}

