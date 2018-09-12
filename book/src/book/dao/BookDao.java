package book.dao;

import java.util.List;

import book.bean.Book;

public interface BookDao {
   public List<Book> queryAllBook();
}
