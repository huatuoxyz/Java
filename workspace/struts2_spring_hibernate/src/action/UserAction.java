package action;

import java.util.ArrayList;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;

public class UserAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	private ArrayList<User> users;
	private User user;
	private String email;
	private String controlflag;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getControlflag() {
		return controlflag;
	}

	public void setControlflag(String controlflag) {
		this.controlflag = controlflag;
	}

	//********* metdhots ***********//
	@SkipValidation
	public String listUser(){
		users = userService.findAllUser();
		return "list";
	}
	@SkipValidation
	public String showUser(){
		user = userService.findUser(email);
		return "show";
	}
	@SkipValidation
	public String newUser(){
		this.controlflag="new";
		return "new";
	}
	@SkipValidation
	public String editUser(){
		this.controlflag="edit";
		user = userService.findUser(email);
		return "edit";
	}
	
	public String createUser(){
		userService.insertUser(user);
		email = user.getEmail();
		return this.showUser();
	}
	
	public String updateUser(){
		userService.updateUser(user);
		email = user.getEmail();
		return this.showUser();
	}
	@SkipValidation
	public String deleteUser(){
		userService.deleteUser(userService.findUser(email));
		return this.listUser();
	}
	@SkipValidation
	@Override
	public String execute() throws Exception {
		return this.listUser();
	}
	@Override
	public void validate() {
		if(controlflag!=null && controlflag.equals("new")){
			if(userService.findUser(user.getEmail())!=null){
				addActionError("メールアドレスが登録されてます。");
			}
		}
	}
}
