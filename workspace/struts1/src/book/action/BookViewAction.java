package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import book.bean.BookInfo;

public final class BookViewAction extends Action {
	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {
		
		String isbn = request.getParameter("isbn");
		
		BookInfo bookinfo = BookInfo.getBookInfo(isbn);
		
		request.setAttribute("bookinfo", bookinfo);
		return map.findForward("success");
	}
}
