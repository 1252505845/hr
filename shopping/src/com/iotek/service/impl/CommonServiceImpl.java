package com.iotek.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.bean.PairVo;
import com.iotek.dao.AreaDao;
import com.iotek.dao.CityDao;
import com.iotek.dao.ProvinceDao;
import com.iotek.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private ProvinceDao provinceDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	private AreaDao areaDao;

	@Override
	public List<PairVo> loadCity(int pid) {
		return cityDao.loadData(pid);
	}

	@Override
	public List<PairVo> loadArea(int cid) {
		return areaDao.loadData(cid);
	}

	@Override
	public List<PairVo> loadProvince() {
		return provinceDao.loadData();
	}

}
