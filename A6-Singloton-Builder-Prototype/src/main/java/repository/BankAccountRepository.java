package repository;

import main.BankAccount;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface BankAccountRepository {
    BankAccount save(BankAccount bankAccount);
    List<BankAccount> findAll();
    Optional<BankAccount> findById(long id);
    List<BankAccount> searchAccounts(Predicate<BankAccount>); // if we don know what parameter
    BankAccount update(BankAccount bankAccount);
    void deleteByid(long id);
}
