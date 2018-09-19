package hr.service;

import hr.bean.Dept;

public interface DeptService {
	public  void addDept(Dept dept);
	public  Dept  queryByName(String deptName);

	public void delDept(int deptId);
	public Dept queryDeptById(int deptId);
}
