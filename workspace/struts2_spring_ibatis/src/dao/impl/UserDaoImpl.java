package dao.impl;

import java.util.ArrayList;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import dao.UserDao;
import dto.User;

public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<User> getUsers() {
		ArrayList<User> users = (ArrayList<User>) getSqlMapClientTemplate().queryForList("User.findUsers");
		return users;
	}

	@Override
	public User getUser(String email) {
		User user = (User) getSqlMapClientTemplate().queryForObject("User.findUserByEmail",email);
        return user;
	}

	@Override
	public void insertUser(User user) {
		getSqlMapClientTemplate().insert("User.insertUser",user);
	}

	@Override
	public void updateUser(User user) {
		getSqlMapClientTemplate().update("User.updateUser",user);
	}
	
	@Override
	public void deleteUser(User user) {
		getSqlMapClientTemplate().delete("User.deleteUser",user);
	}
	
}

