package repository;

import main.AccountStatus;
import main.AccountType;
import main.BankAccount;
import main.BankDirector;

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
        Long accountId = ++accountsCount;
        bankAccount.setAccountId(accountId);
        bankAccountMap.put(accountId, bankAccount);
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
            BankAccount bankAccount = BankDirector.accountBuilder()
                    .balance(18000+Math.random()*9000)
                    .type(Math.random()>0.5? AccountType.SAVING_ACCOUNT : AccountType.CURRENT_ACCOUNT)
                    .status(Math.random() >0.5? AccountStatus.CREATED : AccountStatus.ACTIVATED)
                    .currency(Math.random()>0.5?"MAD":"USD")
                    .build();
            save(bankAccount);
        }
    }
}
