package book.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class BookInfo{

	private static final long serialVersionUID = 1L;

	private String isbn;
	private String title;
	private String author;
	private Integer price;
	private String publish;
	private Date published;
	
	public BookInfo() {
		isbn = null;
		title = null;
		author = null;
		price = null;
		publish = null;
		published = null;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Integer getPrice() {
		return price;
	}

	public String getPublish() {
		return publish;
	}

	public Date getPublished() {
		return published;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public void setPublished(Date published) {
		this.published = published;
	}
	public String getFormattedPublished() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(published);
	}
}
