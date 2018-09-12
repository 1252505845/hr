package hr.service;

import hr.bean.User;

public interface UserService {
	public User queryUser(String phone,String psw);
	
	public boolean registUser(User user);
}
