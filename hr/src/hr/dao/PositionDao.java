package hr.dao;

import java.util.List;

import hr.bean.Dept;
import hr.bean.Position;

public interface PositionDao {

	public List<Position> queryPositionbyId(int deptId);
}
