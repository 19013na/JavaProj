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
	
	public Account findAccount(String accountNumber) {
		for(Account account : accounts) {
			if(account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		return null;
	}
	
	// �Ա�
	public void deposit(String accountNumber, double amount) {
		Account account = findAccount(accountNumber);
		account.deposit(amount);
		System.out.println(amount + "���� �ԱݵǾ����ϴ�. ���� �ܾ�: " + account.getinitialBalance() + "�� ");
	}
	
	// ���
	public void withdraw(String accountNumber, double amount) {
	    Account account = findAccount(accountNumber);
	    if (account != null) {
	        try {
	            account.withdraw(amount);
	        	System.out.println(amount + "���� ��ݵǾ����ϴ�. ���� �ܾ�: " + account.getinitialBalance() + "�� ");
	        } catch (InsufficientBalanceException | WithdrawalLimitExceededException e) {
	            System.out.println("���� �߻�: " + e.getMessage());
	        }
	    } else {
	        System.out.println("���� �߻�: ���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.");
	    }
	}
	
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws AccountNotFoundException{
		Account fromAccount = findAccount(fromAccountNumber);
		Account toAccount = findAccount(toAccountNumber);
		
		if(fromAccount != null && toAccount != null) {
			try {
				fromAccount.withdraw(amount);
				toAccount.deposit(amount);
			}catch(InsufficientBalanceException | WithdrawalLimitExceededException e) {
				System.out.println("��ü ���� : " + e.getMessage());
			}
		} else {
			throw new AccountNotFoundException("���¸� ã�� �� �����ϴ�.");
		}
	}
	
	public void printAllAccounts() {
		for(Account account : accounts) {
			account.toString();
		}
	}
	
	private String generateAccountNumber() {
		return String.format("AC%04d", nextAccountNumber++);
	}
}
