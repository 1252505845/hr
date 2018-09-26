package hr.bean;

import java.util.Date;

public class Review {//复议
	private int revId;
	private int empId;
	private String conn;
	private int money;
    private Date  date;
    
    
    
	public Review(int revId, int empId, String conn, int money, Date date) {
		super();
		this.revId = revId;
		this.empId = empId;
		this.conn = conn;
		this.money = money;
		this.date = date;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getRevId() {
		return revId;
	}
	public void setRevId(int revId) {
		this.revId = revId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getConn() {
		return conn;
	}
	public void setConn(String conn) {
		this.conn = conn;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Review(int revId, int empId, String conn, Date date) {
		super();
		this.revId = revId;
		this.empId = empId;
		this.conn = conn;
		this.date = date;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
