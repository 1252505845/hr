package hr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.bean.Admin;
import hr.bean.Recruit;
import hr.dao.AdminDao;
import hr.dao.RecruitDao;
import hr.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
      @Autowired
	private AdminDao adminDao;
      @Autowired
      private RecruitDao recruitDao;
	
      @Override
	public Admin queryAdmin(String phone, String psw) {
		// TODO Auto-generated method stub
		return adminDao.queryAdmin(phone, psw);
	}


	

}
