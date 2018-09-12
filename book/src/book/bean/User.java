package book.bean;

public class User {
   private int uid;
   private String name;
   private String addr;
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public User(int uid, String name, String addr) {
	super();
	this.uid = uid;
	this.name = name;
	this.addr = addr;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
   
}
