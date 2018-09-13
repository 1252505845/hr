package hr.dao;

import hr.bean.Admin;

public interface AdminDao {
/**
 * 根据账号和密码查询用户
 */
	public Admin queryAdmin(String phone,String psw);
	
}
