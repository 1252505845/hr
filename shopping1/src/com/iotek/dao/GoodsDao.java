package com.iotek.dao;

import java.util.List;

import com.iotek.bean.Goods;

public interface GoodsDao {
	/**
	 * 查询所有商品
	 * 
	 * @return
	 */
	public List<Goods> queryAllGoods();
	
	public Goods queryGoodsById(Goods goods);
	
	public Goods queryGoodsByNameAndPrice(String name, double price);
	
}
