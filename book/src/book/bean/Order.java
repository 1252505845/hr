package book.bean;

public class Order {
	private int orderId;
	private User user;
	private BankCard bc;
	private String books;
	private double amount;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BankCard  getCc() {
		return bc;
	}
	public void setCc(BankCard cc) {
		this.bc = bc;
	}
	public String getBooks() {
		return books;
	}
	public void setBooks(String books) {
		this.books = books;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
