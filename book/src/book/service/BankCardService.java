package book.service;


public interface BankCardService {
    public boolean validateCard(Integer kind,String cardNumber);
    public  boolean validateBalance(Integer kind,String cardNumber,String[]bname);
}
