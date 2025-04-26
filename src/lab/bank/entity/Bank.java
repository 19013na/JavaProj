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
	
	public Account findAccount(String accountNumber) throws AccountNotFoundException{
		for(Account account : accounts) {
			if(account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		throw new AccountNotFoundException("계좌번호 " + accountNumber +"에 해당하는 계좌를 찾을 수 없습니다.");	
	}
	
	// 입금
	public void deposit(String accountNumber, double amount) {
		try {
			Account account = findAccount(accountNumber);
			account.deposit(amount);
			System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + account.getinitialBalance() + "원 ");
		}catch (AccountNotFoundException e) {
	    	System.out.println("예외 발생 : " + e.getMessage());
	    }
	}
	
	// 출금
	public void withdraw(String accountNumber, double amount) {
	    try {
	    	Account account = findAccount(accountNumber);    
	    	account.withdraw(amount);
	        System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + account.getinitialBalance() + "원 ");
	    }catch (AccountNotFoundException e) {
	    	System.out.println("예외 발생 : " + e.getMessage());
	    }catch (InsufficientBalanceException | WithdrawalLimitExceededException e) {
	            System.out.println("예외 발생: " + e.getMessage());
	    }
	}
	
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount){	
		try {
			Account fromAccount = findAccount(fromAccountNumber);
			Account toAccount = findAccount(toAccountNumber);
			
			fromAccount.withdraw(amount);
			toAccount.deposit(amount);
			
			System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + fromAccount.getinitialBalance() + "원");
			System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + toAccount.getinitialBalance() + "원");
			System.out.println(amount + "원이 " + fromAccountNumber + "에서 " + toAccountNumber + "로 송금되었습니다.");
		}catch(AccountNotFoundException e) {
			System.out.println("예외 발생 : " + e.getMessage());
		}catch(InsufficientBalanceException | WithdrawalLimitExceededException e) {
			System.out.println("예외 발생 : " + e.getMessage());
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
                System.out.println("이자 " + savingsAccount.getInterestRate() * savingsAccount.getinitialBalance() + "원이 적용되었습니다. 현재 잔액: " + savingsAccount.getinitialBalance() + "원");
            }
        }
	}
}
