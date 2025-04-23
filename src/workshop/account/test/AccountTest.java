package workshop.account.test;
import workshop.account.entity.Account;

// ctrl + shift + o

public class AccountTest {
	public static void main(String[] args) {
		Account account = new Account();
		account.setCustId("A1100");
		account.setAcctId("221-22-3477");
		account.setBalance(100000);
		System.out.println(account.getBalance());
		account.deposit(10000);
		System.out.println(account.getBalance());
		account.withdraw(20000);
		System.out.println(account.getBalance());		
	}	
}
