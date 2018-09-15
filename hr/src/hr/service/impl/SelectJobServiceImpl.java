package hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.bean.Dept;
import hr.bean.Position;
import hr.dao.DeptDao;
import hr.dao.PositionDao;
import hr.service.SelectJobService;
@Service
public class SelectJobServiceImpl implements SelectJobService {

	@Autowired
	private DeptDao deptDao;
	@Autowired
	private PositionDao positionDao;
	
	@Override
	public List<Dept> queryALLDept() {
		// TODO Auto-generated method stub
		return deptDao.queryALLDept();
	}
	@Override
	public List<Position> queryPositionbyId(int deptId) {
		// TODO Auto-generated method stub
		return  positionDao.queryPositionbyId(deptId);
	}


}
