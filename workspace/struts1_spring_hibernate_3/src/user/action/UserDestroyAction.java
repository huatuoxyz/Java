package user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import user.entity.User;
import user.service.UserService;

public final class UserDestroyAction extends Action {
	
	private UserService service;

	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		User user = new User();
		user.setEmail(email);
		
		service.delete(user);
		return map.findForward("success");
	}
	
	public void setService(UserService service) {
		this.service = service;
	}

}
