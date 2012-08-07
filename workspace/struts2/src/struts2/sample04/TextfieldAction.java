package struts2.sample04;

import com.opensymphony.xwork2.ActionSupport;

public class TextfieldAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private String text;
	private String field;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	public String execute() {
		this.setText(this.getField());
		return SUCCESS;
    }
}
