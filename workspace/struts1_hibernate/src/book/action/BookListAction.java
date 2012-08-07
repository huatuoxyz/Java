package book.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import book.dao.BookInfoDao;
import book.entity.BookInfo;

public final class BookListAction extends Action {
	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {
		BookInfoDao dao = new BookInfoDao();
		List<BookInfo> objAry = dao.searchAll();
		request.setAttribute("book.view.info", objAry.toArray());
		return map.findForward("success");
		
	}
}
