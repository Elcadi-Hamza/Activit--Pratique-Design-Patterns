# Activité Pratique N°5 - Activité Pratique AOP

Nom et prénom : Elcadi Hamza  
Filière : GLSID-3  
Références : 
- https://www.youtube.com/watch?v=2tex4z9rwag
- https://www.youtube.com/watch?v=8dPXOKR3AN8
- https://www.youtube.com/watch?v=NLhjdiFq63I

---
# 1 - Premier reference :
## 1 - Configuration de projet
On ajoutons le plugin AspectJ \
![aspectJ](../screenShots/A5/0.png) \
et puis on ajoutons en installer aspectj from website https://github.com/eclipse-aspectj/aspectj/releases/tag/V1_9_23?utm_source=chatgpt.com \
![aspectJ](../screenShots/A5/1.png) \
on creer le projet
![creation de projet](../screenShots/A5/2.png) \
et on ajoutons la libriry
![lajoute de library](../screenShots/A5/3.png) \

puis on ajoutons la facete aspectj
![lajoute de library](../screenShots/A5/4.png) \

## 2 - Creation de simple fonctionalites metier
on creer un class `Application`
```java
public class Application {
    public static void main(String[] args) {
        System.out.println("Message From Application");
    }

}
```
## 3 - creation dun aspect avec aspectJ syntax
on ajoutons un aspect avant et apres l'execution de la methode.
```java
public aspect FirstAspect {
    pointcut pc1(): execution(* test.Application.main(..));

    before():pc1(){
        System.out.println("before main ---------------------");
    }
    after():pc1(){
        System.out.println("after main ---------------------");
    }
}
```
et on changer le compilateur \
![lajoute de library](../screenShots/A5/5.png) \

![output](../screenShots/A5/6.png) \
on essay arround 
```java
void around():pc1(){
    System.out.println("before ---------------------------");
    proceed();
    System.out.println("after ---------------------------");

}
```
![output](../screenShots/A5/6.png) \

## 4 - Creation d'aspect avec class syntax
on creer un aspect `SecondAspect`
```java
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
```
![output](../screenShots/A5/7.png) \
on test l'evenement around
```java
@Around("pc1()")
public void aroundMain(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    System.out.println("before main ---------------------------");
    proceedingJoinPoint.proceed();
    System.out.println("after main ---------------------------");

}
```
![output](../screenShots/A5/7.png) \

# 2 - Deuxieme reference :
on creer les class :
- `metier.Compte`
```java
public class compte {
    private Long code;
    private double solde;

    public compte(Long code, double solde) {
        this.code = code;
        this.solde = solde;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}
```
- `metier.IMetier`
```java

```
