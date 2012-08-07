
package book.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import book.entity.Book;
import book.service.BookService;

public class BookListAction extends Action {
	
	private BookService service;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<Book> books = service.selectAll();
		request.setAttribute("book.view.info", books.toArray());
		return mapping.findForward("success");
	}

	public void setService(BookService service) {
		this.service = service;
	}
	
}
