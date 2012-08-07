package hibernate.main;

import hibernate.dao.Book;
import hibernate.dao.Person;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class TestPserson {

    @SuppressWarnings("unchecked")
	public static void main(String[] args) {

        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Book book = (Book) session.load(Book.class, "ISBN4-7561-4340-7");

        Person person = new Person();
        person.setName("金東日");
        Set set = new HashSet();
        set.add(book);
        person.setBooks(set);

        session.save(person);

        transaction.commit();
        session.close();
    }
}
