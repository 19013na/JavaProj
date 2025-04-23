package lab.library.control;
import java.util.List;

import lab.library.entity.*;

public class LibraryManagementSystem {
	
	public static void main(String[] args) {
		
		Library library = new Library("�߾ӵ�����");
		addSampleBooks(library);
		
		// �Ű������� ���� å
		Book book = library.findBookByTitle("�ڹ� ���α׷���");
		
		writeTitle(library.getName());
		printLibraryInfo(library);
        printLibraryBookInfo(library);
        testFindBook(library, "�ڹ��� ����", "Robert C. Martin");
        testCheckOut(book ,library);
        testReturn(book, library);
        displayAvailableBooks(library);
	}
	
	private static void addSampleBooks(Library library) {
		library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
	}
	
	private static void printLibraryInfo(Library library) {
		for(Book book : library.getAllBooks()) {
			System.out.println("������ �߰��Ǿ����ϴ�: " + book.getTitle());
		}
	}

	private static void printLibraryBookInfo(Library library) {
		System.out.println("��ü ���� ��: " + library.getTotalBooks());
		System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
		System.out.println("���� ���� ���� ��: " + library.getUnavailableBooksCount());
		System.out.println();
	}
	
	private static void testFindBook(Library library, String title, String author) {
		writeTitle("���� �˻� �׽�Ʈ");
		System.out.println("�������� �˻� ���:");	
		Book book = library.findBookByTitle(title);
		toBook(book);
		System.out.println("���ڷ� �˻� ���:");
		Book book2 = library.findBookByAuthor(author);
		toBook(book2);
	}
	
	
	private static void testCheckOut(Book book, Library library) {
		writeTitle("���� ���� �׽�Ʈ");
		if(library.checkOutBook(book.getIsbn())) {
			System.out.println("���� ���� ����!");
			System.out.println("����� ���� ����:");
			toBook(book);
			System.out.println("������ ���� ����");
			printLibraryBookInfo(library);
		} else {
			System.out.println("���� ���� ����!");
		}
	}
	
	private static void testReturn(Book book, Library library) {
		writeTitle("���� �ݳ� �׽�Ʈ");
		if(library.returnBook(book.getIsbn())) {
			System.out.println("���� �ݳ� ����!");
			System.out.println("�ݳ��� ���� ����:");
			toBook(book);
			System.out.println("������ ���� ����");
			printLibraryBookInfo(library);
		} else {
			System.out.println("���� �ݳ� ����!");
		}
	}
	
	// ���� ���� ����
	private static void displayAvailableBooks(Library library) {
		List<Book> books = library.getAvailableBooks();
		writeTitle("���� ������ ���� ��� ");
		for(Book book : books) {
			toBook(book);
			System.out.println("------------------------");
		}
	}
	
	public static void toBook(Book book) {
		if (book == null) {
	        System.out.println("������ ã�� �� �����ϴ�.");
	        return;
	    }
		System.out.println("å ����: " + book.getTitle() 
		+ "\t����: " + book.getAuthor() 
		+ "\tISBN: " + book.getIsbn()
		+ "\t���ǳ⵵: " + book.getPublishYear()
		+ "\t���� ���� ����: " + (book.isAvailable() ? "����" : "�Ұ���"));
	}
	
	private static void writeTitle(String title) {
		System.out.println("===== " + title + " =====");
	}
}
