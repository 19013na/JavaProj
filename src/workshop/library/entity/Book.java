package workshop.library.entity;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	// 생성자
	public Book() {
		this.isAvailable = true;
	}

	public Book(String title, String author, String isbn, int publishYear) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.isAvailable = true;
	}

	// getter, setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	/*public void checkOut() {
		isAvailable = isAvailable? false : true;
	}*/
	
	public boolean checkOut() {
		isAvailable = false;
		return true;
	}
	
	public void returnBook() {
		isAvailable = true;
	}
	
	@Override
	public String toString() {
		return "책 제목: " + title +
		           "\t저자: " + author +
		           "\tISBN: " + isbn +
		           "\t출판년도: " + publishYear +
		           "\t대출 가능 여부: " + (isAvailable ? "가능" : "불가능");
	}
}
