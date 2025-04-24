package lab.bank.control;
import lab.bank.entity.*;

public class BankDemo {

	public static void main(String[] args) {
		Bank bankA = new Bank();
		
		System.out.println("=== ���� ���� ===");
		String act1 = bankA.createSavingsAccount("ȫ�浿", 10000, 0.03);
		String act2 = bankA.createCheckingAccount("��ö��", 20000, 5000);
		String act3 = bankA.createSavingsAccount("�̿���", 30000, 0.02);
		
		System.out.println("=== ��� ���� ��� ===");
		bankA.printAllAccounts();
		System.out.println("==================");
		
		System.out.println("=== �Ա�/��� �׽�Ʈ ===");
		bankA.deposit("AC1000", 5000);
		bankA.withdraw("AC1000", 3000);
		
		System.out.println("=== ���� ���� �׽�Ʈ ===");
		
		System.out.println("=== ���� ��ü �׽�Ʈ ===");
		
		System.out.println("=== ��� ���� ��� ===");
		bankA.printAllAccounts();
		System.out.println("==================");
		
	}

}
