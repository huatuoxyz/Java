package hibernate.main;

import hibernate.dao.Book;
import hibernate.dao.BookDao;

public class TestUpdate {
	public static void main(String args[]) {
    	
        BookDao bookDao = new BookDao();
        Book book = bookDao.load("ISBN4-7561-4340-7");
        book.setPrice(123456);
        bookDao.update(book);
    }


}
