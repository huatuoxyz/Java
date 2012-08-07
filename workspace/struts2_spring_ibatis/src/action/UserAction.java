package action;

import java.util.ArrayList;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

import dto.User;

public class UserAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	private ArrayList<User> users;
	private User user;
	private String email;
	private String controlflag;
	
	//******** setter , getter end *************//
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getControlflag() {
		return controlflag;
	}

	public void setControlflag(String controlflag) {
		this.controlflag = controlflag;
	}

	//*************** methods ********************//
	@SkipValidation
	public String listUser(){
		users = userService.getUsers();
		return "list";
	}
	@SkipValidation
	public String newUser(){
		this.controlflag="new";
		return "new";
	}
	@SkipValidation
	public String editUser(){
		this.controlflag="edit";
		user = userService.getUser(email);
		return "edit";
	}
	@SkipValidation
	public String showUser(){
		user = userService.getUser(email);
		return "show";
	}
	
	public String createUser(){
		userService.insertUser(user);
		return "create";
	}
	
	public String updateUser(){
		userService.updateUser(user);
		email=user.getEmail();
		return showUser();
	}
	
	@SkipValidation
	public String deleteUser(){
		user = userService.getUser(email);
		userService.deleteUser(user);
		return "delete";
	}
	
	@SkipValidation
	@Override
	public String execute() throws Exception {
		return this.listUser();
	}

	@Override
	public void validate() {
		if(controlflag!=null && controlflag.equals("new")){
			if(userService.getUser(user.getEmail())!=null){
				addActionError("メールアドレスが登録されてます。");
			}
		}
	}
}
