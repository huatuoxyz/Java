package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import book.bean.BookInfo;

public final class BookFormAction extends Action {
	public ActionForward execute(ActionMapping map, ActionForm fm,
			HttpServletRequest request, HttpServletResponse response) {
		DynaActionForm objFrm = (DynaActionForm) fm;
		BookInfo objBok = null;
		if (objFrm.get("isbn") != null && !objFrm.get("isbn").equals("")) {
			objBok = BookInfo.getBookInfo((String) objFrm.get("isbn"));
			request.setAttribute("update.flag", "true");
		}
		request.setAttribute("book.update.info", objBok);
		return map.findForward("success");
	}
}
