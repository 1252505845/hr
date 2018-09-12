package com.iotek.service;

import java.util.List;

import com.iotek.bean.Address;
import com.iotek.bean.User;

public interface UserService {
	public User queryUser(String name, String pwd);

	public boolean registUser(User user);

	public void updateUser(int userId, String idNo, String mobile, String email);
	
	public List<Address> queryAddressByUserId(int userId);
	
	public Address queryAddressById(int addrId);
	
	public void addAddress(Address addr);
	
	public void deleteAddress(int addrId);
}
