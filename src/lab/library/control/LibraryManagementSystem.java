package lab.library.control;
import lab.library.entity.*;

public class LibraryManagementSystem {
	
	public static void main(String[] args) {
		Library library = new Library("중앙도서관");
        addSampleBooks(library);
        printLibraryInfo(library);
        printLibraryBookInfo(library);
//        testFindBook(library);
//        testCheckOut(library);
//        testReturn(library);
//        displayAvailableBooks(library);
	}
	
	private static void addSampleBooks(Library library) {
		library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
	}
	
	private static void printLibraryInfo(Library library) {
		for(Book book : library.getAllBooks()) {
			System.out.println("도서가 추가되었습니다: " + book.getTitle());
		}
	}

	private static void printLibraryBookInfo(Library library) {
		writeTitle(library.getName());
		System.out.println("전체 도서 수: " + library.getTotalBooks());
		System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
		System.out.println("대출 중인 도서 수: " + library.getUnavailableBooksCount());
		System.out.println();
	}
	
	private void testFindBook(Library library) {
		writeTitle("도서 검색 테스트");
		System.out.println("제목으로 검색 결과:");	
		System.out.println();
		System.out.println();
	}
	
	private static void writeTitle(String title) {
		System.out.println("===== " + title + " =====");
	}
}
