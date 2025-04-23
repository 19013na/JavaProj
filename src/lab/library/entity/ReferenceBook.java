package lab.library.entity;

import workshop.book.entity.Publication;

public class ReferenceBook extends Publication {
	private String field;
	
	public ReferenceBook() {
	}

	public ReferenceBook(String title, String publishingDate, int page, int price) {
		super(title, publishingDate, page, price);
		this.field = field;
	}
	
	public String getField() {
		return field;
	}
	
	public void setField(String field) {
		this.field = field;
	}
}
