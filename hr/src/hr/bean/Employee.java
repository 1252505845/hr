package hr.bean;

public class Employee {
	 private int  empId;
	 private String phone;//用于管理员的登陆
	 private String psw;
	 private String empName;//姓名
	 private  int deptId;
	 private String sex;
	 private String position;//职位
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public Employee(int empId, String phone, String psw, String empName, int deptId, String sex, String position) {
		super();
		this.empId = empId;
		this.phone = phone;
		this.psw = psw;
		this.empName = empName;
		this.deptId = deptId;
		this.sex = sex;
		this.position = position;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
}
