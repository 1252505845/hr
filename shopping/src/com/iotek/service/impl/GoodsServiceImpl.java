package com.iotek.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.bean.Cart;
import com.iotek.bean.Carts;
import com.iotek.bean.Goods;
import com.iotek.dao.CartDao;
import com.iotek.dao.GoodsDao;
import com.iotek.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private CartDao cartDao;

	@Override
	public List<Goods> queryAllGoods() {
		return goodsDao.queryAllGoods();
	}

	@Override
	public Goods queryById(int goodsId) {
		return goodsDao.queryGoodsById(goodsId);
	}

	@Override
	public void addToCart(int userId, int goodsId) {
		// query all
		Carts carts = queryAllCart(userId);

		Cart cart = null;
		for (Cart c : carts.getCartList()) {
			if (c.getGoods().getGoodsId() == goodsId) {
				cart = c;
				break;
			}
		}
		if (cart == null) {
			cart = new Cart();
			cart.setUserId(userId);
			cart.setQty(1);
			Goods goods = new Goods();
			goods.setGoodsId(goodsId);
			cart.setGoods(goods);
			cartDao.addCart(cart);
		} else {
			cart.setQty(cart.getQty()+1);
			cartDao.updateCart(cart);
		}

	}

	@Override
	public Carts queryAllCart(int userId) {
		List<Cart> list = cartDao.queryAll(userId);
		Carts carts = new Carts();
		carts.setCartList(list);
		int totalQty = 0;
		double totalAmount = 0;
		for (Cart cart : list) {
			totalQty += cart.getQty();
			totalAmount += cart.getGoods().getPrice() * cart.getQty();
		}
		carts.setTotalAmount(totalAmount);
		carts.setTotalQty(totalQty);
		return carts;
	}

}
