package com.iotek.dao;

import com.iotek.bean.User;

public interface UserDao {

	/**
	 * 根据用户名和密码查询用户
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User queryUser(String name, String pwd);

	/**
	 * 查询给定用户名是否存在
	 * 
	 * @param name
	 * @return
	 */
	public int queryUserName(String name);

	/**
	 * 新增用户
	 * 
	 * @param user
	 */
	public void saveUser(User user);

	/**
	 * 更新用户信息
	 * 
	 * @param userId
	 * @param idNo
	 * @param mobile
	 * @param email
	 */
	public void updateUser(int userId, String idNo, String mobile, String email);
	
	
}
