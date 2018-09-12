package book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.bean.Book;
import book.dao.BookDao;
import book.service.BookService;
@Service
public class BookServiceImpl implements BookService {
 
	
	@Autowired
	private BookDao bookDao;
	@Override
	public List<Book> queryAllBook() {
		// TODO Auto-generated method stub
		return bookDao.queryAllBook();
		
	
	}

	
	
	

}
