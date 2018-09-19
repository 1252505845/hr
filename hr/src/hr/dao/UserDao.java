package hr.dao;

import hr.bean.User;

public interface UserDao {
/**
 * 根据账号和密码查询用户
 */
	public User queryUser(String phone,String psw);
	/**
	 * 查询给定的账号是否存在
	 * @param phone
	 * @return
	 */
	public Integer queryUserByPhone(String phone);
	
	public User queryById(int uid);
	
	/**
	 * 增加用户
	 */
	
	public void addUser(User user);
	
	
	/**
	 * 删除游客
	 * 
	 */
	public void del(int uid);
}
