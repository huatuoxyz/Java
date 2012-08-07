package book.service;

import java.util.List;

import book.entity.Book;

public interface BookService {
    public Book load(String isbn) ;
    public void save(Book book);
    public void delete(Book book);
    public void update(Book book);
    public List<Book> selectAll();
}
