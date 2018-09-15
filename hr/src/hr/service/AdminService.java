package hr.service;

import hr.bean.Admin;
import hr.bean.Recruit;


public interface AdminService {
	
	public Admin queryAdmin(String phone,String psw);
	
	
}
