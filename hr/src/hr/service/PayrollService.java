package hr.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import hr.bean.Payroll;


public interface PayrollService {
    
	public void addPayRoll(Payroll payroll);
	public Payroll queryPayroll(int empId,Date time);
	
	public List<Payroll> queryAll();
}
