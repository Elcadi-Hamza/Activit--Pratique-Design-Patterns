package repository;

import main.BankAccount;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface BankAccountRepository {
    BankAccount save(BankAccount bankAccount);
    List<BankAccount> findAll();
    Optional<BankAccount> findById(Long id);
    List<BankAccount> searchAccounts(Predicate<BankAccount> predicate); // if we dont know what parameter
    BankAccount update(BankAccount bankAccount);
    void deleteByid(Long id);
}
