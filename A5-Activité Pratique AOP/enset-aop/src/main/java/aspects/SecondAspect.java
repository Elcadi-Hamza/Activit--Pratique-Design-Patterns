package aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecondAspect {
    @Pointcut("execution(* test.*.main(..))")
    public void pc1(){}
    @Before("pc1()")
    public void beforeMain(){
        System.out.println("before main ---------------------------");
    }
    @After("pc1()")
    public void afterMain(){
        System.out.println("after main ---------------------------");
    }
}
