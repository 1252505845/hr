package hr.bean;

import java.util.Date;

public class Attendance {   //考勤表
  private int attId;
  private Date today;//当前日期           
  private int status=0;//上班考勤状态 ，正常上班1，迟到2， 迟到超过三小时旷工3
 private int  status222=0;   //  下班考勤状态 状态默认0  正常下班1 早退2   早退超过三小时旷工3 
 private int work=0;//加班    0不加班  1加班
  private int empId;//员工编号
  private String empName;
  private Date onTime;//上班时间
  private Date offTime;//下班时间
  
  
  
  
public Attendance(int attId, Date today, int status, int status222, int work, int empId, String empName, Date onTime,
		Date offTime) {
	super();
	this.attId = attId;
	this.today = today;
	this.status = status;
	this.status222 = status222;
	this.work = work;
	this.empId = empId;
	this.empName = empName;
	this.onTime = onTime;
	this.offTime = offTime;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public Attendance(int attId, Date today, int status, int status222, int work, int empId, Date onTime, Date offTime) {
	super();
	this.attId = attId;
	this.today = today;
	this.status = status;
	this.status222 = status222;
	this.work = work;
	this.empId = empId;
	this.onTime = onTime;
	this.offTime = offTime;
}
public int getWork() {
	return work;
}
public void setWork(int work) {
	this.work = work;
}
public Attendance(int attId, Date today, int status, int status222, int empId, Date onTime, Date offTime) {
	super();
	this.attId = attId;
	this.today = today;
	this.status = status;
	this.status222 = status222;
	this.empId = empId;
	this.onTime = onTime;
	this.offTime = offTime;
}
public int getStatus222() {
	return status222;
}
public void setStatus222(int status222) {
	this.status222 = status222;
}
public int getAttId() {
	return attId;
}
public void setAttId(int attId) {
	this.attId = attId;
}
public Date getToday() {
	return today;
}
public void setToday(Date today) {
	this.today = today;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public Date getOnTime() {
	return onTime;
}
public void setOnTime(Date onTime) {
	this.onTime = onTime;
}
public Date getOffTime() {
	return offTime;
}
public void setOffTime(Date offTime) {
	this.offTime = offTime;
}
public Attendance(int attId, Date today, int status, int empId, Date onTime, Date offTime) {
	super();
	this.attId = attId;
	this.today = today;
	this.status = status;
	this.empId = empId;
	this.onTime = onTime;
	this.offTime = offTime;
}
public Attendance() {
	super();
	// TODO Auto-generated constructor stub
}
  
  
  
  

  
  
}
