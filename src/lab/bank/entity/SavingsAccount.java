package lab.bank.entity;

public class SavingsAccount extends Account {
	// ÀÌÀÚÀ²
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

}
