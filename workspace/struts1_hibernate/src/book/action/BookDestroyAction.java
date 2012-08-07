package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import book.dao.BookInfoDao;
import book.entity.BookInfo;

public final class BookDestroyAction extends Action {
	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {
		
		String isbn = request.getParameter("isbn");
		BookInfo bookinfo = new BookInfo();
		bookinfo.setIsbn(isbn);
		BookInfoDao dao=new BookInfoDao();
		dao.delete(bookinfo);
		return map.findForward("success");
	}
}
