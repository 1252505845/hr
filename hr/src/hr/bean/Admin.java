package hr.bean;

public class Admin {
   private int  adminId;
   private String adminPhone;//用于管理员的登陆
   private String psw;
   
   
   
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getAdminPhone() {
	return adminPhone;
}
public void setAdminPhone(String adminPhone) {
	this.adminPhone = adminPhone;
}
public String getPsw() {
	return psw;
}
public void setPsw(String psw) {
	this.psw = psw;
}
public Admin(int adminId, String adminPhone, String psw) {
	super();
	this.adminId = adminId;
	this.adminPhone = adminPhone;
	this.psw = psw;
}
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
  

   
}
