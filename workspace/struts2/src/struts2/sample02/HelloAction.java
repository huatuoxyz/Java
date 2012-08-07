package struts2.sample02;

import org.apache.struts2.config.Namespace;
import org.apache.struts2.config.Result;

@Namespace("/sample02")
@Result(name="success", value="/jsp/sample02/hello.jsp")
public class HelloAction {
    public String execute() {
    	return "success";
    }
}

