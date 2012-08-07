package book.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import book.entity.Book;

public class BookDaoImpl implements BookDao{
	
    public void save(Book book) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(book);

        transaction.commit();
        session.close();
    }
    
    public Book load(String isbn) {
        Session session = getSession();
        Book book = (Book) session.load(Book.class, isbn);
        session.close();
        return book;
    }
    
    public void update(Book book) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        //session.update(book);
        session.saveOrUpdate(book);
        transaction.commit();
        session.close();
    }
    
    @SuppressWarnings("unchecked")
	public List<Book> searchAll() {
        Session session = getSession();
        List<Book> list = session.createCriteria(Book.class).list();
        return list;
    }
    
    public void delete(Book book){
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
