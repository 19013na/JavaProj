package lab.bank.control;
import lab.bank.entity.*;

public class BankDemo {

	public static void main(String[] args) {
		Bank bankA = new Bank();
		
		System.out.println("=== 계좌 생성 ===");
		String act1 = bankA.createSavingsAccount("홍길동", 10000, 0.03);
		String act2 = bankA.createCheckingAccount("김철수", 20000, 5000);
		String act3 = bankA.createSavingsAccount("이영희", 30000, 0.02);
		
		System.out.println("=== 모든 계좌 목록 ===");
		bankA.printAllAccounts();
		System.out.println("==================");
		
		System.out.println("=== 입금/출금 테스트 ===");
		bankA.deposit("AC0000", 5000);
		bankA.withdraw("AC0001", 3000);
		
		System.out.println("=== 이자 적용 테스트 ===");
		bankA.printSavingAccount();
		
		System.out.println("=== 계좌 이체 테스트 ===");
		bankA.transfer("AC0002", "AC0001", 5000);
		
		System.out.println("=== 모든 계좌 목록 ===");
		bankA.printAllAccounts();
		
		System.out.println("==================");
		bankA.withdraw("AC0001", 6000);
		bankA.withdraw("AC0012", 3000);
	
	}

}
