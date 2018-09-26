package hr.dao;

import java.util.Date;
import java.util.List;

import hr.bean.Attendance;

public interface AttendanceDao {

	/**
	 * 获取数据库当前的时间  年月日
	 * @return
	 */
	public Date getCurrentDates();
	//得到当前月的第一天
	public Date getfirstDay();
	//获取下个月第一天
	public Date getNextfirst();
	
   /**
    * 员工打上班卡时 增加考勤记录
    * @param attendance
    */
    public void addAttendance(Attendance attendance);
    /**
     * 根据员工编号和 打卡时间查找员工的考勤记录
     * @param attendance
     * @return
     */
    
    public Attendance  queryAttendance(Attendance attendance);
    
    
    public void updateAtt(Attendance attendance);
    public List<Attendance> queryAllAttbyId(int empId);
    
    //管理员查看所有考勤
    
    public List<Attendance> queryAllAtt();
    //查询在某月某员工的加班次数
    public int  queryWorkCount(int work,String userdate,int empId);
    
  //查询在某月某员工的迟到次数   //旷工的次数
    public int  queryStatusCount(int status,String userdate,int empId);
    
  //查询在某月某员工的早退次数  //旷工的次数
    public int  queryStatus222Count(int status222,String userdate,int empId);
   
	//查询某月某员工的上下班情况
    public int  queryStatus333Count(int status,int status222,String userdate,int empId);
}
