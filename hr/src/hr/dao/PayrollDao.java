package hr.dao;

import java.util.Date;
import java.util.List;

import hr.bean.Payroll;

public interface PayrollDao {

	
	public void addPayRoll(Payroll payroll);
	
	
	
	public Payroll queryPayroll(int empId,Date time);
	
	
	public List<Payroll> queryAll();
}
