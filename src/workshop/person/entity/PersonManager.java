package workshop.person.entity;
import workshop.person.entity.PersonEntity;

public class PersonManager {
	
	// 생성자
	public PersonManager() {
		super();
	}
	
	public static void main(String[] args) {
		PersonManager pManager = new PersonManager();
		pManager.printTitle("인물 정보 조회 시스템");
		
		PersonEntity[] persons = new PersonEntity[10];
		pManager.fillPersons(persons);
		pManager.showPerson(persons);
		int genderCount = pManager.findByGender(persons, '여');
		pManager.printTitleLine();
		
		pManager.showPerson(persons, "김하늘");
	}
	
	public void printTitle(String Title) {
		System.out.println("@@@ " + Title + " @@@");
		printTitleLine();
	}
	
	public void printTitleLine() {
		
		for(int i=0; i<60; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	public void fillPersons(PersonEntity[] persons) {
		persons[0] = new PersonEntity("이성호", "7212121028102", "인천 계양구", "032-392-2932");
        persons[1] = new PersonEntity("김하늘", "7302132363217", "서울 강동구", "02-362-1932");
        persons[2] = new PersonEntity("박영수", "7503111233201", "서울 성북구", "02-887-1542");
        persons[3] = new PersonEntity("나인수", "7312041038988", "대전 유성구", "032-384-2223");
        persons[4] = new PersonEntity("홍정수", "7606221021341", "서울 양천구", "02-158-7333");
        persons[5] = new PersonEntity("이미숙", "7502142021321", "서울 강서구", "02-323-1934");
        persons[6] = new PersonEntity("박성구", "7402061023101", "서울 종로구", "02-308-0932");
        persons[7] = new PersonEntity("유성미", "7103282025101", "서울 은평구", "02-452-0939");
        persons[8] = new PersonEntity("황재현", "7806231031101", "인천 중구", "032-327-2202");
        persons[9] = new PersonEntity("최철수", "7601211025101", "인천 계양구", "032-122-7832");
	}
	
	public void showPerson(PersonEntity[] persons) {
		for(PersonEntity person : persons) {
			System.out.println("[이름] " + person.getName()
								+ "\t[성별] " + person.getGender()
								+ "\t[전화번호] " + person.getPhone() + "\t");
			printLine();
		}
	}
	
	
	public int findByGender(PersonEntity[] persons, char gender) {
		int gCount = 0;
		for(PersonEntity person : persons) {
			char g = person.getGender();
			// char 타입은 primitive 타입으로 값을 비교할 때 == 연산자를 사용해도 됨.
			gCount += g == gender ? 1 : 0;
		}
		System.out.println("성별 : '" + gender +"'(은)는 " + gCount + "명 입니다." );
		return gCount;
	}
	
	public void showPerson(PersonEntity[] persons, String name) {
		for(PersonEntity person : persons) {
			// String은 reference 타입이므로 값을 비교할 때 equals() 메서드를 사용해야 함.
			if (person.getName().contentEquals(name)) {
				System.out.println("-- 이름 : '" + person.getName() + "'(으)로 찾기 결과입니다.");
				printLine();
				System.out.println();
				System.out.println("[이름] " + person.getName());
                System.out.println("[성별] " + person.getGender());
                System.out.println("[전화번호] " + person.getPhone());
                System.out.println("[주소] " + person.getAddress());
                return;
			}
		}
		System.out.println("찾을 수 없음");
	}
	
	public void printLine() {
	    for (int i = 0; i < 60; i++) {
	        System.out.print("-");
	    }
	    System.out.println(); // 줄 바꿈
	}
}
