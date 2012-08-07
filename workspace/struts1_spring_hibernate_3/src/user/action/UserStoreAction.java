package user.action;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import user.entity.User;
import user.form.UserForm;
import user.service.UserService;


public final class UserStoreAction extends Action {
	
	private UserService service;

	public ActionForward execute(ActionMapping map, ActionForm fm,
			HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		UserForm form=(UserForm)fm;
		
	    User user = new User();
	    user.setEmail(form.getEmail());
	    user.setPassword(form.getPassword());
	    user.setName(form.getName());
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			
			user.setBirthday(sdf.parse(form.getBirthday().toString()));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		user.setGender(form.getGender());
	    user.setWebsite(form.getWebsite());
	    
	    service.update(user);
		
		return map.findForward("success");
	}
	public void setService(UserService service) {
		this.service = service;
	}

}
