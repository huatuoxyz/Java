package spring.example07;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) throws Exception {
    	Resource res = new ClassPathResource("spring/example07/beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);
		ExampleBean bean = (ExampleBean) factory.getBean("exampleBean");

        System.out.println("name: " + bean.getName());
        factory.destroySingletons();

    }
}
