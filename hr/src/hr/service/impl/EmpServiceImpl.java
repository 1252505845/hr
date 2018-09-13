package hr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.bean.Employee;
import hr.dao.EmpDao;
import hr.service.EmpService;
@Service
public class EmpServiceImpl implements EmpService {
     @Autowired
	private EmpDao empDao;
	
	@Override
	public Employee queryEmp(String phone, String psw) {
		// TODO Auto-generated method stub
		return empDao.queryEmp(phone, psw);
	}

	

}
