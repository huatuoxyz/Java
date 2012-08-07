package spring.example06;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ExampleBean implements InitializingBean, DisposableBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println(this.name + " is initialized...");
    }

    public void destroy() throws Exception {
        System.out.println(this.name + " is destroyed...");
    }
}