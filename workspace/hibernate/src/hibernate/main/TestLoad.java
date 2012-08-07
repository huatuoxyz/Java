package hibernate.main;

import hibernate.dao.Book;
import hibernate.dao.BookDao;

public class TestLoad {
	public static void main(String args[]) {
    	Book book = new BookDao().load("ISBN4-7561-4340-7");
        System.out.println(book.getIsbn());
        System.out.println(book.getName());
        System.out.println(book.getPrice());
    }
}
