package book.service;

import java.util.List;

import book.dao.BookInfoDao;
import book.entity.BookInfo;


public class BookInfoServiceImpl implements BookInfoService {
    private BookInfoDao bookInfoDao;
    
    public void setBookInfoDao(BookInfoDao bookInfoDao) {
        this.bookInfoDao = bookInfoDao;
    }

    public BookInfo getBookInfo(String isbn) throws Exception {
        return bookInfoDao.getBookInfo(isbn);
    }
    
    public String saveBookInfo(BookInfo bookInfo) throws Exception {
   		return bookInfoDao.saveBookInfo(bookInfo);
    }
    
    public void deleteBookInfo(String isbn) throws Exception {
        bookInfoDao.deleteBookInfo(isbn);
    }
    
    public List<BookInfo> selectAllBookInfo() throws Exception {
        return bookInfoDao.selectAllBookInfo();
    }
}
