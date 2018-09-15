package hr.bean;

import java.util.Date;
/**
 * 招聘信息表
 * @author Administrator
 *
 */
public class Recruit {
	
	
      private int recId;//招聘信息ID
      private String company;//招聘单位
      private  String pay;//待遇，用下拉框显示薪资区间
      private String content;//招聘信息内容
      private int deptId;
      private int pid;
      private Date createTime;//发布时间
	
      
      
      
      
      
      public Recruit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recruit(int recId, String company, String pay, String content, int deptId, int pid, Date createTime) {
		super();
		this.recId = recId;
		this.company = company;
		this.pay = pay;
		this.content = content;
		this.deptId = deptId;
		this.pid = pid;
		this.createTime = createTime;
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
