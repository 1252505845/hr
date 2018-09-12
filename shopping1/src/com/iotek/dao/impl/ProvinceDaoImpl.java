package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iotek.bean.PairVo;
import com.iotek.dao.ProvinceDao;
import com.iotek.utils.DBUtils;

@Repository
public class ProvinceDaoImpl implements ProvinceDao {

	@Override
	public List<PairVo> loadData() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PairVo> list = new ArrayList<PairVo>();
		try {
			conn = DBUtils.getConn();
			String sql = "select id,name from t_province";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			PairVo vo = null;
			while (rs.next()) {
				vo = new PairVo();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		return list;
	}

}
