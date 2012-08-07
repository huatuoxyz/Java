package user.dao;

import java.util.List;

import user.entity.User;

public interface UserDao {
    public void save(User user);    
    public User load(String email);
    public void update(User user);
    public List<User> searchAll();
    public void delete(User user);

}
