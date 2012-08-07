package spring.example04;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) throws Exception {
    	Resource res = new ClassPathResource("spring/example04/beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);
		Person yamada = (Person) factory.getBean("king");
		System.out.println("[name=" + yamada.getName() + "]");
		yamada.listenMusic();
    }
}
