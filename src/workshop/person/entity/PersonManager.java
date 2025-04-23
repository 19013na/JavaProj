package workshop.person.entity;
import workshop.person.entity.PersonEntity;

public class PersonManager {
	
	// ������
	public PersonManager() {
		super();
	}
	
	public static void main(String[] args) {
		PersonManager pManager = new PersonManager();
		pManager.printTitle("�ι� ���� ��ȸ �ý���");
		
		PersonEntity[] persons = new PersonEntity[10];
		pManager.fillPersons(persons);
		pManager.showPerson(persons);
		int genderCount = pManager.findByGender(persons, '��');
		pManager.printTitleLine();
		
		pManager.showPerson(persons, "���ϴ�");
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
		persons[0] = new PersonEntity("�̼�ȣ", "7212121028102", "��õ ��籸", "032-392-2932");
        persons[1] = new PersonEntity("���ϴ�", "7302132363217", "���� ������", "02-362-1932");
        persons[2] = new PersonEntity("�ڿ���", "7503111233201", "���� ���ϱ�", "02-887-1542");
        persons[3] = new PersonEntity("���μ�", "7312041038988", "���� ������", "032-384-2223");
        persons[4] = new PersonEntity("ȫ����", "7606221021341", "���� ��õ��", "02-158-7333");
        persons[5] = new PersonEntity("�̹̼�", "7502142021321", "���� ������", "02-323-1934");
        persons[6] = new PersonEntity("�ڼ���", "7402061023101", "���� ���α�", "02-308-0932");
        persons[7] = new PersonEntity("������", "7103282025101", "���� ����", "02-452-0939");
        persons[8] = new PersonEntity("Ȳ����", "7806231031101", "��õ �߱�", "032-327-2202");
        persons[9] = new PersonEntity("��ö��", "7601211025101", "��õ ��籸", "032-122-7832");
	}
	
	public void showPerson(PersonEntity[] persons) {
		for(PersonEntity person : persons) {
			System.out.println("[�̸�] " + person.getName()
								+ "\t[����] " + person.getGender()
								+ "\t[��ȭ��ȣ] " + person.getPhone() + "\t");
			printLine();
		}
	}
	
	
	public int findByGender(PersonEntity[] persons, char gender) {
		int gCount = 0;
		for(PersonEntity person : persons) {
			char g = person.getGender();
			// char Ÿ���� primitive Ÿ������ ���� ���� �� == �����ڸ� ����ص� ��.
			gCount += g == gender ? 1 : 0;
		}
		System.out.println("���� : '" + gender +"'(��)�� " + gCount + "�� �Դϴ�." );
		return gCount;
	}
	
	public void showPerson(PersonEntity[] persons, String name) {
		for(PersonEntity person : persons) {
			// String�� reference Ÿ���̹Ƿ� ���� ���� �� equals() �޼��带 ����ؾ� ��.
			if (person.getName().contentEquals(name)) {
				System.out.println("-- �̸� : '" + person.getName() + "'(��)�� ã�� ����Դϴ�.");
				printLine();
				System.out.println();
				System.out.println("[�̸�] " + person.getName());
                System.out.println("[����] " + person.getGender());
                System.out.println("[��ȭ��ȣ] " + person.getPhone());
                System.out.println("[�ּ�] " + person.getAddress());
                return;
			}
		}
		System.out.println("ã�� �� ����");
	}
	
	public void printLine() {
	    for (int i = 0; i < 60; i++) {
	        System.out.print("-");
	    }
	    System.out.println(); // �� �ٲ�
	}
}
