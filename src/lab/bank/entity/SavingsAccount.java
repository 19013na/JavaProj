package lab.bank.entity;

public class SavingsAccount extends Account {
	// 이자율
	private double interestRate;
	
	public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
		super(accountNumber, ownerName, initialBalance);
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void applyInterest() {
		double newBalance = getinitialBalance()  * interestRate;
		deposit(newBalance);
	}

	@Override
	public String toString() {
		return super.toString() + String.format(", 이자율: %.1f%%", interestRate * 100);
	}
}
