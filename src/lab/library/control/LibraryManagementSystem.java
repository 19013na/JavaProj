package lab.library.control;
import java.util.List;

import lab.library.entity.*;

public class LibraryManagementSystem {
	
	public static void main(String[] args) {
		
		Library library = new Library("중앙도서관");
		addSampleBooks(library);
		
		// 매개변수로 넣을 책
		Book book = library.findBookByTitle("자바 프로그래밍");
		
		writeTitle(library.getName());
		printLibraryInfo(library);
        printLibraryBookInfo(library);
        testFindBook(library, "자바의 정석", "Robert C. Martin");
        testCheckOut(book ,library);
        testReturn(book, library);
        displayAvailableBooks(library);
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
		System.out.println("전체 도서 수: " + library.getTotalBooks());
		System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
		System.out.println("대출 중인 도서 수: " + library.getUnavailableBooksCount());
		System.out.println();
	}
	
	private static void testFindBook(Library library, String title, String author) {
		writeTitle("도서 검색 테스트");
		System.out.println("제목으로 검색 결과:");	
		Book book = library.findBookByTitle(title);
		toBook(book);
		System.out.println("저자로 검색 결과:");
		Book book2 = library.findBookByAuthor(author);
		toBook(book2);
	}
	
	
	private static void testCheckOut(Book book, Library library) {
		writeTitle("도서 대출 테스트");
		if(library.checkOutBook(book.getIsbn())) {
			System.out.println("도서 대출 성공!");
			System.out.println("대출된 도서 정보:");
			toBook(book);
			System.out.println("도서관 현재 상태");
			printLibraryBookInfo(library);
		} else {
			System.out.println("도서 대출 실패!");
		}
	}
	
	private static void testReturn(Book book, Library library) {
		writeTitle("도서 반납 테스트");
		if(library.returnBook(book.getIsbn())) {
			System.out.println("도서 반납 성공!");
			System.out.println("반납된 도서 정보:");
			toBook(book);
			System.out.println("도서관 현재 상태");
			printLibraryBookInfo(library);
		} else {
			System.out.println("도서 반납 실패!");
		}
	}
	
	// 대출 가능 도서
	private static void displayAvailableBooks(Library library) {
		List<Book> books = library.getAvailableBooks();
		writeTitle("대출 가능한 도서 목록 ");
		for(Book book : books) {
			toBook(book);
			System.out.println("------------------------");
		}
	}
	
	public static void toBook(Book book) {
		if (book == null) {
	        System.out.println("도서를 찾을 수 없습니다.");
	        return;
	    }
		System.out.println("책 제목: " + book.getTitle() 
		+ "\t저자: " + book.getAuthor() 
		+ "\tISBN: " + book.getIsbn()
		+ "\t출판년도: " + book.getPublishYear()
		+ "\t대출 가능 여부: " + (book.isAvailable() ? "가능" : "불가능"));
	}
	
	private static void writeTitle(String title) {
		System.out.println("===== " + title + " =====");
	}
}
