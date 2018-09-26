package hr.dao;

import java.util.List;

import hr.bean.Dept;
import hr.bean.Employee;


public interface EmpDao {
/**
 * 根据账号和密码查询用户
 */
	public Employee queryEmp(String phone,String psw);
	
	public void addEmp(Employee emp);
	
	public Employee queryEmpbyid(int empId);
	public Employee queryEmpbyid222(int empId);
	/**
	 * 管理员进行员工换岗
	 */
	public void updateEmp(Employee emp);
	
	public Employee queryEmp2(String phone);
	
	/**
	 * 查看该部门下的所有员工
	 */
	public List<Employee> queryempInDept(int deptId);
	public List<Employee>  querybypid(int pid);
	public List<Employee>  querybypid222(int pid);
	public List<Employee> queryByDeptIdPid(int deptId,int pid);
	
	public  List<Employee>  queryAllEmp();
	public void delEmpbyphone(String phone);
	
	
	

}
