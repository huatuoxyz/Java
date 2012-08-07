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

import book.entity.BookInfo;
import book.form.BookUpdateForm;
import book.service.BookInfoService;


public final class BookStoreAction extends Action {
	
	
	private BookInfoService service;

	public ActionForward execute(ActionMapping map, ActionForm fm,
			HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		BookUpdateForm form=(BookUpdateForm)fm;
		
		BookInfo book = new BookInfo();
	    book.setIsbn(form.getIsbn());
	    book.setTitle(form.getTitle());
	    book.setAuthor(form.getAuthor());
	    book.setPrice(form.getPrice());
	    book.setPublish(form.getPublish());
	    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			book.setPublished(sdf.parse(form.getPublished()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    
	    try {
			service.saveBookInfo(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map.findForward("success");
	}
	
	public void setService(BookInfoService service) {
		this.service = service;
	}

}
