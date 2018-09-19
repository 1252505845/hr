package hr.bean;

public class Employee {
	 private int  empId;
	 private String phone;//用于员工的登陆
	 private String telphone;//员工简历里的联系方式
	 private String psw;
	 private String empName;//姓名
	 private  int deptId;
	 private String sex;
	 private int pid;//职位id
	 private String education;//学历
	   private String mail;//邮箱
	   private String politicsStatus;//政治面貌
	   private String workExperience;//工作经验
	   private int salary;//实际薪资
	   private String interest;//兴趣爱好
	   private String  school;//毕业院校
	   private int age;
	  private String national;//民族
	  private String  nativePlace;//籍贯
	  private String major;//专业
	  private String lastWork;
	  private String status="试用期";//离职、在职、试用期
	  
	  private  Dept dept;    //一对一
	  private Position position;  //一对一
	  
	  
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Employee(int empId, String phone, String telphone, String psw, String empName, int deptId, String sex,
			int pid, String education, String mail, String politicsStatus, String workExperience, int salary,
			String interest, String school, int age, String national, String nativePlace, String major, String lastWork,
			String status) {
		super();
		this.empId = empId;
		this.phone = phone;
		this.telphone = telphone;
		this.psw = psw;
		this.empName = empName;
		this.deptId = deptId;
		this.sex = sex;
		this.pid = pid;
		this.education = education;
		this.mail = mail;
		this.politicsStatus = politicsStatus;
		this.workExperience = workExperience;
		this.salary = salary;
		this.interest = interest;
		this.school = school;
		this.age = age;
		this.national = national;
		this.nativePlace = nativePlace;
		this.major = major;
		this.lastWork = lastWork;
		this.status = status;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPoliticsStatus() {
		return politicsStatus;
	}
	public void setPoliticsStatus(String politicsStatus) {
		this.politicsStatus = politicsStatus;
	}
	public String getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	public String getNational() {
		return national;
	}
	public void setNational(String national) {
		this.national = national;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getLastWork() {
		return lastWork;
	}
	public void setLastWork(String lastWork) {
		this.lastWork = lastWork;
	}
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
