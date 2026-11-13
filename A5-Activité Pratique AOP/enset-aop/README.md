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
## 1 - code metier :
on creer les class :
- `metier.Compte`
```java
public class Compte {
    private Long code;
    private double solde;

    public Compte(Long code, double solde) {
        this.code = code;
        this.solde = solde;
    }

    public Long getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "code=" + code +
                ", solde=" + solde +
                '}';
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
public interface IMetier {
    void addCompte(Compte cp);
    void verser(Long code,double mt);
    void retirer(Long code,double mt);
    Compte getCompte(Long code);
}
```
- `metier.MetierImpl`
```java
public class MetierImpl implements IMetier {
    private Map<Long,Compte> comptes=new HashMap<>();
    @Override
    public void addCompte(Compte cp) {
        comptes.put(cp.getCode(),cp);
    }
    @Override
    public void verser(Long code, double mt) {
        Compte cp=comptes.get(code);
        cp.setSolde(cp.getSolde()+mt);
    }
    @Override
    public void retirer(Long code, double mt) {
        Compte cp=comptes.get(code);
        cp.setSolde(cp.getSolde()-mt);
    }
    @Override
    public Compte getCompte(Long code) {
        return comptes.get(code);
    }
}
```
- 'test.Application'
```java
public class Application {
    public static void main(String[] args) {
        new Application().start();
    }
    private void start() {
        System.out.println("Starting Application .....");
        IMetier metier=new MetierImpl();
        Scanner clavier=new Scanner(System.in);
        System.out.print("Code:");Long code=clavier.nextLong();
        System.out.print("Solde:");double solde=clavier.nextDouble();
        metier.addCompte(new Compte(code,solde));
        while (true){
            try {
                System.out.println("=========================================");
                System.out.println(metier.getCompte(code).toString());
                System.out.print("Type Opération:");String type=clavier.next();
                if(type.equals("q")) break;
                System.out.print("Montant:");double montant=clavier.nextDouble();
                if(type.toLowerCase().equals("v")) metier.verser(code,montant);
                else if(type.toLowerCase().equals("r")) metier.retirer(code,montant);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
```
test : \
![output](../screenShots/A5/8.png) \
On vois que l'utilisateur peut entrer des montant superieur a solde et avoir un solde negative on va fixer ca par des aspects
## 2 - code Aspect
- `aspects.LoggingAspect`
```java

@Aspect
public class LoggingAspect {
    long t1,t2;
    @Pointcut("execution(* metier.MetierImpl.*(..))")
    public void pc1(){}

    @Before("pc1()")
    public void avant(JoinPoint joinPoint){
        t1 = System.currentTimeMillis();
        System.out.println("Avant "+joinPoint.getSignature()+" --------------------------");
    }

    @After("pc1()")
    public void apres(JoinPoint joinPoint){
        System.out.println("Apres "+joinPoint.getSignature()+" --------------------------");
        t2 = System.currentTimeMillis();
        System.out.println("Durre dexecution : "+ (t2-t1) );
        System.out.println("-----------------------------------");
    }
}
```
![output](../screenShots/A5/9.png) \
![output](../screenShots/A5/10.png) \
on ajoute un framework de journalisation
```java
@Aspect
public class LoggingAspect {
    private Logger logger=Logger.getLogger(this.getClass().getName());
    long t1,t2;
    @Pointcut("execution(* metier.MetierImpl.*(..))")
    public void pc1(){}

    @Before("pc1()")
    public void avant(JoinPoint joinPoint){
        t1 = System.currentTimeMillis();
        logger.info("Avant "+joinPoint.getSignature()+" --------------------------");
    }

    @After("pc1()")
    public void apres(JoinPoint joinPoint){
        t2 = System.currentTimeMillis();
        logger.info("Apres "+joinPoint.getSignature()+" --------------------------");
        logger.info("Durre dexecution : "+ (t2-t1) );
        logger.info("-----------------------------------");
    }
}
```
![output](../screenShots/A5/11.png) \

puis on savegarder dans un fichier :
```java
public LoggingAspect() throws IOException {
    logger.addHandler(new FileHandler("log.xml"));
    logger.setUseParentHandlers(false);
}
```
