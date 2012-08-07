package user.service;

import java.util.List;

import user.entity.User;

public interface UserService {
    public User load(String email) ;
    public void save(User user);
    public void delete(User user);
    public void update(User user);
    public List<User> selectAll();
}
