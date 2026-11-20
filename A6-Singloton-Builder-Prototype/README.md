# Activité Pratique N°7- Patterns Création : Singleton, Builder, Prototype

Nom et prénom : Elcadi Hamza  
Filière : GLSID-3  
Référence : https://www.youtube.com/watch?v=c46mTB9o2qo

---

## 1 - Diagramme du pattern Adapter

On a commencé par créer les classes nécessaires pour implémenter le pattern Adapter.

![Diagramme du pattern Adapter](../screenShots/A3/0.png)

---

## Implémentation du diagramme de classes
On crée la classe `model.BankAccount` :
```java
public class BankAccount {
    private long accountId;
    private double balance;
    private String currency;
    private AccountType type;
    private AccountStatus status;
    
}
```
et ces enums, et on generate getters et setters et les constructeurs et `toString`.
- interface `repository.AccountRepository`
```java
public interface BankAccountRepository {
    BankAccount save(BankAccount bankAccount);
    List<BankAccount> findAll();
    Optional<BankAccount> findById(long id);
    List<BankAccount> searchAccounts(Predicate<BankAccount>); // if we don know what parameter
    BankAccount update(BankAccount bankAccount);
    void deleteByid(long id);
}
```

