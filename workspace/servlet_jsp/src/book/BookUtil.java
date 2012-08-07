package book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

public class BookUtil {
	
	public static HttpServletRequest setBundles(HttpServletRequest request){
		ResourceBundle rb = ResourceBundle.getBundle("LocalStrings");
	    request.setAttribute ("book_isbn", rb.getString("book.isbn"));
	    request.setAttribute ("book_title", rb.getString("book.title"));
	    request.setAttribute ("book_author", rb.getString("book.author"));
	    request.setAttribute ("book_price", rb.getString("book.price"));
	    request.setAttribute ("book_publish", rb.getString("book.publish"));
	    request.setAttribute ("book_published", rb.getString("book.published"));

		return request;
	}
	
	public static ArrayList<String> check(HttpServletRequest request){
		ResourceBundle rb = ResourceBundle.getBundle("LocalStrings");
	    		
		ArrayList<String> messages = new ArrayList<String>();
		String message;
		
		String isbn      = request.getParameter("isbn");
		String title     = request.getParameter("title");
		String author    = request.getParameter("author");
		String price     = request.getParameter("price");
		String publish   = request.getParameter("publish");
		String published = request.getParameter("published");
		
		if(isbn.equals("")){
			message=rb.getString("book.isbn")+"を入力してください";
			messages.add(message);
		}
		if(title.equals("")){
			message=rb.getString("book.title")+"を入力してください";
			messages.add(message);			
		}
		if(author.equals("")){
			message=rb.getString("book.author")+"を入力してください";
			messages.add(message);			
		}
		if(price.equals("")){
			message=rb.getString("book.price")+"を入力してください";
			messages.add(message);			
		}
		if(publish.equals("")){
			message=rb.getString("book.publish")+"を入力してください";
			messages.add(message);			
		}
		if(published.equals("")){
			message=rb.getString("book.published")+"を入力してください";
			messages.add(message);			
		}
		
		try{
			Integer.parseInt(price);
		}catch (NumberFormatException e) {
			message=rb.getString("book.price")+"は整数を入力してください";
			messages.add(message);			
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			sdf.parse(published);
		} catch (ParseException e) {
			message=rb.getString("book.published")+"は「yyyy-MM-dd」で入力してください";
			messages.add(message);			
		}
		return messages;
	}

}
