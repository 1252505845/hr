package com.iotek.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.bean.User;
import com.iotek.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	/**
	 * 访问首页
	 * @return
	 */
	@RequestMapping("/index.action")
	public String index() {
		return "login";
	}
	
	@RequestMapping("/loginServlet.action")
	public String login(String loginName,String password,HttpServletRequest req) {
		if (loginName == null || "".equals(loginName) || password == null || "".equals(password)) {
			req.setAttribute("errorMsg", "用户名或密码不能为空");
			return "login";
		}

		User user = userService.queryUser(loginName, password);
		if (user == null) {
			req.setAttribute("errorMsg", "用户名或密码不正确");
			return "login";
		}
		req.getSession().setAttribute("user", user);
		//默认是forward
		//如果需要重定向，前面加redirect
		return "redirect:goods.action";
	}
}
