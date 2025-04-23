package workshop.account.test;
import workshop.account.entity.Account;
import workshop.account.exception.InsufficientBalanceException;

// ctrl + shift + o

public class AccountTest {
	public static void main(String[] args) {
		// Account °´Ã¼
		Account account = new Account("A1100", "221-22-3477", 100000);
		//System.out.println(account);	// account.toString()
		System.out.println(account.getBalance());
		account.deposit(10000);
		System.out.println(account.getBalance());
		try {
			account.withdraw(20000);
			System.out.println(account.getBalance());		
			account.withdraw(100000);
			System.out.println(account.getBalance());		
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}	
}
