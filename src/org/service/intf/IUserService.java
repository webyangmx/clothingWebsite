package org.service.intf;
import org.model.User;
public interface IUserService {
	public void saveUser(User user);
	public User validateUser(String username,String password);
}
