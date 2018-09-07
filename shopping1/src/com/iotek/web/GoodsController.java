package com.iotek.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.bean.Goods;
import com.iotek.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("goods.action")
	public String showAll(Model model) {
		List<Goods> list = goodsService.queryAllGoods();
		model.addAttribute("goodsList",list);
		return "index";	
	}
}
