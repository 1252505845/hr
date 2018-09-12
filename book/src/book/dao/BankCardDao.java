package book.dao;

import book.bean.BankCard;

public interface BankCardDao {
    public BankCard  queryCard(Integer kind,String cardNumber);
}
