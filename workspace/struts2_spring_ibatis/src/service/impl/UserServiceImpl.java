package service.impl;

import java.util.ArrayList;

import dao.UserDao;
import dto.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
		
	}

	@Override
	public User getUser(String email) {
		return userDao.getUser(email);
	}

	@Override
	public ArrayList<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

}
