package hr.service;


import java.util.List;

import hr.bean.Dept;
import hr.bean.Employee;


public interface EmpService {
	
	public Employee queryEmp(String phone,String psw);
	
	public void addEmp(Employee emp);
	public void updateEmp(Employee emp);
	public Employee queryEmp2(String phone);
	public boolean queryempInDept(int deptId);
	public List<Employee> queryempInDept2(int deptId);
	public List<Employee> queryByDeptIdPid(int deptId,int pid);
	public List<Employee>  querybypid(int pid);
	public void delEmpbyphone(String phone);
	public  List<Employee>  queryAllEmp();
	public Employee queryEmpbyid222(int empId);
	
	public List<Employee>  querybypid222(int pid);
}
