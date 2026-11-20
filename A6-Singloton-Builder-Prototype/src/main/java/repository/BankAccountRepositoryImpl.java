package repository;

import main.BankAccount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BankAccountRepositoryImpl implements BankAccountRepository {
    private Map<Long, BankAccount> bankAccountMap = new HashMap<>();
    private long accountsCount=0;
    @Override
    public BankAccount save(BankAccount bankAccount) {
        long accountId = ++accountsCount;
        bankAccount.setAccountId(accountId);
        return bankAccount;
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountMap.values().stream().toList();
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        BankAccount account = bankAccountMap.get(id);
        if(account == null){
            return Optional.empty();
        }
        else {
            return Optional.of(account);
        }
    }

    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {

        return bankAccountMap.values().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        bankAccountMap.put(bankAccount.getAccountId(), bankAccount);
        return bankAccount;
    }

    @Override
    public void deleteByid(Long id) {
        bankAccountMap.remove(id);

    }

    public void populateData() {
        for(int i = 0 ; i < 10 ; i++){
            BankAccount bankAccount = new BankAccount();
        }
    }
}
