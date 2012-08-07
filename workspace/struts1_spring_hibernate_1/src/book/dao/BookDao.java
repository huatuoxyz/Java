package book.dao;

import java.util.List;

import book.entity.Book;

public interface BookDao {
    public void save(Book book);    
    public Book load(String isbn);
    public void update(Book book);
    public List<Book> searchAll();
    public void delete(Book book);
}
