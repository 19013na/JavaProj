package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Publication;
import workshop.book.entity.Novel;

public class ManageBook {

	public static void main(String[] args) {
		// Publication Ÿ�� �迭�� ���� �� ����
		Publication[] pubs = new Publication[5];
		pubs[0] = new Magazine("����ũ�μ���Ʈ","2007-10-01",328,9900,"�ſ�");

		
		// Magazine ��ü ����
		//Magazine mz = new Magazine(); // -> (x)
		Publication pub = new Magazine();
		
		// Novel ��ü ���� : alt + shift + l
		Publication pub2 = new Novel();
		
	}
	
	public void modifyPrice(Publication pub) {
		
	}

}
