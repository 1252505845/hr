package book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import book.bean.Book;
import book.service.BookService;

@Controller
public class BookController {
    
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/")
	public String  querybook(Model model) {
		List<Book> list=bookService.queryAllBook();
		model.addAttribute("bookList", list);
		return "first";
		
		
	}
}
