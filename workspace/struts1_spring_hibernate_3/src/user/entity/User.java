package user.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class User{	
	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	private String name;
	private Date birthday;
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


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
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
	
	public String getFormattedBirthday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(birthday);
	}
	
	public String getFormattedGender() {
		String rtn=null;
		switch (this.gender) {
		case 1:
			rtn="男性";
			break;
		case 2:
			rtn="女性";
			break;
		case 3:
			rtn="その他";
			break;

		default:
			break;
		}
		return rtn;
	}
}
