import main.AccountStatus;
import main.AccountType;
import main.BankAccount;

public class Main {
    public static void main(String[] args){
        BankAccount bankAccount = BankAccount.builder()
                .accountId(1L)
                .currency("MAD")
                .status(AccountStatus.CREATED)
                .type(AccountType.SAVING_ACCOUNT)
                .balance(74000)
                .build();
        System.out.println(bankAccount);
    }
}
