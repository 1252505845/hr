package hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.bean.Dept;
import hr.bean.Employee;
import hr.dao.EmpDao;
import hr.service.EmpService;
@Service
public class EmpServiceImpl implements EmpService {
     @Autowired
	private EmpDao empDao;
	
	@Override
	public Employee queryEmp(String phone, String psw) {
		// TODO Auto-generated method stub
		return empDao.queryEmp(phone, psw);
	}

	@Override
	public void addEmp(Employee emp) {
		// TODO Auto-generated method stub
		empDao.addEmp(emp);
	}

	@Override
	public void updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		empDao.updateEmp(emp);
	}

	@Override
	public Employee queryEmp2(String phone) {
		// TODO Auto-generated method stub
		return empDao.queryEmp2(phone);
	}

	@Override
	public boolean queryempInDept(int deptId) {
		// TODO Auto-generated method stub
		if(empDao.queryempInDept(deptId).size()==0) {
			//部门里没有员工
			return  true;
		}
		
		
		return false;
	}

	@Override
	public List<Employee> queryempInDept2(int deptId) {
		// TODO Auto-generated method stub
		return empDao.queryempInDept(deptId);
	}

	@Override
	public List<Employee> queryByDeptIdPid(int deptId, int pid) {
		// TODO Auto-generated method stub
		return empDao.queryByDeptIdPid(deptId, pid);
	}

	@Override
	public List<Employee> querybypid(int pid) {
		// TODO Auto-generated method stub
		return empDao.querybypid(pid);
	}

	@Override
	public void delEmpbyphone(String phone) {
		// TODO Auto-generated method stub
		empDao.delEmpbyphone(phone);
	}

	
	
	
	
	
	}

	

