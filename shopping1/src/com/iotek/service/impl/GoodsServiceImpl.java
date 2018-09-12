package com.iotek.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.bean.Goods;
import com.iotek.dao.GoodsDao;
import com.iotek.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;

	@Override
	public List<Goods> queryAllGoods() {
		return goodsDao.queryAllGoods();
	}

//	public Goods queryById() {
//		SqlSession driverClassName = MyBatisUtils.getSession();
//		goodsDao = session.getMapper(GoodsDao.class);
////		Goods para=new Goods();
////		para.setGoodsId(1);
//		Goods goods = goodsDao.queryGoodsByNameAndPrice("橄榄油", 88);
//		return goods;
//	}
//	
//	public static void main(String[] args) {
//		Goods goods= new GoodsServiceImpl().queryById();
//		System.out.println(goods);
//	}

}
