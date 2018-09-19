package hr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.bean.Dept;
import hr.dao.DeptDao;
import hr.service.DeptService;
@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptDao;
	
	@Override
	public void addDept(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.addDept(dept);
	}
	@Override
	public Dept queryByName(String deptName) {
		// TODO Auto-generated method stub
		return deptDao.queryByName(deptName);
	}


	@Override
	public void delDept(int deptId) {
		// TODO Auto-generated method stub
		deptDao.delDept(deptId);
	}
	@Override
	public Dept queryDeptById(int deptId) {
		// TODO Auto-generated method stub
		return deptDao.queryDeptById(deptId);
	}
	
	
	
	
}
