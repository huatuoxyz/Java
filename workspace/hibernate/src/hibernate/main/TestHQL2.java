package hibernate.main;

import hibernate.dao.Book;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class TestHQL2 {
    @SuppressWarnings("unchecked")
	public static void main(String args[]) {
    	
    	Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

    	Query query = getQuery(session);
        List list = query.list();
        for (int i = 0; i < list.size(); i++) {
          System.out.println(((Book)list.get(i)).getName());
        }
        session.close(); 
    }
    
	private static Query getQuery(Session session) {
		String strQuery = "from com.dongrikin.java.hibernate.Book as book "
		                  + " where book.price < :price";
		Query query = session.createQuery(strQuery);
		query.setInteger("price", 2000);
		return query;
	}
	
}
