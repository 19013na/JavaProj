package workshop.book.entity;

public class Novel extends Publication {
	
	private String author;
	private String genre;
	
	public Novel() {
	}

	public Novel(String title, String publishingDate, int page, int price) {
		super(title, publishingDate, page, price);
		this.author = author;
		this.genre = genre;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
}
