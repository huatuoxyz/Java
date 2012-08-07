package struts2.sample01;

public class HelloAction {

	private String message;
	private String title;
    
    public String execute() {
        this.setTitle("Struts2 sample01");
        this.setMessage("Hello World!");
        return "success";
    }
    
	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

}
