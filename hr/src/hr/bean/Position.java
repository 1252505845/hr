package hr.bean;

public class Position {
   private int pid;
   private int deptId;
   private String pName;
   
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public int getDeptId() {
	return deptId;
}
public void setDeptId(int deptId) {
	this.deptId = deptId;
}
public String getpName() {
	return pName;
}
public void setpName(String pName) {
	this.pName = pName;
}
public Position(int pid, int deptId, String pName) {
	super();
	this.pid = pid;
	this.deptId = deptId;
	this.pName = pName;
}
public Position() {
	super();
	// TODO Auto-generated constructor stub
}
   
}
