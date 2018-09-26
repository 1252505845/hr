package hr.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.bean.Payroll;
import hr.dao.PayrollDao;
import hr.service.PayrollService;
@Service
public class PayrollServiceImpl implements PayrollService {

	@Autowired
	private PayrollDao payrollDao;
	@Override
	public void addPayRoll(Payroll payroll) {
		// TODO Auto-generated method stub
		payrollDao.addPayRoll(payroll);
	}
	@Override
	public Payroll queryPayroll(int empId, Date time) {
		// TODO Auto-generated method stub
		return payrollDao.queryPayroll(empId, time);
	}
	@Override
	public List<Payroll> queryAll() {
		// TODO Auto-generated method stub
		return payrollDao.queryAll();
	}

	

}
