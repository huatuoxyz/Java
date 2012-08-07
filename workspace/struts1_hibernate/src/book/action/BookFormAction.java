package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import book.dao.BookInfoDao;
import book.entity.BookInfo;

public final class BookFormAction extends Action {
	public ActionForward execute(ActionMapping map, ActionForm fm,
			HttpServletRequest request, HttpServletResponse response) {
		DynaActionForm objFrm = (DynaActionForm) fm;
		BookInfo objBok = null;
		BookInfoDao dao = new BookInfoDao();
		if (objFrm.get("isbn") != null && !objFrm.get("isbn").equals("")) {
			objBok = dao.load((String) objFrm.get("isbn"));
			request.setAttribute("update.flag", "true");
		}
		request.setAttribute("book.update.info", objBok);
		return map.findForward("success");
	}
}
