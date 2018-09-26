package hr.bean;

import java.util.Date;

public class Payroll {
  private int payId;
  private int empId;
  private double salary;//基本工资
  private double  performance;//绩效奖金
  private double overtime;//加班工资
  private double rep;//奖惩工资
  private double  social;//社保
  private double  realitysal;//实际工资，到手的工资
  
  
  public double getRealitysal() {
	return realitysal;
}
public void setRealitysal(double realitysal) {
	this.realitysal = realitysal;
}
private Date time;//年月   某年某月的工资
  private String empName;
  
  
  
  
public Payroll(int payId, int empId, double salary, double performance, double overtime, double rep, double social,
		double realitysal, Date time, String empName) {
	super();
	this.payId = payId;
	this.empId = empId;
	this.salary = salary;
	this.performance = performance;
	this.overtime = overtime;
	this.rep = rep;
	this.social = social;
	this.realitysal = realitysal;
	this.time = time;
	this.empName = empName;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public Payroll(int payId, int empId, double salary, double performance, double overtime, double rep, double social,
		double realitysal, Date time) {
	super();
	this.payId = payId;
	this.empId = empId;
	this.salary = salary;
	this.performance = performance;
	this.overtime = overtime;
	this.rep = rep;
	this.social = social;
	this.realitysal = realitysal;
	this.time = time;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}
public Payroll() {
	super();
	// TODO Auto-generated constructor stub
}
public Payroll(int payId, int empId, double salary, double performance, double overtime, double rep, double social,
		double realitysal) {
	super();
	this.payId = payId;
	this.empId = empId;
	this.salary = salary;
	this.performance = performance;
	this.overtime = overtime;
	this.rep = rep;
	this.social = social;
	this.realitysal = realitysal;
}
public int getPayId() {
	return payId;
}
public void setPayId(int payId) {
	this.payId = payId;
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public double getPerformance() {
	return performance;
}
public void setPerformance(double performance) {
	this.performance = performance;
}
public double getOvertime() {
	return overtime;
}
public void setOvertime(double overtime) {
	this.overtime = overtime;
}
public double getRep() {
	return rep;
}
public void setRep(double rep) {
	this.rep = rep;
}
public double getSocial() {
	return social;
}
public void setSocial(double social) {
	this.social = social;
}

  
  
  
	
	
}
