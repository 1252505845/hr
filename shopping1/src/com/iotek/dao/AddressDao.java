package com.iotek.dao;

import java.util.List;

import com.iotek.bean.Address;

public interface AddressDao {

	/**
	 * 根据用户id查找地址信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<Address> queryAddressByUserId(int userId);

	/**
	 * 新增一个地址
	 * 
	 * @param addr
	 */
	public void addAddress(Address addr);
	
	/**
	 * modify address
	 * @param addr
	 */
	public void modifyAddress(Address addr);
	

	/**
	 * 删除一个地址
	 * 
	 * @param addrId
	 */
	public void deleteAddress(int addrId);

	/**
	 * 根据id查找地址
	 * 
	 * @param addrId
	 * @return
	 */
	public Address queryAddressByid(int addrId);
}
