package hr.dao;

import java.util.List;

import hr.bean.Rep;

public interface RepDao {

	//增加奖惩
	public void addRep(Rep rep);
	
	//管理员查看所有的奖惩记录
	public List<Rep> queryAllRep();
	
	public Rep  query(int empId,String conn);
	public List<Rep>  queryRepById(int empId);
}
