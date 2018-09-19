package hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.bean.Position;
import hr.dao.PositionDao;
import hr.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {
   @Autowired
	private PositionDao positionDao;
	
	@Override
	public Position queryPositionbyName(String posName) {
		// TODO Auto-generated method stub
		return positionDao.queryPositionbyName(posName);
	}

	@Override
	public boolean queryPosbyName(int deptId, String posName) {
		// TODO Auto-generated method stub
		
		 if(positionDao.queryPosbyName(deptId, posName)==null) {
			 return true;
		 }
		 return false;
	}

	@Override
	public void addPos(Position position) {
		// TODO Auto-generated method stub
		positionDao.addPos(position);
	}

	@Override
	public void delPosInDept(int deptId) {
		// TODO Auto-generated method stub
		positionDao.delPosInDept(deptId);
	}

	@Override
	public List<Position> queryPositionbyId(int deptId) {
		// TODO Auto-generated method stub
		return positionDao.queryPositionbyId(deptId);
	}

	@Override
	public Position querybypid(int pid) {
		// TODO Auto-generated method stub
		return positionDao.querybypid(pid);
	}

	@Override
	public void delbypid(int pid) {
		// TODO Auto-generated method stub
		positionDao.delbypid(pid);
	}

	

}
