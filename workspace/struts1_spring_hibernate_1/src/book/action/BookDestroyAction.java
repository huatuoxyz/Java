package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import book.entity.Book;
import book.service.BookService;

public final class BookDestroyAction extends Action {
	
	private BookService service;
	
	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {
		
		String isbn = request.getParameter("isbn");
		Book book = new Book();
		book.setIsbn(isbn);
		
		service.delete(book);
		return map.findForward("success");
	}
	
	public void setService(BookService service) {
		this.service = service;
	}

}
