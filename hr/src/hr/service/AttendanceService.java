package hr.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import hr.bean.Attendance;
import hr.bean.Rep;
import hr.bean.Review;
import hr.dao.AttendanceDao;

@Service
public interface AttendanceService {
     
	 public Attendance  queryAttendance(Attendance attendance);
	/**
	 * 比较上班打卡的时间与规定的时间
	 * @return
	 */
	
	public  void onMinute(Date dt,int empId);
	
	public  String offMinute(Attendance attendance);
	
	//管理员查看所有的奖惩记录
		public List<Rep> queryAllRep();
		public List<Rep>  queryRepById(int empId);
		 public List<Attendance> queryAllAtt();
		 
		 public String getCurrentDates();
			public String getfirstDay();
			   public int  queryWorkCount(int work,String userdate,int empId);
			   public int  queryStatusCount(int status,String userdate,int empId);
			    public int  queryStatus222Count(int status222,String userdate,int empId);
			    public int  queryStatus333Count(int status,int status222,String userdate,int empId);	 
			    
			    public void addRev(Review review);
				public Review query(int empId,Date date);
				public List<Review> queryAll();
				public Rep  query(int empId,String conn);
				public Date getNextfirst();
}
