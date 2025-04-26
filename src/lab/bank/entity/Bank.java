package lab.bank.entity;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import lab.bank.exception.InsufficientBalanceException;
import lab.bank.exception.WithdrawalLimitExceededException;


public class Bank {
	
	private List<Account> accounts;
	private int nextAccountNumber;
	
	public Bank() {
		accounts = new ArrayList<>();
	}
	
	public String createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
		String accountNumber = generateAccountNumber();
		Account account = new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate);
		accounts.add(account);
		System.out.println("���� ���°� �����Ǿ����ϴ�: ���¹�ȣ: " + accountNumber 
							+ ", ������: " + ownerName
							+ ", �ܾ�: " + initialBalance
							+ ", ������: " + interestRate
							+ "%");
		return accountNumber;
	}
	
	public String createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
		String accountNumber = generateAccountNumber();
        Account account = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
        accounts.add(account);
		System.out.println("üŷ ���°� �����Ǿ����ϴ�: ���¹�ȣ: " + accountNumber 
							+ ", ������: " + ownerName
							+ ", �ܾ�: " + initialBalance
							+ ", ��� �ѵ�: " + withdrawalLimit
							+ "��");
        return accountNumber;
	}
	
	public Account findAccount(String accountNumber) throws AccountNotFoundException{
		for(Account account : accounts) {
			if(account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		throw new AccountNotFoundException("���¹�ȣ " + accountNumber +"�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.");	
	}
	
	// �Ա�
	public void deposit(String accountNumber, double amount) {
		try {
			Account account = findAccount(accountNumber);
			account.deposit(amount);
			System.out.println(amount + "���� �ԱݵǾ����ϴ�. ���� �ܾ�: " + account.getinitialBalance() + "�� ");
		}catch (AccountNotFoundException e) {
	    	System.out.println("���� �߻� : " + e.getMessage());
	    }
	}
	
	// ���
	public void withdraw(String accountNumber, double amount) {
	    try {
	    	Account account = findAccount(accountNumber);    
	    	account.withdraw(amount);
	        System.out.println(amount + "���� ��ݵǾ����ϴ�. ���� �ܾ�: " + account.getinitialBalance() + "�� ");
	    }catch (AccountNotFoundException e) {
	    	System.out.println("���� �߻� : " + e.getMessage());
	    }catch (InsufficientBalanceException | WithdrawalLimitExceededException e) {
	            System.out.println("���� �߻�: " + e.getMessage());
	    }
	}
	
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount){	
		try {
			Account fromAccount = findAccount(fromAccountNumber);
			Account toAccount = findAccount(toAccountNumber);
			
			fromAccount.withdraw(amount);
			toAccount.deposit(amount);
			
			System.out.println(amount + "���� ��ݵǾ����ϴ�. ���� �ܾ�: " + fromAccount.getinitialBalance() + "��");
			System.out.println(amount + "���� �ԱݵǾ����ϴ�. ���� �ܾ�: " + toAccount.getinitialBalance() + "��");
			System.out.println(amount + "���� " + fromAccountNumber + "���� " + toAccountNumber + "�� �۱ݵǾ����ϴ�.");
		}catch(AccountNotFoundException e) {
			System.out.println("���� �߻� : " + e.getMessage());
		}catch(InsufficientBalanceException | WithdrawalLimitExceededException e) {
			System.out.println("���� �߻� : " + e.getMessage());
		}
	}
	
	public void printAllAccounts() {
		for(Account account : accounts) {
			System.out.println(account.toString());
		}
	}
	
	private String generateAccountNumber() {
		return String.format("AC%04d", nextAccountNumber++);
	}
	
	public void printSavingAccount() {
		for (Account acc : accounts) {
            if (acc instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount) acc;
                savingsAccount.applyInterest();
                System.out.println("���� " + savingsAccount.getInterestRate() * savingsAccount.getinitialBalance() + "���� ����Ǿ����ϴ�. ���� �ܾ�: " + savingsAccount.getinitialBalance() + "��");
            }
        }
	}
}
