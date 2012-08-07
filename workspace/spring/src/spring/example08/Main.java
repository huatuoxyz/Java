package spring.example08;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws Exception {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"spring/example08/beans.xml");
		String message = appContext.getMessage("greeting", null, Locale
				.getDefault());
		String shout = appContext.getMessage("shout", null,
				"not found message key 'shout'", Locale.getDefault());
		String error = appContext.getMessage("errors.required",
				new String[] { "hoge" }, Locale.getDefault());
		System.out.println("message=[" + message + "]");
		System.out.println("shout=[" + shout + "]");
		System.out.println("error=[" + error + "]");
		
	}
}
