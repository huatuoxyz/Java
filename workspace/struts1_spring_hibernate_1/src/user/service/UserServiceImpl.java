package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.dao.UserDao;
import user.entity.User;

@Service("userservice")

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userdao;
	
	@Override
	public void delete(User user){
		userdao.delete(user);
		
	}

	@Override
	public User load(String email) {
		User user = userdao.load(email);
		return user;
	}

	@Override
	public void save(User user){
		userdao.save(user);
	}

	@Override
	public List<User> selectAll(){
		List<User> users = userdao.searchAll();
		return users;
	}
	
	
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public void update(User user) {
		userdao.update(user);
	}

}
