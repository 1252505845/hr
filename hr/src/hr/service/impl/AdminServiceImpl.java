package hr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.bean.Admin;
import hr.dao.AdminDao;
import hr.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
      @Autowired
	private AdminDao adminDao;
	
      @Override
	public Admin queryAdmin(String phone, String psw) {
		// TODO Auto-generated method stub
		return adminDao.queryAdmin(phone, psw);
	}

	

}
