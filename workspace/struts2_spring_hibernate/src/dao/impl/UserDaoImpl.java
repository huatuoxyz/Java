package dao.impl;

import java.util.ArrayList;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.UserDao;
import entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	
	@Override
	public void deleteUser(User user) {
		getHibernateTemplate().delete(user);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<User> findAllUser() {
		return (ArrayList<User>) getHibernateTemplate().loadAll(User.class);
	}

	@Override
	public User findUser(String email) {
		return (User)getHibernateTemplate().get(User.class, email);
	}

	@Override
	public void insertUser(User user) {
		getHibernateTemplate().save(user);
	}

	@Override
	public void updateUser(User user) {
		getHibernateTemplate().update(user);
	}
}
