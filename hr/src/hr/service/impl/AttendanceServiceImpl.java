package hr.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.bean.Attendance;
import hr.bean.Employee;
import hr.bean.Rep;
import hr.bean.Review;
import hr.dao.AttendanceDao;
import hr.dao.EmpDao;
import hr.dao.RepDao;
import hr.dao.ReviewDao;
import hr.service.AttendanceService;
import hr.util.DateUtils;
@Service
public class AttendanceServiceImpl implements AttendanceService {
   @Autowired
	private  AttendanceDao attendanceDao;
   @Autowired
   private RepDao repDao;
	@Autowired
   private EmpDao empDao;
	@Autowired
	private ReviewDao reviewDao;
	
	public String getCurrentDates() {
		return DateUtils.today2( attendanceDao.getCurrentDates());
	}
	
	@Override
	public void onMinute(Date dt,int empId) {
		// TODO Auto-generated method stub
		//数据库的当前的年月日
	//String t1=DateUtils.today2( attendanceDao.getCurrentDates());

	//String t2="  09:00:00";
	//拼接成年月日  时分秒  规定的上班时间
	//String s=t1+t2;
   // Long l1=DateUtils.getDate(s).getTime();//员工的上班时间
		
		//Long l2=dt.getTime();//打卡的当前时间
	
			Attendance attendance=new Attendance();
			attendance.setEmpId(empId);
			attendance.setOnTime(dt);
			attendance.setToday(DateUtils.getToday2( attendanceDao.getCurrentDates()));
			attendanceDao.addAttendance(attendance);
	
		
	}

