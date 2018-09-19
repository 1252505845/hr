package hr.service;

import hr.bean.User;

public interface UserService {
	public User queryUser(String phone,String psw);
	public Integer queryUserByPhone(String phone);
	public boolean registUser(User user);
	public void del(int uid);
	public User queryById(int uid);
}
