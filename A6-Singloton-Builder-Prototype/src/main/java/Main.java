import main.AccountStatus;
import main.AccountType;
import main.BankAccount;
import main.BankDirector;
import repository.BankAccountRepositoryImpl;

import java.util.List;

public class Main {
    public static void main(String[] args){
//        BankAccount bankAccount = BankAccount.builder()
//                .accountId(1L)
//                .currency("MAD")
//                .status(AccountStatus.CREATED)
//                .type(AccountType.SAVING_ACCOUNT)
//                .balance(74000)
//                .build();
//        BankAccount bankAccount = BankDirector.accountBuilder()
//                .accountId(1L)
//                .currency("MAD")
//                .status(AccountStatus.CREATED)
//                .type(AccountType.SAVING_ACCOUNT)
//                .balance(75000)
//                .build();
//        System.out.println(bankAccount);
        BankAccountRepositoryImpl repository = new BankAccountRepositoryImpl();
        repository.populateData();
        List<BankAccount> bankAccounts = repository.findAll();
        bankAccounts.forEach(System.out::println);
    }
}
