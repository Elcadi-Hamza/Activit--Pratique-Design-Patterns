import main.AccountStatus;
import main.AccountType;
import main.BankAccount;
import main.Customer;

public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        BankAccount bankAccount1 = new BankAccount();
        bankAccount1.setAccountId(1L);
        bankAccount1.setBalance(1000);
        bankAccount1.setCurrency("MAD");
        bankAccount1.setStatus(AccountStatus.ACTIVATED);
        bankAccount1.setType(AccountType.SAVING_ACCOUNT);
        bankAccount1.setCustomer(new Customer(1L,"customer1"));
        BankAccount bankAccount2 = bankAccount1.clone();
        System.out.println(bankAccount1);
        System.out.println(bankAccount2);
        bankAccount1.getCustomer().setName("customerChanged1");
        System.out.println("Apres le changement de customer ##############################");
        System.out.println(bankAccount1);
        System.out.println(bankAccount2);

//        BankAccount bankAccount2 = new BankAccount();
//        bankAccount2.setAccountId(bankAccount1.getAccountId());
//        bankAccount2.setBalance(bankAccount1.getBalance());
//        bankAccount2.setCurrency(bankAccount1.getCurrency());
//        bankAccount2.setStatus(bankAccount1.getStatus());
//        bankAccount2.setType(bankAccount1.getType());
    }
}
