package hr.dao;

import hr.bean.Employee;


public interface EmpDao {
/**
 * 根据账号和密码查询用户
 */
	public Employee queryEmp(String phone,String psw);
	
}
