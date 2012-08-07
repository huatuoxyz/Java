package service.impl;

import java.util.ArrayList;

import dao.UserDao;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public ArrayList<User> findAllUser() {
		return userDao.findAllUser();
	}

	@Override
	public User findUser(String email) {
		return userDao.findUser(email);
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	
	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

}
