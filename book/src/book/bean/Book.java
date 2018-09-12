package book.bean;

public class Book {
  private  int bid;
  private  String bname;
   private  double price;
   
public Book(int bid, String bname, double price) {
	super();
	this.bid = bid;
	this.bname = bname;
	this.price = price;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}

public Book(int bid, String bname) {
	super();
	this.bid = bid;
	this.bname = bname;

}
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
  
}
