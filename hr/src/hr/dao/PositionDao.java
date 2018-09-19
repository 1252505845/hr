package hr.dao;

import java.util.List;

import hr.bean.Dept;
import hr.bean.Position;

public interface PositionDao {

	public List<Position> queryPositionbyId(int deptId);
	
	
	public Position queryPositionbyName(String posName);
	
	
	public Position  queryPosbyName(int deptId,String posName);
	
	public  Position  querybypid(int pid);
	
	public void addPos(Position position);
	/**
	 * 删除某一部门的所有职位
	 * @param deptId
	 */
	
	public void delPosInDept(int deptId);
	
	
	public void delbypid(int pid);
}
