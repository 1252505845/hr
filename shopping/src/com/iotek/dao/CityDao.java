package com.iotek.dao;

import java.util.List;

import com.iotek.bean.PairVo;

public interface CityDao {
	public List<PairVo> loadData(int pid);
}
