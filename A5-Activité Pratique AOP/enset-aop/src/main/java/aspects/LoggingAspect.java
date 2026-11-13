package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger=Logger.getLogger(this.getClass().getName());
    public LoggingAspect() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);
    }
    long t1,t2;
    @Pointcut("execution(* metier.MetierImpl.*(..))")
    public void pc1(){}

    @Before("pc1()")
    public void avant(JoinPoint joinPoint){
        t1 = System.currentTimeMillis();
//        System.out.println("Avant "+joinPoint.getSignature()+" --------------------------");
        logger.info("Avant "+joinPoint.getSignature()+" --------------------------");
    }

    @After("pc1()")
    public void apres(JoinPoint joinPoint){
        t2 = System.currentTimeMillis();
//        System.out.println("Apres "+joinPoint.getSignature()+" --------------------------");
//        System.out.println("Durre dexecution : "+ (t2-t1) );
//        System.out.println("-----------------------------------");
        logger.info("Apres "+joinPoint.getSignature()+" --------------------------");
        logger.info("Durre dexecution : "+ (t2-t1) );
        logger.info("-----------------------------------");
    }
}
