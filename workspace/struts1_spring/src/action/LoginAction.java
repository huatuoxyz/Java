package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.springframework.beans.factory.annotation.Autowired;

import service.LoginService;


public class LoginAction extends Action {
    @Autowired                                       //(1)
    private LoginService loginService = null;        //(1)
  
    @Override
    public ActionForward execute(ActionMapping map, ActionForm form, 
        HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        // フォームからIDおよびパスワードを取得
        DynaActionForm dynaForm = (DynaActionForm)form;
        String userId = dynaForm.getString("userId");
        String password = dynaForm.getString("password");
        // ログイン処理
        boolean result = loginService.execute(userId, password);     
        if(result){
        // ログイン成功
           return map.findForward("success");
        }
        // ログイン失敗
        return map.findForward("failure");
    }

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
    
    
}
