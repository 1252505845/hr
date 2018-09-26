package hr.dao;

import java.util.List;

import hr.bean.Train;

public interface TrainDao {

	public void addTrain(Train train);
	
	public Train queryTrain(String trainName,int deptId);
	public List<Train> queryAllTrain();
	
	public void update(Train train);
	
	public void delTrain(int trainId);
	
	public List<Train> queryByDeptId(int deptId);
	
}
