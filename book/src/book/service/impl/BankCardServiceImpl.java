package book.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.bean.BankCard;
import book.bean.Book;
import book.dao.BankCardDao;
import book.dao.BookDao;
import book.service.BankCardService;
@Service
public class BankCardServiceImpl implements BankCardService{
  
	@Autowired
	private BankCardDao bankCardDao;
	@Autowired
    private BookDao bookDao;
	@Override
	public boolean validateCard(Integer kind, String cardNumber) {
		 BankCard bc=bankCardDao.queryCard(kind, cardNumber);
		 if(bc!=null) {
			 return true;
			 
		 }
		return false;
	
	}

	@Override
	public boolean validateBalance(Integer kind, String cardNumber, String[] bname) {
		// TODO Auto-generated method stub
	List<Book>list=	bookDao.queryAllBook();
	//½«list×ª»»Îªmap
	Map<String, Book> map=new HashMap<>();
	for (Book book : list) {
		map.put(book.getBname(), book);
	}
	 double tatal=0;
	 Book book=null;
	for (String name : bname) {
		book=map.get(name);
		tatal+=book.getPrice();
	}
	
	 BankCard bc=bankCardDao.queryCard(kind, cardNumber);
	 if(bc.getMoney()<tatal) {
		 return false;
	 }
		return true;
	}
	

}
