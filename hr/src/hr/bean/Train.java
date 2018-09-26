package hr.bean;

import java.util.Date;

public class Train {
   private int  trainId;
   private String  trainName;//培训名字
   private Date time;
   private int deptId;
 private  String deptName;
   private int score;
   


public Train(int trainId, String trainName, Date time, int deptId, String deptName, int score) {
	super();
	this.trainId = trainId;
	this.trainName = trainName;
	this.time = time;
	this.deptId = deptId;
	this.deptName = deptName;
	this.score = score;
}

public int getTrainId() {
	return trainId;
}

public void setTrainId(int trainId) {
	this.trainId = trainId;
}

public String getDeptName() {
	return deptName;
}

public void setDeptName(String deptName) {
	this.deptName = deptName;
}



public String getTrainName() {
	return trainName;
}

public void setTrainName(String trainName) {
	this.trainName = trainName;
}

public Train() {
	super();
	// TODO Auto-generated constructor stub
}

public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}


public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}

public int getDeptId() {
	return deptId;
}

public void setDeptId(int deptId) {
	this.deptId = deptId;
}


	
	
}
