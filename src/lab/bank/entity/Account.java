package lab.bank.entity;

import lab.bank.exception.*;

public class Account {
	
	private String accountNumber;
	private String ownerName;
	private double initialBalance;
	
	public Account(String accountNumber, String ownerName, double initialBalance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.initialBalance = initialBalance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public double getinitialBalance() {
		return initialBalance;
	}
	
	// 입금
	public void deposit(double amount) {
		initialBalance += amount;
	}
	
	// 출금
	public void withdraw(double amount) throws InsufficientBalanceException, WithdrawalLimitExceededException{
		if(initialBalance > amount) {
			initialBalance -= amount;
		} else {
			throw new InsufficientBalanceException("잔액이 부족합니다. (현재 잔액 : " + initialBalance + ")");
		}
	}
	
	@Override
	public String toString() {
	    return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원", accountNumber, ownerName, initialBalance);
	}
}
