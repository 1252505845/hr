package hr.service;

import java.util.List;

import hr.bean.Position;

public interface PositionService {
 
	public void addPos(Position position);
	public Position queryPositionbyName(String posName);
	public boolean  queryPosbyName(int deptId,String posName);
	
	public void delPosInDept(int deptId);
	public List<Position> queryPositionbyId(int deptId);
	public  Position  querybypid(int pid);
	public void delbypid(int pid);
}
