package com.iotek.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iotek.bean.User;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private List<String> excludeUrls;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 如果是excludeUrls，直接放行
		System.out.println(request.getServletPath());
//		System.out.println(request.getServerName());
//		
		String servletName = request.getServletPath();
		for (String url : excludeUrls) {
			if (servletName.endsWith(url)) {
				return true;
			}
		}

		// 判断是否已登录，如果未登录，则拦截
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return false;
		}
		return true;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

}
