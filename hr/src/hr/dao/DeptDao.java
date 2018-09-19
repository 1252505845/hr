package hr.dao;

import java.util.List;

import hr.bean.Dept;

public interface DeptDao {

	public List<Dept> queryALLDept();
	
	public Dept queryDeptById(int deptId);
	
	/**
	 * 增加部门 
	 */
	public  void addDept(Dept dept);
	
	public  Dept  queryByName(String deptName);
	
	public void delDept( int deptId);
	
	
}
