package struts2.sample04;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class CopyOfTagsAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private String text1;
	private String field1;
	
	private String label1;
	private boolean check1;

	private String label2;
	private List<String> check2;

	private String label3;
	private String radio1;
	
	private List<String> radiolist;

	private String label4;
	private String radio2;

	private String label5;
	private String label6;
	private List<String> select1;
	private String combo1;
	
	private String text2;
	private Date datetime1;

	public Date getDatetime1() {
		return datetime1;
	}

	public void setDatetime1(Date datetime1) {
		this.datetime1 = datetime1;
	}

	public boolean isCheck1() {
		return check1;
	}

	public void setCheck1(boolean check1) {
		this.check1 = check1;
	}

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}
	
	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}
	
	public void setLabel1(String label1) {
		this.label1 = label1;
	}

	public String getLabel1() {
		return label1;
	}
	public List<String> getRadiolist() {
		return radiolist;
	}

	public void setRadiolist(List<String> radiolist) {
		this.radiolist = radiolist;
	}
	
	// アクション時の処理
	public String execute() {
		
		this.setText1("あなたは、" + this.getField1() + "と書いたね。");
		this.setLabel1("チェックボックスは、" + this.isCheck1() + "です。");
		if (this.getCheck2() != null){
			this.setLabel2(this.getCheck2().toString());
		}
		
		this.setLabel3("あなたは、" + this.getRadio1() + "と選択したね。");
		
		radiolist = new ArrayList<String>();
		radiolist.add("Windows");
		radiolist.add("Mac OS X");
		radiolist.add("Linux");

		this.setLabel4("あなたは、" + this.getRadio2() + "と選択したね。");
		
		if (this.getSelect1() != null){
			this.setLabel5(this.getSelect1().toString());
		}
		this.setLabel6("あなたは、" + this.getCombo1() + "と選択したね。");
		
		if(this.getDatetime1()!=null){
			this.setText2(this.getDatetime1().toString());
		}
		
		return SUCCESS;
		
    }

	public void setLabel2(String label2) {
		this.label2 = label2;
	}

	public String getLabel2() {
		return label2;
	}

	public void setCheck2(List<String> check2) {
		this.check2 = check2;
	}

	public List<String> getCheck2() {
		return check2;
	}

	public void setLabel3(String label3) {
		this.label3 = label3;
	}

	public String getLabel3() {
		return label3;
	}

	public void setRadio1(String radio1) {
		this.radio1 = radio1;
	}

	public String getRadio1() {
		return radio1;
	}

	public void setLabel4(String label4) {
		this.label4 = label4;
	}

	public String getLabel4() {
		return label4;
	}

	public void setRadio2(String radio2) {
		this.radio2 = radio2;
	}

	public String getRadio2() {
		return radio2;
	}

	public void setLabel5(String label5) {
		this.label5 = label5;
	}

	public String getLabel5() {
		return label5;
	}

	public void setSelect1(List<String> select1) {
		this.select1 = select1;
	}

	public List<String> getSelect1() {
		return select1;
	}

	public void setCombo1(String combo1) {
		this.combo1 = combo1;
	}

	public String getCombo1() {
		return combo1;
	}

	public void setLabel6(String label6) {
		this.label6 = label6;
	}

	public String getLabel6() {
		return label6;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

	public String getText2() {
		return text2;
	}

}
