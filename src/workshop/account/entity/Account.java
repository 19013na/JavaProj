package workshop.account.entity;

public class Account {
	private String custId;
	private String acctId;
	private int balance;
	
	// setter
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	
	// getter
	public int getBalance() {
		return balance;
	}
	public String getCustId() {
		return custId;
	}
	public String getAcctId() {
		return acctId;
	}
	
	// �Ա�
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	// ��� 
	public void withdraw(int amount) {
		if(amount > balance) {
			System.out.println("�ܾ׺���");
		} else {
			this.balance -= amount;
		}
	}
}
