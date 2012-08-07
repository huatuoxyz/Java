package struts2.sample04;

import com.opensymphony.xwork2.ActionSupport;

public class ComboboxAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private String label;
	private String combobox;
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getCombobox() {
		return combobox;
	}


	public void setCombobox(String combobox) {
		this.combobox = combobox;
	}


	// アクション時の処理
	public String execute() {
		
		this.setLabel(this.getCombobox());
		
		return SUCCESS;
	}
}

