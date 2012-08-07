package struts2.sample03;

import java.util.Random;

import org.apache.struts2.config.Namespace;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletDispatcherResult;

@Namespace("/sample03")

@Results({
	@Result(name="morning" , type=ServletDispatcherResult.class, value="/jsp/sample03/morning.jsp"),
	@Result(name="hello"   , type=ServletDispatcherResult.class, value="/jsp/sample03/hello.jsp"),
	@Result(name="evening" , type=ServletDispatcherResult.class, value="/jsp/sample03/evening.jsp"),
})

public class HelloAction {
    public String execute() {
    	Random r = new Random();
    	int i = r.nextInt(3);
    	String returnStr="";
    	switch (i) {
		case 0:
			returnStr="morning";
			break;
		case 1:
			returnStr="hello";
			break;
		case 2:
			returnStr="evening";
			break;

		default:
			returnStr="error";
			break;
		}
    	
    	return returnStr;
    }

}
