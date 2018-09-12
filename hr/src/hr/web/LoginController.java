package hr.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.bean.User;
import hr.service.UserService;

@Controller
public class LoginController  {
    
	@Autowired
	private  UserService userService;
	@RequestMapping("/")
	public String index() {
		return "login";
		
	}
	@RequestMapping("/login")
	public String login(String phone,String psw,Model model,HttpSession session) {
		if(phone!=null&&psw!=null) {
			User user=userService.queryUser(phone, psw);
			if(user!=null) {
				session.setAttribute("user", user);	 
		           return "main";
			}
			model.addAttribute("message", "输入账号或密码不正确");
			return "login";        
		}
		return "login";		
	}
	
	@RequestMapping("/regist")
	public String regist(User user) {
		if(user==null) {
			return "register";
		}
		boolean res=userService.registUser(user);
		if(res==true) {
		
			return "login";
		}
	
		return "register";
		
		
	}
	
}
