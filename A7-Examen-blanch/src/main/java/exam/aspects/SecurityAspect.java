package exam.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SecurityAspect {
    private static String currentUser = null;

    public static void login(String user, String password) {
        if ("admin".equals(user) && "1234".equals(password)) {
            currentUser = user;
        } else {
            throw new SecurityException("Identifiants invalides");
        }
    }

    public static void logout() { currentUser = null; }

    @Before("execution(* exam.NeuralNetwork.train(..)) " +
            "|| execution(* exam.NeuralNetwork.fit(..)) " +
            "|| execution(* exam.NeuralNetwork.predict(..))")
    public void checkAccess(JoinPoint jp) {
        if (currentUser == null) {
            throw new SecurityException("Accès refusé : authentification requise pour "
                    + jp.getSignature().getName());
        }
    }
}
