package lab.library.control;
import lab.library.entity.*;

public class LibraryManagementSystem {
	
	public static void main(String[] args) {
		Library library = new Library("�߾ӵ�����");
        addSampleBooks(library);
        printLibraryInfo(library);
        printLibraryBookInfo(library);
//        testFindBook(library);
//        testCheckOut(library);
//        testReturn(library);
//        displayAvailableBooks(library);
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
		writeTitle(library.getName());
		System.out.println("��ü ���� ��: " + library.getTotalBooks());
		System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
		System.out.println("���� ���� ���� ��: " + library.getUnavailableBooksCount());
		System.out.println();
	}
	
	private void testFindBook(Library library) {
		writeTitle("���� �˻� �׽�Ʈ");
		System.out.println("�������� �˻� ���:");	
		System.out.println();
		System.out.println();
	}
	
	private static void writeTitle(String title) {
		System.out.println("===== " + title + " =====");
	}
}
