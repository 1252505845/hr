package hr.service;

import java.util.List;

import hr.bean.Train;

public interface TrainService  {

	
	
	public void addTrain(Train train);
	public void update(Train train);
	public Train queryTrain(String trainName,int deptId);
	public List<Train> queryAllTrain();
	public void delTrain(int trainId);
	public List<Train> queryByDeptId(int deptId);
	
	
	
}
