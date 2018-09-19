package hr.bean;

import java.util.Date;
import java.util.List;

public class Dept {
   private int deptId;
   private String deptName;
   private Date createTime;
   private List<Employee> empList;
   private List<Position> posList;
   
   
public List<Employee> getEmpList() {
	return empList;
}
public void setEmpList(List<Employee> empList) {
	this.empList = empList;
}
public List<Position> getPosList() {
	return posList;
}
public void setPosList(List<Position> posList) {
	this.posList = posList;
}
public Dept(int deptId, String deptName, Date createTime) {
	super();
	this.deptId = deptId;
	this.deptName = deptName;
	this.createTime = createTime;
}
public Date getCreateTime() {
	return createTime;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}
public int getDeptId() {
	return deptId;
}
public void setDeptId(int deptId) {
	this.deptId = deptId;
}
public String getDeptName() {
	return deptName;
}
public void setDeptName(String deptName) {
	this.deptName = deptName;
}
public Dept(int deptId, String deptName) {
	super();
	this.deptId = deptId;
	this.deptName = deptName;
}
public Dept() {
	super();
	// TODO Auto-generated constructor stub
}
   
   
}
