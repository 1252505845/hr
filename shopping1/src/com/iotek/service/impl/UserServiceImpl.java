package com.iotek.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.bean.Address;
import com.iotek.bean.User;
import com.iotek.dao.AddressDao;
import com.iotek.dao.UserDao;
import com.iotek.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private AddressDao addressDao;

	@Override
	public void deleteAddress(int addrId) {
		addressDao.deleteAddress(addrId);
	}

	@Override
	public Address queryAddressById(int addrId) {
		return addressDao.queryAddressByid(addrId);
	}

	@Override
	public void addAddress(Address addr) {
		//add
		if(addr.getAddrId()==0) {
			addressDao.addAddress(addr);
		}else {
			//modify
			addressDao.modifyAddress(addr);
		}		
	}

	@Override
	public List<Address> queryAddressByUserId(int userId) {
		return addressDao.queryAddressByUserId(userId);
	}

	@Override
	public void updateUser(int userId, String idNo, String mobile, String email) {
		userDao.updateUser(userId, idNo, mobile, email);
	}

	@Override
	public User queryUser(String name, String pwd) {
		return userDao.queryUser(name, pwd);
	}

	@Override
	public boolean registUser(User user) {
		// 判断用户名是否已存在
		if (userDao.queryUserName(user.getName())==1) {
			return false;
		}
		// 注册
		userDao.saveUser(user);
		return true;
	}

}
