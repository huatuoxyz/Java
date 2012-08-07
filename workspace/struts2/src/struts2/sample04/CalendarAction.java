package struts2.sample04;

import com.opensymphony.xwork2.ActionSupport;

public class CalendarAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private String label;
	private String datetime;
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	// アクション時の処理
	public String execute() {
		this.setLabel("日付；"+this.getDatetime()+" ");
		return SUCCESS;
	}
	
}

