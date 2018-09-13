package hr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.bean.User;
import hr.dao.UserDao;
import hr.service.UserService;

@Service
public class UserServiceImpl implements UserService {
      
	@Autowired
	private UserDao userDao;
	
	@Override
	public User queryUser(String phone, String psw) {
		// TODO Auto-generated method stub
		return userDao.queryUser(phone, psw);
	}

	@Override
	public boolean registUser(User user) {
		// TODO Auto-generated method stub
		
		if(userDao.queryUserByPhone(user.getPhone())==null) {
			//说明没找到相同的账号，此账号可以注册
			userDao.addUser(user);
			return true;
		}
		return false;
	}

	@Override
	public Integer queryUserByPhone(String phone) {
		// TODO Auto-generated method stub
		return userDao.queryUserByPhone(phone);
	
	}

}
