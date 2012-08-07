package book.action;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import book.entity.Book;
import book.form.BookForm;
import book.service.BookService;


public final class BookStoreAction extends Action {
	
	
	private BookService service;

	public ActionForward execute(ActionMapping map, ActionForm fm,
			HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		BookForm form=(BookForm)fm;
		
	    Book book = new Book();
	    book.setIsbn(form.getIsbn());
	    book.setTitle(form.getTitle());
	    book.setAuthor(form.getAuthor());
	    book.setPrice(Integer.parseInt(form.getPrice()));
	    book.setPublish(form.getPublish());
	    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			book.setPublished(sdf.parse(form.getPublished()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    
	    service.update(book);
		
		return map.findForward("success");
	}
	
	public void setService(BookService service) {
		this.service = service;
	}

}
