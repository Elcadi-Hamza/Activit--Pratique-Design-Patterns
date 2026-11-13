package aspects;

import metier.Compte;
import metier.MetierImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PatchAspect {
    @Around("execution(* metier.MetierImpl.retirer(..))&&args(code,mt)")
    public void patch(Long code, double mt, JoinPoint joinPoint, ProceedingJoinPoint
            proceedingJoinPoint) throws Throwable {
        MetierImpl metier=(MetierImpl) joinPoint.getTarget();
        Compte cp=metier.getCompte(code);
        if(cp.getSolde()>mt) {
            Object o = proceedingJoinPoint.proceed();
        }
        else
            throw new RuntimeException("Solde insuffisant");
    }
}
