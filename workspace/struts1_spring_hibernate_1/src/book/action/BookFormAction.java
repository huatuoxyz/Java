package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import book.entity.Book;
import book.service.BookService;

public final class BookFormAction extends Action {
	
	private BookService service;
	
	public ActionForward execute(ActionMapping map, ActionForm fm,
			HttpServletRequest request, HttpServletResponse response) {
		DynaActionForm form = (DynaActionForm) fm;
		Book book = null;
		
		if (form.get("isbn") != null && !form.get("isbn").equals("")) {
			book = service.load((String) form.get("isbn"));
			request.setAttribute("update.flag", "true");
		}
		request.setAttribute("book.update.info", book);
		return map.findForward("success");
	}
	
	public void setService(BookService service) {
		this.service = service;
	}

}
