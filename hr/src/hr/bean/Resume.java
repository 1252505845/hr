package hr.bean;

public class Resume {
  //简历实体类
	  private int rid;
		private String name;
	   private String sex;
	   private String education;//学历
	   private String mail;//邮箱
	   private String job;//应聘职位
	   private String politicsStatus;//政治面貌
	   private String workExperience;//工作经验
	   private String salaryExpectation;//期望薪资
	   private String interest;//兴趣爱好
	   private String  school;//毕业院校
	   private int age;
	  private String national;//民族
	  private String  nativePlace;//籍贯
	  private String major;//专业
	  private String lastWork;//上一份工作
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
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
	public Resume(int rid, String name, String sex, String education, String mail, String job, String politicsStatus,
			String workExperience, String salaryExpectation, String interest, String school, int age, String national,
			String nativePlace, String major, String lastWork) {
		super();
		this.rid = rid;
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
	public Resume() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
}
