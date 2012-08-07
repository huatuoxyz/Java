package struts2.sample05;

import java.util.Date;

public class Employee {

	private String name;
	private String nameKana;
	private Date birthday;
	private Date nyuushabi; 
	private Integer saraly;
	private String url;
	private String email;
	private String yuubinBangou;
	
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameKana() {
		return nameKana;
	}
	public void setNameKana(String nameKana) {
		this.nameKana = nameKana;
	}
	public Date getNyuushabi() {
		return nyuushabi;
	}
	public void setNyuushabi(Date nyuushabi) {
		this.nyuushabi = nyuushabi;
	}
	public Integer getSaraly() {
		return saraly;
	}
	public void setSaraly(Integer saraly) {
		this.saraly = saraly;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getYuubinBangou() {
		return yuubinBangou;
	}
	public void setYuubinBangou(String yuubinBangou) {
		this.yuubinBangou = yuubinBangou;
	}
	
}
