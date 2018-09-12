package com.iotek.service;

import java.util.List;

import com.iotek.bean.Carts;
import com.iotek.bean.Goods;

public interface GoodsService {
	public List<Goods> queryAllGoods();

	public Goods queryById(int goodsId);

	/**
	 * add goods to cart
	 * 
	 * @param userId
	 * @param goodsId
	 */
	public void addToCart(int userId, int goodsId);

	/**
	 * query all cart
	 * 
	 * @param userId
	 * @return
	 */
	public Carts queryAllCart(int userId);
}
