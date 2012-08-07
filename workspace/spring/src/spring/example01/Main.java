package spring.example01;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) throws Exception {
        Resource res = new FileSystemResource("beans.xml");
        XmlBeanFactory factory = new XmlBeanFactory(res);
        HelloWorld person = (HelloWorld)factory.getBean("helloworld");
        person.say();
    }
}
