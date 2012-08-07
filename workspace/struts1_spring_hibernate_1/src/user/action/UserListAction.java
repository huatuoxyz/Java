
package user.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import user.entity.User;
import user.service.UserService;

public class UserListAction extends Action {
	@Autowired
	private UserService service;
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<User> users = service.selectAll();
		request.setAttribute("user.view.info", users.toArray());
		return mapping.findForward("success");
	}
	
}
