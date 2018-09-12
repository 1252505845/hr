package book.bean;

public class BankCard {
  private String cardNumber;
  private int  uid;
  private int kind;
  private double money;
public String getCardNumber() {
	return cardNumber;
}
public void setCardNumber(String cardNumber) {
	this.cardNumber = cardNumber;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getKind() {
	return kind;
}
public void setKind(int kind) {
	this.kind = kind;
}
public double getMoney() {
	return money;
}
public void setMoney(double money) {
	this.money = money;
}
public BankCard(String cardNumber, int uid, int kind, double money) {
	super();
	this.cardNumber = cardNumber;
	this.uid = uid;
	this.kind = kind;
	this.money = money;
}
public BankCard() {
	super();
	// TODO Auto-generated constructor stub
}
  
  
  
  
}
