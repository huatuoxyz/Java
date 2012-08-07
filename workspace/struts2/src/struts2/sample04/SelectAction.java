package struts2.sample04;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class SelectAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private String label;
	private List<String> select;

	
	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}

	public List<String> getSelect() {
		return select;
	}


	public void setSelect(List<String> select) {
		this.select = select;
	}


	// アクション時の処理
	public String execute() {
		
		if (this.getSelect() != null){
			this.setLabel(this.getSelect().toString());
		}
		return SUCCESS;
	}
}

