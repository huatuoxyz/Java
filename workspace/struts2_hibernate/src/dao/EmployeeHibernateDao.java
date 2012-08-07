package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Employee;


public class EmployeeHibernateDao implements EmployeeDao {
	
	private List<Employee> empList;
	private Employee emp;

	@SuppressWarnings("unchecked")
	public  List<Employee> getAllEmployees() {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			empList = session.createQuery(
					"from Employee as e left join fetch e.department d")
					.list();
			return empList;
		} finally {
			session.close();
		}
	}

	public Employee getEmployee(Integer id) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Query q = session
					.createQuery("from Employee as e inner join fetch e.department d where e.employeeId =:employeeId");
			q.setInteger("employeeId", id);
			return (Employee) q.uniqueResult();
		}finally {
			session.close();
		}
	}

	public void insert(Employee emp) {
		Session session = HibernateUtil.getSession();
		Transaction tx=null;
		try {
			tx = session.beginTransaction();
			session.save(emp);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public void update(Employee emp) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx=session.beginTransaction();
			session.update(emp);
			tx.commit();
		}catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void delete(Integer id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			emp = (Employee)session.get(Employee.class, id);
			session.delete(emp);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			throw e;
		} finally {
		    session.close();
			}   
	}

}
