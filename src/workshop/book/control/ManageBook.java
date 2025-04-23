package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Publication;
import workshop.book.entity.Novel;

public class ManageBook {

	public static void main(String[] args) {
		// Publication 타입 배열을 선언 및 생성
		Publication[] pubs = new Publication[5];
		pubs[0] = new Magazine("마이크로소프트","2007-10-01",328,9900,"매월");

		
		// Magazine 객체 생성
		//Magazine mz = new Magazine(); // -> (x)
		Publication pub = new Magazine();
		
		// Novel 객체 생성 : alt + shift + l
		Publication pub2 = new Novel();
		
	}
	
	public void modifyPrice(Publication pub) {
		
	}

}
