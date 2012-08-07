package book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import book.bean.BookInfo;

public final class BookListAction extends Action {
	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<BookInfo> objAry = BookInfo.getBookInfos();
		request.setAttribute("book.view.info", objAry.toArray());
		return map.findForward("success");
		
	}
}
