package user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import user.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	
    public void save(User user) {
        getHibernateTemplate().save(user);
    }
    
    public User load(String isbn) {
        User user = (User) getHibernateTemplate().load(User.class, isbn);
        return user;
    }
    
    public void update(User user) {
        getHibernateTemplate().saveOrUpdate(user);
    }
    
    @SuppressWarnings("unchecked")
    public List<User> searchAll() {
        return getHibernateTemplate().loadAll(User.class);
    }
    
    public void delete(User user){
        getHibernateTemplate().delete(user);
    }
    
}
