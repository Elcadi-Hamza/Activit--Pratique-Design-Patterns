import main.AccountStatus;
import main.AccountType;
import main.BankAccount;
import main.BankDirector;
import repository.BankAccountRepositoryImpl;
import util.JsonSerializer;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
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
        /*
        JsonSerializer<BankAccount> bankAccountJsonSerializer = new JsonSerializer<>();
        BankAccountRepositoryImpl repository = new BankAccountRepositoryImpl();
        repository.populateData();
        List<BankAccount> bankAccounts = repository.findAll();
        bankAccounts.stream().map(acc->bankAccountJsonSerializer.toJson(acc)).forEach(System.out::println);
        System.out.println("############################################");
        BankAccount account = repository.findById(1L).orElse(null);
        if(account != null){
            System.out.println(bankAccountJsonSerializer.toJson(account));
        }
        System.out.println("Recherche ############################################");
        List<BankAccount> bankAccounts2 = repository.searchAccounts(new Predicate<BankAccount>() {
            @Override
            public boolean test(BankAccount bankAccount) {
                return bankAccount.getType().equals(AccountType.CURRENT_ACCOUNT);
            }
        });
        bankAccounts2.stream().map(acc->bankAccountJsonSerializer.toJson(acc)).forEach(System.out::println);

         */
        JsonSerializer<BankAccount> bankAccountJsonSerializer = new JsonSerializer<>();
        BankAccountRepositoryImpl repository = BankAccountRepositoryImpl.getInstance();
        for(int i = 0 ; i < 10 ; i++){
            new Thread(()-> {
                repository.populateData();
            }).start();
        }
        System.out.println("Tape a charter : ");
        System.in.read();
        List<BankAccount> bankAccounts = repository.findAll();
        bankAccounts.stream().map(acc->bankAccountJsonSerializer.toJson(acc)).forEach(System.out::println);
    }
}
