package service;

import java.util.ArrayList;

import entity.User;

public interface UserService {
	public ArrayList<User> findAllUser();
	public User findUser(String email);
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);

}
