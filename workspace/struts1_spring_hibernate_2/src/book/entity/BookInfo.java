package book.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookInfo {
    
    private String isbn;
    private String title;
    private String author;
    private Integer price;
    private String publish;
    private Date published;
    
    public BookInfo() {
    }

    /**
     * 全てのプロパティを受け取るコンストラクタ
     */
    public BookInfo(final String isbn, final String title, final String author,
            final Integer price, final String publish, final Date publicationDay) {
        this.setIsbn(isbn);
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
        this.setPublish(publish);
        this.setPublished(published);
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
	public String getFormattedPublished() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(published);
	}

}
