package org.service.imp;
import org.model.User;
import org.dao.intf.IUserDao;
import org.service.intf.IUserService;

public class UserService implements IUserService{
	private IUserDao userDao;
	public void setUserDao(IUserDao userDao){
		this.userDao = userDao;
	}
	public void saveUser(User user){
		this.userDao.saveUser(user);
	}
	
	public User validateUser(String username,String password){
		return userDao.validateUser(username,password);
	}
}
