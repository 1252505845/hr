package com.iotek.service;

import java.util.List;

import com.iotek.bean.PairVo;

public interface CommonService {

	/**
	 * 加载省信息
	 * 
	 * @return
	 */
	public List<PairVo> loadProvince();

	/**
	 * 根据省id加载城市信息
	 * 
	 * @param pid
	 * @return
	 */
	public List<PairVo> loadCity(int pid);

	/**
	 * 根据城市id加载区信息
	 * 
	 * @param cid
	 * @return
	 */
	public List<PairVo> loadArea(int cid);
}
