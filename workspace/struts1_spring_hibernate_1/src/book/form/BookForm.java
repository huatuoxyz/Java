package book.form;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import book.entity.Book;

public class BookForm extends ValidatorForm  {
	
	private static final long serialVersionUID = 1L;
	
	private String isbn;
	private String title;
	private String author;
	private String price;
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

	public String getPrice() {
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

	public void setPrice(String price) {
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
				Book objBok = (Book) (request
						.getAttribute("book.update.info"));
				isbn = objBok.getIsbn();
				title = objBok.getTitle();
				author = objBok.getAuthor();
				price = objBok.getPrice().toString();
				publish = objBok.getPublish();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				published = sdf.format(objBok.getPublished());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
	    //ActionErrors errors = new ActionErrors();
	    ActionErrors errors = super.validate(mapping,request);
	    if (errors.isEmpty()){
		    int int_price = Integer.parseInt(price);
		    if ( int_price <= -1 || int_price >= 10000 ) {
		      errors.add( "price_error", new ActionMessage("errors.price","価格") );
		    }
	    }
	    return errors;
	}
}
