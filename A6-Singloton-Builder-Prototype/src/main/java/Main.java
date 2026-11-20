import main.AccountStatus;
import main.AccountType;
import main.BankAccount;
import main.BankDirector;
import repository.BankAccountRepositoryImpl;
import util.JsonSerializer;

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
        JsonSerializer<BankAccount> bankAccountJsonSerializer = new JsonSerializer<>();
        BankAccountRepositoryImpl repository = new BankAccountRepositoryImpl();
        repository.populateData();
        List<BankAccount> bankAccounts = repository.findAll();
        bankAccounts.stream().map(acc->bankAccountJsonSerializer.toJson(acc)).forEach(System.out::println);
    }
}
