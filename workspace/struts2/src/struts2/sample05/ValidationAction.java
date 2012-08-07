package struts2.sample05;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.UrlValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

@Results({
	@Result("/jsp/sample05/validation.jsp"),
	@Result(name="input", value="/jsp/sample05/index.jsp")
})
@Validations(
	requiredFields={
		@RequiredFieldValidator(
				fieldName="employee.birthday",
				message="生年月日を入力して下さい。"),
		@RequiredFieldValidator(
				fieldName="employee.nyuushabi",
				message="入社日を入力して下さい。"),
		@RequiredFieldValidator(
				fieldName="employee.saraly",
				message="給与を入力して下さい。")
	},
	requiredStrings={
		@RequiredStringValidator(
				fieldName="employee.name",
				message="氏名を入力して下さい。"),
		@RequiredStringValidator(
				fieldName="employee.nameKana",
				message="氏名（カナ）を入力して下さい。")
	},
	stringLengthFields={
		@StringLengthFieldValidator(
				fieldName="employee.name",
				maxLength="10",
				message="氏名は${maxLength}文字以内で入力して下さい。"),
		@StringLengthFieldValidator(
				fieldName="employee.nameKana",
				maxLength="20",
				message="氏名（カナ）は${maxLength}文字以内で入力して下さい。")
	},
	urls={
		@UrlValidator(
				fieldName="employee.url",
				message="ホームページURLの形式が無効です。")
	},
	emails={
		@EmailValidator(
				fieldName="employee.email",
				message="メールアドレスの形式が無効です。")
	},
	dateRangeFields={
		@DateRangeFieldValidator(
				fieldName="employee.nyuushabi",
				min="2004/06/28 00:00:00",
				message="入社日は${min}以降の日付を入力して下さい。")
	},
	regexFields={
		@RegexFieldValidator(
				fieldName="employee.yuubinBangou",
				expression="\\d{3}-\\d{4}",
				message="郵便番号の形式が無効です。例：136-0073")
	}
)

public class ValidationAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Employee employee;
	
	public String execute() throws Exception{
		return SUCCESS;
	}

	@SkipValidation
	public String noValidation() throws Exception{
		return SUCCESS;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
