package org.dao.intf;
import org.model.User;

public interface IUserDao {
	public void saveUser(User user);
	public User validateUser(String username,String password);
}
