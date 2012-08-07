package book.action;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import book.bean.BookInfo;
import book.form.BookForm;


public final class BookStoreAction extends Action {
	public ActionForward execute(ActionMapping map, ActionForm fm,
			HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		BookForm objFrm=(BookForm)fm;
		
	    BookInfo objBok=new BookInfo();
	    objBok.setIsbn(objFrm.getIsbn());
	    objBok.setTitle(objFrm.getTitle());
	    objBok.setAuthor(objFrm.getAuthor());
	    objBok.setPrice(Integer.parseInt(objFrm.getPrice()));
	    objBok.setPublish(objFrm.getPublish());
	    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			objBok.setPublished(sdf.parse(objFrm.getPublished()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    
	    objBok.updateBookInfo();
		
		return map.findForward("success");
	}
}
