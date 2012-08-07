package struts2.sample04;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class RadioAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private String label;
	private String radio;
	private List<String> radiolist;
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public List<String> getRadiolist() {
		return radiolist;
	}

	public void setRadiolist(List<String> radiolist) {
		this.radiolist = radiolist;
	}

	// アクション時の処理
	public String execute() {
		
		this.setLabel("あなたは、" + this.getRadio() + "と選択したね。");
		
		radiolist = new ArrayList<String>();
		radiolist.add("Windows");
		radiolist.add("Mac OS X");
		radiolist.add("Linux");

		return SUCCESS;
	}
}

