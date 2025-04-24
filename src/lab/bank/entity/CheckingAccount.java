package lab.bank.entity;

import lab.bank.exception.InsufficientBalanceException;
import lab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
	
	// 출금 한도 금액
	private double withdrawalLimit;
	
	public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
		super(accountNumber, ownerName, initialBalance);
		this.withdrawalLimit = withdrawalLimit;
	}
	
	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	
	@Override
	public void withdraw(double amount) throws InsufficientBalanceException, WithdrawalLimitExceededException{
		if (withdrawalLimit < amount) {
			throw new WithdrawalLimitExceededException("출금 한도 초과 되었습니다. (출금 한도 금액 : " + withdrawalLimit + ")");
		}
		super.withdraw(amount);
	}
	
	@Override
	public String toString() {
	    return super.toString() + String.format(", 출금 한도: %.1f원", withdrawalLimit);
	}
}
