package book.form;

import java.text.SimpleDateFormat;

import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.validator.ValidatorForm;

import book.entity.BookInfo;


public class BookUpdateForm extends ValidatorForm  {
	
	private static final long serialVersionUID = 1L;
	private String isbn;
	private String title;
	private String author;
	private Integer price;
	private String publish;
	private String published;

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

	public String getPublished() {
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

	public void setPublished(String published) {
		this.published = published;
	}

	public void reset(ActionMapping map, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			if (request.getAttribute("update.flag") != null) {
				BookInfo objBok = (BookInfo) (request
						.getAttribute("book.update.info"));
				isbn = objBok.getIsbn();
				title = objBok.getTitle();
				author = objBok.getAuthor();
				price = objBok.getPrice();
				publish = objBok.getPublish();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				published = sdf.format(objBok.getPublished());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}