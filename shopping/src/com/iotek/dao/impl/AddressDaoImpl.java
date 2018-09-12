package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iotek.bean.Address;
import com.iotek.dao.AddressDao;
import com.iotek.utils.DBUtils;

@Repository
public class AddressDaoImpl implements AddressDao {

	@Override
	public void deleteAddress(int addrId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConn();
			String sql = "delete from t_address where addr_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, addrId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(null, pstmt, conn);
		}
	}

	@Override
	public Address queryAddressByid(int addrId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Address addr = new Address();
		try {
			conn = DBUtils.getConn();
			String sql = "select addr.*, p.name pname,c.name cname,a.name aname from t_address addr,t_province p,t_city c,t_area a "
					+ " where addr.province_id=p.id and addr.city_id=c.id and addr.area_id=a.id " + " and addr_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, addrId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				addr.setAddrId(rs.getInt("addr_id"));
				addr.setUserId(rs.getInt("user_id"));
				addr.setReceiveName(rs.getString("receive_name"));
				addr.setReceivePhone(rs.getString("receive_phone"));
				addr.setPostCode(rs.getString("post_code"));
				addr.setAddr(rs.getString("address"));
				addr.setProvinceName(rs.getString("pname"));
				addr.setCityName(rs.getString("cname"));
				addr.setAreaName(rs.getString("aname"));
				addr.setProvinceId(rs.getInt("province_id"));
				addr.setCityId(rs.getInt("city_id"));
				addr.setAreaId(rs.getInt("area_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		return addr;
	}

	@Override
	public void modifyAddress(Address addr) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConn();
			String sql = "update t_address set receive_name=?, receive_phone=?, province_id=?, city_id=?, area_id=?, address=?  where addr_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, addr.getReceiveName());
			pstmt.setString(2, addr.getReceivePhone());
			pstmt.setInt(3, addr.getProvinceId());
			pstmt.setInt(4, addr.getCityId());
			pstmt.setInt(5, addr.getAreaId());
			pstmt.setString(6, addr.getAddr());
			pstmt.setInt(7, addr.getAddrId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(null, pstmt, conn);
		}
		
	}

	@Override
	public void addAddress(Address addr) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConn();
			String sql = "INSERT INTO `t_address` (`user_id`, `receive_name`, `receive_phone`, `province_id`, `city_id`, `area_id`, `address`) VALUES(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, addr.getUserId());
			pstmt.setString(2, addr.getReceiveName());
			pstmt.setString(3, addr.getReceivePhone());
			pstmt.setInt(4, addr.getProvinceId());
			pstmt.setInt(5, addr.getCityId());
			pstmt.setInt(6, addr.getAreaId());
			pstmt.setString(7, addr.getAddr());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(null, pstmt, conn);
		}
	}

	@Override
	public List<Address> queryAddressByUserId(int userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Address> list = new ArrayList<Address>();
		try {
			conn = DBUtils.getConn();
			String sql = "select addr.*, p.name pname,c.name cname,a.name aname from t_address addr,t_province p,t_city c,t_area a "
					+ " where addr.province_id=p.id and addr.city_id=c.id and addr.area_id=a.id " + " and user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			Address addr = null;
			while (rs.next()) {
				addr = new Address();
				addr.setAddrId(rs.getInt("addr_id"));
				addr.setUserId(userId);
				addr.setReceiveName(rs.getString("receive_name"));
				addr.setReceivePhone(rs.getString("receive_phone"));
				addr.setPostCode(rs.getString("post_code"));
				addr.setAddr(rs.getString("address"));
				addr.setProvinceName(rs.getString("pname"));
				addr.setCityName(rs.getString("cname"));
				addr.setAreaName(rs.getString("aname"));
				list.add(addr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		return list;
	}

}
