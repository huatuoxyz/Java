package struts2.sample04;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class CheckboxlistAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private String label;
	private List<String> checkboxlist;
	
	
	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}
	
	public List<String> getCheckboxlist() {
		return checkboxlist;
	}

	public void setCheckboxlist(List<String> checkboxlist) {
		this.checkboxlist = checkboxlist;
	}


	// アクション時の処理
	public String execute() {
		if (this.getCheckboxlist() != null){
			this.setLabel(this.getCheckboxlist().toString());
		}
		return SUCCESS;
	}
}

