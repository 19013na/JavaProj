package lab.library.entity;
import java.util.ArrayList;
import java.util.List;

public class Library {
	private String name;
	private List<Book> books;
	
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public Book findBookByTitle(String title) {
		for(Book book : books) {
			if(book.getTitle().equals(title)) {
				return book;
			}
		}
		return null;
	}
	
	// 대출
	public boolean checkOutBook(String isbn) {
		for(Book book : books) {
			if(book.getIsbn().equals(isbn)) {
				boolean result = book.checkOut();
				return result;
			}
		}
		return false;
	}
	
	// 반납
	public boolean returnBook(String isbn) {
		for(Book book : books) {
			if(book.getIsbn().equals(isbn)) {
				book.returnBook();
				return true;
			}
		}
		return false;
	}
	
	public List<Book> getAvailableBooks(){
		List<Book> availableBook = new ArrayList<>();
		for(Book book : books) {
			if(book.isAvailable()) {
				availableBook.add(book);
			}
		}
		return availableBook;
	}
	
	// 모든 도서 반환
	public List<Book> getAllBooks(){
		return books;
	}
	
	// 모든 도서 수량
	public int getTotalBooks() {
		return books.size();
	}
	
	// 대출 가능 도서 수량
	public int getAvailableBooksCount(){
		int bCount = 0;
		for(Book book : books) {
			if(book.isAvailable()) {
				bCount++;
			}
		}
		return bCount;
	}
	
	// 대출 중인 도서 수량
	public int getUnavailableBooksCount(){
		int bCount = 0;
		for(Book book : books) {
			if(!book.isAvailable()) {
				bCount++;
			}
		}
		return bCount;
	}
}