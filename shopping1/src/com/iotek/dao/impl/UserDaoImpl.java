package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.iotek.bean.User;
import com.iotek.dao.UserDao;
import com.iotek.utils.DBUtils;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public User queryUser(String name, String pwd) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
		User user = null;
//		try {
//			conn = DBUtils.getConn();
//			String sql = "select * from t_user where user_name=? and user_pwd=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			pstmt.setString(2, pwd);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				user = new User();
//				user.setUserId(rs.getInt("user_id"));
//				user.setName(rs.getString("user_name"));
//				user.setPwd(rs.getString("user_pwd"));
//				user.setMobile(rs.getString("mobile"));
//				user.setEmail(rs.getString("email"));
//				user.setInviteName(rs.getString("invite_name"));
//				user.setInviteId(rs.getInt("invite_id"));
//				user.setIdNo(rs.getString("id_no"));
//				user.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
//				user.setUpdateTime(new Date(rs.getTimestamp("update_time").getTime()));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBUtils.close(rs, pstmt, conn);
//		}
		return user;
	}

	@Override
	public int queryUserName(String name) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBUtils.getConn();
//			String sql = "select 1 from t_user where user_name=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				return true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBUtils.close(rs, pstmt, conn);
//		}
		return 1;
	}

	@Override
	public void saveUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = " insert into t_user(user_name,user_pwd,email,mobile,"
					+ " invite_name,invite_id,create_time,update_time) " + " values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getMobile());
			pstmt.setString(5, user.getInviteName());
			pstmt.setInt(6, user.getInviteId());
			Timestamp t = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(7, t);
			pstmt.setTimestamp(8, t);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
	}

	@Override
	public void updateUser(int userId, String idNo, String mobile, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConn();
			String sql = "update t_user set id_no=?,mobile=?,email=? where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idNo);
			pstmt.setString(2, mobile);
			pstmt.setString(3, email);
			pstmt.setInt(4, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(null, pstmt, conn);
		}
	}

}
