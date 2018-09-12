package com.iotek.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.iotek.bean.Address;
import com.iotek.bean.PairVo;
import com.iotek.bean.User;
import com.iotek.service.CommonService;
import com.iotek.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private CommonService commonService;

	@RequestMapping("/member.action")
	public String member() {
		return "member";
	}

	@ResponseBody // 告诉springmvc这个请求是ajax请求
	@RequestMapping("/changeInfo.action")
	public String changeInfo(String idNo, String mobile, String email, HttpServletResponse resp, HttpSession session) {
		User user = (User) session.getAttribute("user");
		String msg = "";
		try {
			userService.updateUser(user.getUserId(), idNo, mobile, email);
		} catch (Exception e) {
			msg = "更新错误";
		}

		// 如果是ajax请求，直接返回数据字符串（text,json,xml...）
		return msg;
	}

	@RequestMapping("/showAddress.action")
	public String showAddress(HttpSession session, HttpServletRequest req) {
		// 根据当前登录用户的id获取所有的地址信息
		User user = (User) session.getAttribute("user");
		List<Address> list = userService.queryAddressByUserId(user.getUserId());
		req.setAttribute("addrList", list);

		// 加载省信息
		req.setAttribute("plist", loadProvince());
		return "address";
	}

	@ResponseBody
	@RequestMapping("/queryAllAddr.action")
	public String queryAllAddr(HttpSession session, HttpServletRequest req) {
		User user = (User) session.getAttribute("user");
		List<Address> list = userService.queryAddressByUserId(user.getUserId());
		return JSONObject.toJSONString(list);
	}

	@ResponseBody
	@RequestMapping("/saveAddr.action")
	public String saveAddr(Address addr, HttpSession session) {
		try {
			User user = (User) session.getAttribute("user");
			addr.setUserId(user.getUserId());
			userService.addAddress(addr);
		} catch (Exception e) {
			return "1";
		}
		return "0";
	}

	@ResponseBody
	@RequestMapping("/deleteAddr.action")
	public String deleteAddr(Integer addrId) {
		try {
			userService.deleteAddress(addrId);
		} catch (Exception e) {
			return "1";
		}
		return "0";
	}

	@ResponseBody
	@RequestMapping("/queryAddrInfo.action")
	public String queryAddrInfo(Integer addrId) {
		Address addr = userService.queryAddressById(addrId);
		return JSONObject.toJSONString(addr);
	}
	
	public List<PairVo> loadProvince() {
		return commonService.loadProvince();
	}
}
