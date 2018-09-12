package com.iotek.dao;

import java.util.List;

import com.iotek.bean.Cart;

public interface CartDao {
	public void addCart(Cart cart);
	
	public void updateCart(Cart cart);
	
	public List<Cart> queryAll(int userId);
	
	public Cart queryById(int cartId);
}
