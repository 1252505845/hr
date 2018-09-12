package hr.bean;

public class User {
   private int uid;
   private String phone;//电话号码  也是登陆的账号
   private String psw;
   private  String name;//简历上填写的真实姓名
   private String sex;
   private String education;//教育背景
   private String mail;//邮箱
   private String job;//应聘职位
   private String politicsStatus;//政治面貌
   private String workExperience;//工作经验
   private String salaryExpectation;//期望薪资
   private String interest;//兴趣爱好
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getPsw() {
	return psw;
}
public void setPsw(String psw) {
	this.psw = psw;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
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
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
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
public String getSalaryExpectation() {
	return salaryExpectation;
}
public void setSalary_expectation(String salaryExpectation) {
	this.salaryExpectation = salaryExpectation;
}
public String getInterest() {
	return interest;
}
public void setInterest(String interest) {
	this.interest = interest;
}
public User(int uid, String phone, String psw, String name, String sex, String education, String mail, String job,
		String politicsStatus, String workExperience, String salaryExpectation, String interest) {
	super();
	this.uid = uid;
	this.phone = phone;
	this.psw = psw;
	this.name = name;
	this.sex = sex;
	this.education = education;
	this.mail = mail;
	this.job = job;
	this.politicsStatus = politicsStatus;
	this.workExperience = workExperience;
	this.salaryExpectation = salaryExpectation;
	this.interest = interest;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
   
}
