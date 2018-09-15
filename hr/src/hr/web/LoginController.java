package hr.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hr.bean.Admin;
import hr.bean.Employee;
import hr.bean.User;
import hr.service.AdminService;
import hr.service.EmpService;
import hr.service.UserService;

@Controller
public class LoginController  {
    
	@Autowired
	private  UserService userService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private  EmpService empService;
	
	@RequestMapping("/")
	public String index() {
		return "login";
	}
	
	@RequestMapping("/reg")
	public String regist() {
		return "register";
	}
	@RequestMapping("/user")
	public String usermian() {
		return "usermain";
	}
	
	
	@RequestMapping("/login")
	public String login(String phone,String psw,Model model,HttpSession session) {
		if(phone!=null&&psw!=null) {
			User user=userService.queryUser(phone, psw);
			if(user!=null) {
				session.setAttribute("user", user);	
				//游客登陆
				return "usermain";
			}
			Admin admin=adminService.queryAdmin(phone, psw);
			if(admin!=null) {
				session.setAttribute("admin", admin);
				//管理员登陆
				return"admin";
			}
			Employee emp=empService.queryEmp(phone, psw);
			//员工登陆
			if(emp!=null) {
				session.setAttribute("emp", emp);
				return"emp";
			}
			
			model.addAttribute("message", "输入账号或密码不正确");
			return "login";        
		}
		//账号或密码为空
		return "login";		
	}
	
	@RequestMapping("/regist")
	public String regist(String phone,String psw,String repeatPsw,Model model) {
		if(phone==null||psw==null||repeatPsw==null) {
			 model.addAttribute("msg","请输入必填项,请重新注册");
			return "register";
		}
		
		String reg="^1[3|5|7|8]\\d{9}$";
		if(!phone.matches(reg)) {
	     model.addAttribute("msg","输入的手机号不合法,，请重新注册");
	     return "register";
		}
		
		String reg2="^[0-9a-zA-Z]{6,20}$";
		if(!psw.matches(reg2)) {
			model.addAttribute("msg","输入的密码不合法,请重新注册");
			return "register";
		}
		if(!psw.equals(repeatPsw)) {
			model.addAttribute("msg","两次密码不一样,请重新注册");
			return "register";
		}
		User user=new User();
		user.setPhone(phone);
		user.setPsw(psw);
		boolean res=userService.registUser(user);
		if(!res) {
		   model.addAttribute("msg","输入的用户名已存在，请重新注册");
			return "register";
		}
		return "login";
			
	}
	@ResponseBody
	@RequestMapping("/checkPhone")
	public String checkPhone(String phone) {
		if(phone==null) {
			return"账号不能为空";
		}
		if(userService.queryUserByPhone(phone)==null) {
			return "";
		}
		
		return "账号已存在";
		
	}
	
}
