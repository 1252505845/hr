package hr.bean;

import java.util.Date;

public class Resume {
  //简历实体类
	  private int rid;
	  private int uid;
	  private String phone;
		private String name;
	   private String sex;
	   private String education;//学历
	   private String mail;//邮箱
	   private String job;
	 //  private int deptId;//应聘的部门id
	  // private int pid;//应聘的职位id
	   private String politicsStatus;//政治面貌
	   private String workExperience;//工作经验
	   private String salaryExpectation;//期望薪资
	   private String interest;//兴趣爱好
	   private String  school;//毕业院校
	   private String age;
	  private String national;//民族
	  private String  nativePlace;//籍贯
	  private String major;//专业
	  private String lastWork;//上一份工作
	  private String sign="未查看";//标记简历是否被查看
	 private String status="没有面试";//没有面试，已通知面试，拒绝面试,接受面试，已面试
	  private Date date;//面试时间
	  private String offer;//面试官判断  面试成功  面试失败
	private String  accept ;//游客选择 接不接受录用    接受录用  拒绝录用
	
	
	
	public Resume(int rid, int uid, String phone, String name, String sex, String education, String mail, String job,
			String politicsStatus, String workExperience, String salaryExpectation, String interest, String school,
			String age, String national, String nativePlace, String major, String lastWork, String sign, String status,
			Date date, String offer, String accept) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.phone = phone;
		this.name = name;
		this.sex = sex;
		this.education = education;
		this.mail = mail;
		this.job = job;
		this.politicsStatus = politicsStatus;
		this.workExperience = workExperience;
		this.salaryExpectation = salaryExpectation;
		this.interest = interest;
		this.school = school;
		this.age = age;
		this.national = national;
		this.nativePlace = nativePlace;
		this.major = major;
		this.lastWork = lastWork;
		this.sign = sign;
		this.status = status;
		this.date = date;
		this.offer = offer;
		this.accept = accept;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	public Resume(int rid, int uid, String phone, String name, String sex, String education, String mail, String job,
			String politicsStatus, String workExperience, String salaryExpectation, String interest, String school,
			String age, String national, String nativePlace, String major, String lastWork, String sign, String status,
			Date date, String offer) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.phone = phone;
		this.name = name;
		this.sex = sex;
		this.education = education;
		this.mail = mail;
		this.job = job;
		this.politicsStatus = politicsStatus;
		this.workExperience = workExperience;
		this.salaryExpectation = salaryExpectation;
		this.interest = interest;
		this.school = school;
		this.age = age;
		this.national = national;
		this.nativePlace = nativePlace;
		this.major = major;
		this.lastWork = lastWork;
		this.sign = sign;
		this.status = status;
		this.date = date;
		this.offer = offer;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public Resume(int rid, int uid, String phone, String name, String sex, String education, String mail, String job,
			String politicsStatus, String workExperience, String salaryExpectation, String interest, String school,
			String age, String national, String nativePlace, String major, String lastWork, String sign, String status,
			Date date) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.phone = phone;
		this.name = name;
		this.sex = sex;
		this.education = education;
		this.mail = mail;
		this.job = job;
		this.politicsStatus = politicsStatus;
		this.workExperience = workExperience;
		this.salaryExpectation = salaryExpectation;
		this.interest = interest;
		this.school = school;
		this.age = age;
		this.national = national;
		this.nativePlace = nativePlace;
		this.major = major;
		this.lastWork = lastWork;
		this.sign = sign;
		this.status = status;
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Resume(int rid, int uid, String phone, String name, String sex, String education, String mail, String job,
			String politicsStatus, String workExperience, String salaryExpectation, String interest, String school,
			String age, String national, String nativePlace, String major, String lastWork, String sign,
			String status) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.phone = phone;
		this.name = name;
		this.sex = sex;
		this.education = education;
		this.mail = mail;
		this.job = job;
		this.politicsStatus = politicsStatus;
		this.workExperience = workExperience;
		this.salaryExpectation = salaryExpectation;
		this.interest = interest;
		this.school = school;
		this.age = age;
		this.national = national;
		this.nativePlace = nativePlace;
		this.major = major;
		this.lastWork = lastWork;
		this.sign = sign;
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Resume(int rid, int uid, String phone, String name, String sex, String education, String mail, String job,
			String politicsStatus, String workExperience, String salaryExpectation, String interest, String school,
			String age, String national, String nativePlace, String major, String lastWork, String sign) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.phone = phone;
		this.name = name;
		this.sex = sex;
		this.education = education;
		this.mail = mail;
		this.job = job;
		this.politicsStatus = politicsStatus;
		this.workExperience = workExperience;
		this.salaryExpectation = salaryExpectation;
		this.interest = interest;
		this.school = school;
		this.age = age;
		this.national = national;
		this.nativePlace = nativePlace;
		this.major = major;
		this.lastWork = lastWork;
		this.sign = sign;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Resume(int rid, int uid, String phone, String name, String sex, String education, String mail, String job,
			String politicsStatus, String workExperience, String salaryExpectation, String interest, String school,
			String age, String national, String nativePlace, String major, String lastWork) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.phone = phone;
		this.name = name;
		this.sex = sex;
		this.education = education;
		this.mail = mail;
		this.job = job;
		this.politicsStatus = politicsStatus;
		this.workExperience = workExperience;
		this.salaryExpectation = salaryExpectation;
		this.interest = interest;
		this.school = school;
		this.age = age;
		this.national = national;
		this.nativePlace = nativePlace;
		this.major = major;
		this.lastWork = lastWork;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
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
	public void setSalaryExpectation(String salaryExpectation) {
		this.salaryExpectation = salaryExpectation;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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
	
	public Resume() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
}
