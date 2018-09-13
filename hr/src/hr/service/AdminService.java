package hr.service;

import hr.bean.Admin;


public interface AdminService {
	
	public Admin queryAdmin(String phone,String psw);
}
