package dao;


import java.util.ArrayList;

import dto.User;

public interface UserDao {
	public ArrayList<User> getUsers();
	public User getUser(String email);
	public void insertUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);

}
