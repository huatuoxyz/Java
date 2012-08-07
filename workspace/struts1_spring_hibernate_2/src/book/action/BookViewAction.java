package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import book.entity.BookInfo;
import book.service.BookInfoService;

public final class BookViewAction extends Action {
	
	private BookInfoService service;

	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {
		
		String isbn = request.getParameter("isbn");
		
		BookInfo book = null;
		try {
			book = service.getBookInfo(isbn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("book", book);
		return map.findForward("success");
	}

	public void setService(BookInfoService service) {
		this.service = service;
	}
	
}
