package book.service;

import java.util.List;

import book.dao.BookDao;
import book.entity.Book;

public class BookServiceImpl implements BookService {
	
	private BookDao bookdao;
	
	@Override
	public Book load(String isbn) {
		Book book = bookdao.load(isbn);
		return book;
	}

	@Override
	public void save(Book book){
		bookdao.save(book);
	}

	@Override
	public List<Book> selectAll(){
		List<Book> books = bookdao.searchAll();
		return books;
	}
	
	@Override
	public void delete(Book book){
		bookdao.delete(book);
	}

	@Override
	public void update(Book book) {
		bookdao.update(book);
	}
	
	public void setBookdao(BookDao bookdao) {
		this.bookdao = bookdao;
	}
}
