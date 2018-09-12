package book.web;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import book.bean.BankCard;
import book.bean.Order;
import book.bean.User;
import book.service.BankCardService;

@Controller
public class BankCardController {
	@Autowired
    private BankCardService bankCardService;
	@RequestMapping("/book")
	public String queryKind(String[] bname,HttpSession session) {
		//System.out.println(bname);
	  session.setAttribute("bnameList", bname);
		return "member";	
	}
	
	@RequestMapping("/showOrder")
	public String checkCard(User user,BankCard bankCard,HttpSession session) {
		Order order=new Order();
		order.setUser(user);
		order.setCc(bankCard);
		session.setAttribute("order", order);
		return "show_order";
	
	}
	@RequestMapping("/saveOrder")
	public String saveorder() {
		
		return null;
		
		
	}
	@ResponseBody
	@RequestMapping("/validateCard")
	public String validateCard(Integer kind,String cardNumber,HttpSession session) {
		//验证卡号是否存在
		boolean res=bankCardService.validateCard(kind, cardNumber);
		if(res==false) {
			return "卡号不存在";		
		}
	 String[]bname=  (String[]) session.getAttribute("bnameList");
		boolean  res2=bankCardService.validateBalance(kind, cardNumber, bname);
		if(res2==false) {
			return"余额不足";
		}
		return "";
		
	}
	
}
