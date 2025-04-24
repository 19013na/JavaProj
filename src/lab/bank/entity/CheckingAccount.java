package lab.bank.entity;

import lab.bank.exception.InsufficientBalanceException;
import lab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
	
	// ��� �ѵ� �ݾ�
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
			throw new WithdrawalLimitExceededException("��� �ѵ� �ʰ� �Ǿ����ϴ�. (��� �ѵ� �ݾ� : " + withdrawalLimit + ")");
		}
		super.withdraw(amount);
	}
	
	@Override
	public String toString() {
	    return super.toString() + String.format(", ��� �ѵ�: %.1f��", withdrawalLimit);
	}
}
