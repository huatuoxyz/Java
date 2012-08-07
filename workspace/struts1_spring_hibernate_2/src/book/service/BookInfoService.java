package book.service;

import java.util.List;

import book.entity.BookInfo;

public interface BookInfoService {
    public BookInfo getBookInfo(String isbn) throws Exception;
    public String saveBookInfo(BookInfo bookInfo) throws Exception;
    public void deleteBookInfo(String isbn) throws Exception;
    public List<BookInfo> selectAllBookInfo() throws Exception;
}
