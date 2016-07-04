package org.action;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.chainsaw.Main;
import org.model.User;
import org.service.intf.IUserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ResolverUtil.NameEndsWith;

public class UserAction extends ActionSupport{
	protected User user;
	protected IUserService userService;
	
	private String username;
	private String password;
	
	Map<String, Object> successInfo;//返回的成功信息
	Map<String, Object> userInfo;//返回的用户信息
	
	public UserAction(){
		successInfo=new HashMap<String, Object>();
		userInfo =  new HashMap<String, Object>();
	}
	
	public String register() throws Exception{//注册
		successInfo.clear();
		// TODO: 封装用户对象
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		try{
			userService.saveUser(user);//保存用户
			successInfo.put("success", true);	
		}catch(Exception e){
			successInfo.put("success", false);	
			
		}
		return SUCCESS;	
	}
	
	public String login() throws Exception{//登录
		successInfo.clear();
		User user = userService.validateUser(username, password);//验证
		if(user!=null){
			successInfo.put("success", true);
			userInfo.put("userId", user.getUserid());
		}else{
			successInfo.put("success", false);	
		}
		return SUCCESS;
	}
	
	public String logout() throws Exception{//注销
		successInfo.clear();
		successInfo.put("success", true);
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user){
		this.user = user;
	}
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public Map<String, Object> getSuccessInfo() {
		return successInfo;
	}

	public void setSuccessInfo(Map<String, Object> successInfo) {
		this.successInfo = successInfo;
	}

	public Map<String, Object> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(Map<String, Object> userInfo) {
		this.userInfo = userInfo;
	}
	
}
