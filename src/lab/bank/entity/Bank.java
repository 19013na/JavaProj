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
		System.out.println("저축 계좌가 생성되었습니다: 계좌번호: " + accountNumber 
							+ ", 소유자: " + ownerName
							+ ", 잔액: " + initialBalance
							+ ", 이자율: " + interestRate
							+ "%");
		return accountNumber;
	}
	
	public String createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
		String accountNumber = generateAccountNumber();
        Account account = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
        accounts.add(account);
		System.out.println("체킹 계좌가 생성되었습니다: 계좌번호: " + accountNumber 
							+ ", 소유자: " + ownerName
							+ ", 잔액: " + initialBalance
							+ ", 출금 한도: " + withdrawalLimit
							+ "원");
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
	
	// 입금
	public void deposit(String accountNumber, double amount) {
		Account account = findAccount(accountNumber);
		account.deposit(amount);
		System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + account.getinitialBalance() + "원 ");
	}
	
	// 출금
	public void withdraw(String accountNumber, double amount) {
	    Account account = findAccount(accountNumber);
	    if (account != null) {
	        try {
	            account.withdraw(amount);
	        	System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + account.getinitialBalance() + "원 ");
	        } catch (InsufficientBalanceException | WithdrawalLimitExceededException e) {
	            System.out.println("예외 발생: " + e.getMessage());
	        }
	    } else {
	        System.out.println("예외 발생: 계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
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
				System.out.println("이체 실패 : " + e.getMessage());
			}
		} else {
			throw new AccountNotFoundException("계좌를 찾을 수 없습니다.");
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
