package hr.bean;

import java.util.Date;

public class Rep {//奖惩表
  
	private int repId;
	private Date repTime;//奖惩时间
	private String conn;//奖惩描述
	private  int empId;
	private String empName;
	private double money;//奖惩金额
	
	
	
	public Rep(int repId, Date repTime, String conn, int empId, String empName, double money) {
		super();
		this.repId = repId;
		this.repTime = repTime;
		this.conn = conn;
		this.empId = empId;
		this.empName = empName;
		this.money = money;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Rep(int repId, Date repTime, String conn, int empId, double money) {
		super();
		this.repId = repId;
		this.repTime = repTime;
		this.conn = conn;
		this.empId = empId;
		this.money = money;
	}
	public String getConn() {
		return conn;
	}
	public void setConn(String conn) {
		this.conn = conn;
	}
	public int getRepId() {
		return repId;
	}
	public void setRepId(int repId) {
		this.repId = repId;
	}
	public Date getRepTime() {
		return repTime;
	}
	public void setRepTime(Date repTime) {
		this.repTime = repTime;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	public Rep() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
