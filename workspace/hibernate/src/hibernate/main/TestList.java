package hibernate.main;

import hibernate.dao.Book;
import hibernate.dao.BookDao;

import java.util.List;


public class TestList {
	public static void main(String args[]) {
    	
        BookDao bookDao = new BookDao();
        List<Book> bookList = bookDao.searchAll();
        for (Book book : bookList) {
            System.out.println(book.getName());
        }
    }

}
