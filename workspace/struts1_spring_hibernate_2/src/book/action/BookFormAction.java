package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import book.entity.BookInfo;
import book.service.BookInfoService;

public final class BookFormAction extends Action {
	
	private BookInfoService service;
	
	public ActionForward execute(ActionMapping map, ActionForm fm,
			HttpServletRequest request, HttpServletResponse response) {
		
		DynaActionForm form = (DynaActionForm) fm;
		BookInfo book = null;
		
		if (form.get("isbn") != null && !form.get("isbn").equals("")) {
			try {
				book = service.getBookInfo((String) form.get("isbn"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("update.flag", "true");
		}
		request.setAttribute("book.update.info", book);
		return map.findForward("success");
	}
	
	public void setService(BookInfoService service) {
		this.service = service;
	}
}
