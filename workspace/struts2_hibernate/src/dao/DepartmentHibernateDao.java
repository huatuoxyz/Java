package dao;

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import bean.Department;

public class DepartmentHibernateDao implements DepartmentDao {
	private List<Department> depList;

	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartments() {
		Session session = HibernateUtil.getSession();

		try {
			session.beginTransaction();
			depList = session.createQuery("from Department").list();
			return depList;
		} catch (HibernateException e) {
			throw e;
		} finally {
			session.close();
		}

	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DepartmentHibernateDao depDao = new DepartmentHibernateDao();
		List<Department> deps = depDao.getAllDepartments();
		for(Iterator<Department> i=deps.iterator();i.hasNext();){
			System.out.println(i.next().getName());
		}
	}

}
