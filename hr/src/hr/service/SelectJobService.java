package hr.service;

import java.util.List;

import hr.bean.Dept;
import hr.bean.Position;

public interface SelectJobService {
	public List<Dept> queryALLDept();
	
	public List<Position> queryPositionbyId(int deptId);

    
}
