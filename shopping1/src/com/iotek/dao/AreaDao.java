package com.iotek.dao;

import java.util.List;

import com.iotek.bean.PairVo;

public interface AreaDao {
	public List<PairVo> loadData(int cid);
}
