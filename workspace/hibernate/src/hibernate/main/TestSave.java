package hibernate.main;

import hibernate.dao.Book;
import hibernate.dao.BookDao;

public class TestSave {
	public static void main(String args[]) {
    	
        BookDao bookDao = new BookDao();

        Book book = new Book();
        book.setIsbn("ISBN4-7561-4340-7");
        book.setName("ゼロから始めるJava 増補改訂版");
        book.setPrice(1905);
        bookDao.save(book);

        Book book2 = new Book();
        book2.setIsbn("ISBN4-7561-4383-0");
        book2.setName("ゼロから始めるJSP/サーブレット");
        book2.setPrice(2095);
        bookDao.save(book2);
    }
}