	@Override
	public Attendance queryAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		return attendanceDao.queryAttendance(attendance);
	}

	@Override
	public String offMinute(Attendance att) {
		//int empId=att.getEmpId();
		//Date today=att.getToday();
		Date onTime=att.getOnTime();
		Date offTime=att.getOffTime();
		//System.out.println(onTime);
		//System.out.println(offTime);
	Date repTime=DateUtils.getToday4(attendanceDao.getCurrentDates());//数据库的当前的年月日
		//数据库的当前的年月日
		String t1=DateUtils.today2( attendanceDao.getCurrentDates());
		//System.out.println(t1);
		
		String t2=" 09:00:00";
		//拼接成年月日  时分秒  规定的上班时间
		String t3=" 18:00:00";
		String s=t1+t2;
		String s2=t1+t3;
		
	    Long l1=DateUtils.getDate(s).getTime();//员工的上班时间
	
			Long l2=DateUtils.getToday2(onTime).getTime();//员工的上班打卡时间
			
			Long r1=(l1-l2)/60000;
			//System.out.println(r1);
			 Long l3=DateUtils.getDate(s2).getTime();//员工的下班时间
			 Long l4=DateUtils.getToday2(offTime).getTime();//员工的下班打卡时间
			 Long r2=(l4-l3)/60000;
			//System.out.println(r2);
		Rep rep=new Rep();
		Employee emp=empDao.queryEmpbyid(att.getEmpId());
		double money=emp.getSalary()/166*8;
				 if(r1>0) {//说明员工早上9点之前打卡没有迟到
						
					 if(r2>0) {//说明员工在6点之后打卡
							if(r2<30) {//下班打卡6:30之前
								att.setStatus(1);////正常上班打卡
								att.setStatus222(1);//正常下班打卡
								attendanceDao.updateAtt(att);
								return"正常下班!";
							}else {//下班打卡18:30之后 加班
								att.setStatus(1);////正常上班打卡
								att.setStatus222(1);//正常下班打卡
								att.setWork(1);
								attendanceDao.updateAtt(att);
								rep.setConn("加班奖励");
								rep.setEmpId(att.getEmpId());
								rep.setMoney(100);
								rep.setRepTime(repTime);
							
								repDao.addRep(rep);
								return"正常加班!";
						      }
						}
						
						if(r2>-180) {//下班打卡18:00之前 15:00之后 早退
							att.setStatus(1);////正常上班打卡
							att.setStatus222(2);//早退打卡
							attendanceDao.updateAtt(att);
							rep.setConn("早退罚款");
							rep.setEmpId(att.getEmpId());
							rep.setMoney(-50);
							rep.setRepTime(repTime);
							repDao.addRep(rep);
							return"早退打卡";
						}
						
						if(r2<=-180) {//下班打卡15:00之前 旷工
							att.setStatus(1);////正常上班打卡
							att.setStatus222(3);;//旷工打卡
							attendanceDao.updateAtt(att);
							rep.setConn("早退旷工罚款");
							rep.setEmpId(att.getEmpId());
							rep.setMoney(-money);
							rep.setRepTime(repTime);
							repDao.addRep(rep);
							return"早退超3小时，旷工处理!2222";
						}
						
					}
					
					if(r1>-180) {//上班打卡9:00之后 12:00之前 迟到
						if(r2>=0) {//下班打卡18:00之后
							if(r2<=30) {
								att.setStatus(2);//早上迟到
								att.setStatus222(1);//正常下班打卡
								attendanceDao.updateAtt(att);
								rep.setConn("迟到罚款");
								rep.setEmpId(att.getEmpId());
								rep.setMoney(-20);
								rep.setRepTime(repTime);
								repDao.addRep(rep);
								return"迟到打卡";//早上迟到
							}
							if(r2>30) {
								att.setStatus(2);//早上迟到
								att.setStatus222(1);//正常下班打卡
								att.setWork(1);//加班
								attendanceDao.updateAtt(att);
								rep.setConn("迟到罚款");
								rep.setEmpId(att.getEmpId());
								rep.setMoney(-20);
								rep.setRepTime(repTime);
								repDao.addRep(rep);
								rep.setConn("加班奖励");
								rep.setEmpId(att.getEmpId());
								rep.setMoney(100);
								rep.setRepTime(repTime);
							
								repDao.addRep(rep);
								return"迟到加班打卡!";
							}
						}
						
						if(r2>-180) {//下班打卡18:00之前 15:00之前 早退
							if(r1+r2<=-180) {//迟到加早退总时间超过3个小时
								att.setStatus(3);
								att.setStatus222(3);;//迟到早退旷工打卡
								attendanceDao.updateAtt(att);
								rep.setConn("迟到早退总时间超3小时");
								rep.setEmpId(att.getEmpId());
								rep.setMoney(-money);
								rep.setRepTime(repTime);
								repDao.addRep(rep);
								return"迟到早退超3小时，旷工处理！";
							}else {
								att.setStatus(2);//迟到
								att.setStatus222(2);//早退
								
								rep.setConn("迟到罚款");
								rep.setEmpId(att.getEmpId());
								rep.setMoney(-20);
								rep.setRepTime(repTime);
								repDao.addRep(rep);
								rep.setConn("早退罚款");
								rep.setEmpId(att.getEmpId());
								rep.setMoney(-50);
								rep.setRepTime(repTime);
								repDao.addRep(rep);
								attendanceDao.updateAtt(att);
								return"今天迟到并早退!";
							}
						}
						
						if(r2<-180) {//下班打卡15:00之前 旷工
							att.setStatus(2);//迟到
							att.setStatus222(3);;//早退超3小时旷工打卡
						attendanceDao.updateAtt(att);
						rep.setConn("迟到,早退超3小时");
						rep.setEmpId(att.getEmpId());
						rep.setMoney(-money);
						rep.setRepTime(repTime);
						repDao.addRep(rep);
						return"早退超3小时，旷工处理！3333";
						
						}
						
						
						
					}
					if(r1<-180) {//上班打卡12:00之后 旷工
						att.setStatus(3);
						rep.setConn("迟到超3小时");
						rep.setEmpId(att.getEmpId());
						rep.setMoney(-money);
						rep.setRepTime(repTime);
						repDao.addRep(rep);
						attendanceDao.updateAtt(att);
						return"迟到超3小时，旷工处理！";
					}
			 
			
			return "出问题";
			
		
	}

	@Override
	public List<Rep> queryAllRep() {
		// TODO Auto-generated method stub
		return repDao.queryAllRep();
	}

	@Override
	public List<Attendance> queryAllAtt() {
		// TODO Auto-generated method stub
		return attendanceDao.queryAllAtt();
	}

	@Override
	public String getfirstDay() {
		// TODO Auto-generated method stub
		 //DateUtils.today2( attendanceDao.getCurrentDates())
		return DateUtils.today2(attendanceDao.getfirstDay());
	}

	@Override
	public int queryWorkCount(int work, String userdate, int empId) {
		// TODO Auto-generated method stub
		return  attendanceDao.queryWorkCount(work, userdate, empId);
	}

	@Override
	public int queryStatusCount(int status, String userdate, int empId) {
		// TODO Auto-generated method stub
		return attendanceDao.queryStatusCount(status, userdate, empId);
	}

	@Override
	public int queryStatus222Count(int status222, String userdate, int empId) {
		// TODO Auto-generated method stub
		return attendanceDao.queryStatus222Count(status222, userdate, empId);
	}

	@Override
	public int queryStatus333Count(int status, int status222, String userdate, int empId) {
		// TODO Auto-generated method stub
		return attendanceDao.queryStatus333Count(status, status222, userdate, empId);
	}

	@Override
	public List<Rep> queryRepById(int empId) {
		// TODO Auto-generated method stub
		return repDao.queryRepById(empId);
	}

	@Override
	public Review query(int empId, Date date) {
		// TODO Auto-generated method stub
		return reviewDao.query(empId, date);
	}

	@Override
	public void addRev(Review review) {
		// TODO Auto-generated method stub
		reviewDao.addRev(review);
	}

	@Override
	public List<Review> queryAll() {
		// TODO Auto-generated method stub
		return reviewDao.queryAll();
	}

	@Override
	public Date getNextfirst() {
		// TODO Auto-generated method stub
		return attendanceDao.getNextfirst();
	}

	@Override
	public Rep query(int empId, String conn) {
		// TODO Auto-generated method stub
		return repDao.query(empId, conn);
	}

	


}
