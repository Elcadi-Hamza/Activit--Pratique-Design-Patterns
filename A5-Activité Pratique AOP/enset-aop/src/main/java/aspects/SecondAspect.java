package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class SecondAspect {
    @Pointcut("execution(* test.*.main(..))")
    public void pc1(){}
//    @Before("pc1()")
//    public void beforeMain(){
//        System.out.println("before main ---------------------------");
//    }
//    @After("pc1()")
//    public void afterMain(){
//        System.out.println("after main ---------------------------");
//    }
    @Around("pc1()")
    public void aroundMain(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before main ---------------------------");
        proceedingJoinPoint.proceed();
        System.out.println("after main ---------------------------");

    }
}
