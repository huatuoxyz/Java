package book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import book.entity.BookInfo;
import book.service.BookInfoService;


public final class BookListAction extends Action {
	
	BookInfoService service;
	
	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		ArrayList<BookInfo> objAry = (ArrayList<BookInfo>) service.selectAllBookInfo();
		request.setAttribute("book.view.info", objAry.toArray());
		return map.findForward("success");
	}
	
	public void setService(BookInfoService service) {
		this.service = service;
	}
}
