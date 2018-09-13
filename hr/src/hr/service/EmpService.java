package hr.service;


import hr.bean.Employee;


public interface EmpService {
	
	public Employee queryEmp(String phone,String psw);
}
