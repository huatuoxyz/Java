package book.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import book.entity.BookInfo;


public class BookInfoDao {
	
    public void save(BookInfo book) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(book);

        transaction.commit();
        session.close();
    }
    
    public BookInfo load(String isbn) {
        Session session = getSession();
        BookInfo book = (BookInfo) session.load(BookInfo.class, isbn);
        session.close();
        return book;
    }
    
    public void update(BookInfo book) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        //session.update(book);
        session.saveOrUpdate(book);
        transaction.commit();
        session.close();
    }
    
    @SuppressWarnings("unchecked")
    public List<BookInfo> searchAll() {
        Session session = getSession();
        List<BookInfo> list = session.createCriteria(BookInfo.class).list();
        return list;
    }
    
    public void delete(BookInfo book){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        
        session.delete(book);
        
        transaction.commit();
        session.close();
    }

    protected Session getSession() {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }

}
