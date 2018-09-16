package hr.bean;

public class Admin {
   private int  adminId;
   private String phone;//用于管理员的登陆
   private String psw;
   
   
   
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}

public String getPsw() {
	return psw;
}
public void setPsw(String psw) {
	this.psw = psw;
}

public Admin(int adminId, String phone, String psw) {
	super();
	this.adminId = adminId;
	this.phone = phone;
	this.psw = psw;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
  

   
}
