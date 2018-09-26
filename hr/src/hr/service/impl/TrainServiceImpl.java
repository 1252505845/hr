package hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.bean.Train;
import hr.dao.TrainDao;
import hr.service.TrainService;
@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainDao trainDao;
	@Override
	public void addTrain(Train train) {
		// TODO Auto-generated method stub
       trainDao.addTrain(train);
	}

	@Override
	public Train queryTrain(String trainName,int deptId) {
		// TODO Auto-generated method stub
		return trainDao.queryTrain(trainName,deptId);
	}

	@Override
	public List<Train> queryAllTrain() {
		// TODO Auto-generated method stub
		return trainDao.queryAllTrain();
	}

	@Override
	public void update(Train train) {
		// TODO Auto-generated method stub
		trainDao.update(train);
	}

	@Override
	public void delTrain(int trainId) {
		// TODO Auto-generated method stub
		trainDao.delTrain(trainId);
	}

	@Override
	public List<Train> queryByDeptId(int deptId) {
		// TODO Auto-generated method stub
		return trainDao.queryByDeptId(deptId);
	}

}
