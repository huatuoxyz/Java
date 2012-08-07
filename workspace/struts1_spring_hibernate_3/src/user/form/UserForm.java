package user.form;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import user.entity.User;

public class UserForm extends ValidatorForm  {
	
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	private String name;
	private String birthday;
	private Integer gender;
	private String website;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void reset(ActionMapping map, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			if (request.getAttribute("update.flag") != null) {
				User user = (User) (request
						.getAttribute("user.update.info"));
				email = user.getEmail();
				password = user.getPassword();
				name = user.getName();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				birthday = sdf.format(user.getBirthday());
				gender = user.getGender();
				website = user.getWebsite();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
	    //ActionErrors errors = new ActionErrors();
	    ActionErrors errors = super.validate(mapping,request);
	    if (errors.isEmpty()){
		    int int_price = Integer.parseInt(password);
		    if ( int_price <= -1 || int_price >= 10000 ) {
		      errors.add( "price_error", new ActionMessage("errors.price","価格") );
		    }
	    }
	    return errors;
	}
	*/
}
