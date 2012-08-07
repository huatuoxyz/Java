package book.dao.hibernate;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import book.dao.BookInfoDao;
import book.entity.BookInfo;


public class BookInfoDaoImpl extends HibernateDaoSupport implements BookInfoDao {
    
    public BookInfo getBookInfo(String isbn) throws DataAccessException {
        BookInfo bookInfo = (BookInfo) getHibernateTemplate().get(BookInfo.class, isbn);
        
        return bookInfo;
    }
    
    public String saveBookInfo(BookInfo bookInfo) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(bookInfo);
        return bookInfo.getIsbn();
    }
    
    public String updateBookInfo(BookInfo bookInfo) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(bookInfo);
        return bookInfo.getIsbn();
        
    }
    
    public void deleteBookInfo(String isbn) throws DataAccessException {
        getHibernateTemplate().delete(getBookInfo(isbn));
    }
    
    @SuppressWarnings("unchecked")
	public List<BookInfo> selectAllBookInfo() throws DataAccessException {
        return getHibernateTemplate().loadAll(BookInfo.class);
    }
}
