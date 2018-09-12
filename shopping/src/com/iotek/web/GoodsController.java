package com.iotek.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.iotek.bean.Carts;
import com.iotek.bean.Goods;
import com.iotek.bean.User;
import com.iotek.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	@RequestMapping("/goods.action")
	public String showAll(Model model) {
		try {
			List<Goods> list = goodsService.queryAllGoods();
			model.addAttribute("goodsList", list);
		} catch (Exception e) {

		}

		return "index";
	}

	@RequestMapping("/product.action")
	public String showProduct(Integer goodsId, Model model, HttpSession session) {
		Goods goods = goodsService.queryById(goodsId);
		model.addAttribute("goods", goods);
		User user = (User) session.getAttribute("user");
		Carts carts = goodsService.queryAllCart(user.getUserId());
		model.addAttribute("carts", carts);
		return "product";
	}

	@ResponseBody
	@RequestMapping("/addToCart")
	public String addCart(Integer goodsId, HttpSession session) {
		User user = (User) session.getAttribute("user");
		goodsService.addToCart(user.getUserId(), goodsId);
		Carts carts = goodsService.queryAllCart(user.getUserId());
		String jsonStr = JSONObject.toJSONString(carts);
		return jsonStr;
	}
}
