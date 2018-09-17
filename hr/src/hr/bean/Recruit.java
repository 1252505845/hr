package hr.bean;

import java.util.Date;
/**
 * 招聘信息表
 * @author Administrator
 *
 */
public class Recruit {
	
	
      private int recId;//招聘信息ID
      private int adminId;//发布招聘信息的管理员ID
      private String company;//招聘单位
      private  String pay;//待遇，用下拉框显示薪资区间
      private String addr;
      private String workExperience;//工作经验
	   private String education;//学历
      private String content;//招聘信息内容
      private int deptId;
      private int pid;
      private String deptName;
      private String posName;
      private Date createTime;//发布时间
	
      
      
      
      
      
      public Recruit(int recId, int adminId, String company, String pay, String addr, String workExperience,
			String education, String content, int deptId, int pid, String deptName, String posName, Date createTime) {
		super();
		this.recId = recId;
		this.adminId = adminId;
		this.company = company;
		this.pay = pay;
		this.addr = addr;
		this.workExperience = workExperience;
		this.education = education;
		this.content = content;
		this.deptId = deptId;
		this.pid = pid;
		this.deptName = deptName;
		this.posName = posName;
		this.createTime = createTime;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getPosName() {
		return posName;
	}
	public void setPosName(String posName) {
		this.posName = posName;
	}
	public Recruit(int recId, int adminId, String company, String pay, String addr, String workExperience,
			String education, String content, int deptId, int pid, Date createTime) {
		super();
		this.recId = recId;
		this.adminId = adminId;
		this.company = company;
		this.pay = pay;
		this.addr = addr;
		this.workExperience = workExperience;
		this.education = education;
		this.content = content;
		this.deptId = deptId;
		this.pid = pid;
		this.createTime = createTime;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Recruit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getRecId() {
		return recId;
	}
	public void setRecId(int recId) {
		this.recId = recId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
      
      
      
      
}
