package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import user.dao.UserDao;
import user.entity.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void delete(User user){
		userDao.delete(user);
	}
	
	@Override
	public User load(String email) {
		User user = userDao.load(email);
		return user;
	}
	
	@Override
	public void save(User user){
		userDao.save(user);
	}
	
	@Override
	public List<User> selectAll(){
		List<User> users = userDao.searchAll();
		return users;
	}
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

}
