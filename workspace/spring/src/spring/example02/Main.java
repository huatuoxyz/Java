package spring.example02;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) throws Exception {
    	Resource res = new ClassPathResource("spring/example02/beans.xml");
    	XmlBeanFactory factory = new XmlBeanFactory(res);
        HelloWorld person = (HelloWorld)factory.getBean("helloworld");
        person.say();
    }
}
