package book.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import book.entity.BookInfo;

public interface BookInfoDao {
    public BookInfo getBookInfo(String isbn) throws DataAccessException;
    public String saveBookInfo(BookInfo bookInfo) throws DataAccessException;
    public String updateBookInfo(BookInfo bookInfo) throws DataAccessException;
    public void deleteBookInfo(String isbn) throws DataAccessException;
	public List<BookInfo> selectAllBookInfo() throws DataAccessException;
}
