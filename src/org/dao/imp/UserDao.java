package org.dao.imp;
import java.util.List;
import org.dao.intf.IUserDao;
import org.model.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDao extends HibernateDaoSupport implements IUserDao{
	public void saveUser(User user){
		this.getHibernateTemplate().save(user);
	}
	public User validateUser(String username,String password){
		String str[] = {username,password};
		List list = this.getHibernateTemplate().find("from User where username=? and password=?",str);
		if(list.size()>0){
			User user = (User)list.get(0);
			return user;
		}else{
			return null;
		}
	}
}
