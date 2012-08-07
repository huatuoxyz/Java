package user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.springframework.beans.factory.annotation.Autowired;

import user.entity.User;
import user.service.UserService;

public final class UserFormAction extends Action {
	
	@Autowired
	private UserService service;

	public ActionForward execute(ActionMapping map, ActionForm fm,
			HttpServletRequest request, HttpServletResponse response) {
		DynaActionForm form = (DynaActionForm) fm;
		User user = null;
		
		if (form.get("email") != null && !form.get("email").equals("")) {
			user = service.load((String) form.get("email"));
			request.setAttribute("update.flag", "true");
		}
		request.setAttribute("user.update.info", user);
		return map.findForward("success");
	}
	public void setService(UserService service) {
		this.service = service;
	}

}
