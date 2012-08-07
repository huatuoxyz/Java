package struts2.sample04;

import com.opensymphony.xwork2.ActionSupport;

public class CheckboxAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private String label;
	private boolean checkbox;
	
	
	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public boolean isCheckbox() {
		return checkbox;
	}


	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}


	// アクション時の処理
	public String execute() {
		
		this.setLabel("チェックボックスは、" + this.isCheckbox() + "です。");
		return SUCCESS;
	}
}

