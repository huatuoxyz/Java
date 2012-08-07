package spring.example08;


public class ExampleBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void initialize() throws Exception {
        System.out.println(this.name + " is initialized...");
    }

    public void dispose() throws Exception {
        System.out.println(this.name + " is destroyed...");
    }
}