package spring.example05;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) throws Exception {
    	Resource res = new ClassPathResource("spring/example05/beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);
		ExampleBean bean = (ExampleBean) factory.getBean("exampleBean");
		System.out.println(bean.getList());
		System.out.println(bean.getMap());
		System.out.println(bean.getSet());
		System.out.println(bean.getProperties());
    }
}
