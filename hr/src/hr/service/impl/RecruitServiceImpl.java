package hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.bean.Recruit;
import hr.bean.Resume;
import hr.dao.RecruitDao;
import hr.service.RecruitService;

@Service
public class RecruitServiceImpl implements RecruitService {
    @Autowired
	private RecruitDao recruitDao;

	@Override
	public void addRecruit(Recruit recruit) {
		// TODO Auto-generated method stub
		
		recruitDao.addRecruit(recruit);
		
	}
	
	 
	

}
