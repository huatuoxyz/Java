package dao;

import java.util.ArrayList;

import entity.User;

public interface UserDao {
	public ArrayList<User> findAllUser();
	public User findUser(String email);
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
}
