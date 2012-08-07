package user.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import user.entity.User;

@Service("userdao")
public class UserDaoImpl implements UserDao{
	
    public void save(User user) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(user);

        transaction.commit();
        session.close();
    }
    
    public User load(String isbn) {
        Session session = getSession();
        User book = (User) session.load(User.class, isbn);
        session.close();
        return book;
    }
    
    public void update(User user) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        //session.update(book);
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }
    
    @SuppressWarnings("unchecked")
    public List<User> searchAll() {
        Session session = getSession();
        List<User> list = session.createCriteria(User.class).list();
        return list;
    }
    
    public void delete(User user){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        
        session.delete(user);
        
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
