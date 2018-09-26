package hr.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import hr.bean.Attendance;
import hr.bean.Dept;
import hr.bean.Employee;
import hr.bean.Payroll;
import hr.bean.Position;
import hr.bean.Rep;
import hr.bean.Resume;
import hr.bean.Review;
import hr.bean.User;
import hr.dao.RepDao;
import hr.service.AttendanceService;
import hr.service.DeptService;
import hr.service.EmpService;
import hr.service.PayrollService;
import hr.service.PositionService;
import hr.service.ResumeService;
import hr.service.SelectJobService;
import hr.service.UserService;
import hr.util.DateUtils;

@Controller
public class empController {
	@Autowired
	private  UserService userService;
	  @Autowired
		private ResumeService resumeService;
		@Autowired
	    private SelectJobService selectJobService;
		@Autowired
		private EmpService empService;
		@Autowired
		private DeptService deptService;
		@Autowired
		private PositionService  positionService;
	  @Autowired
		private AttendanceService attendanceService;
	  @Autowired
	  private PayrollService payrollService;
		@Autowired
	  private RepDao repDao;
	  
		@RequestMapping("/emp")
		public String emp() {
				return "emp";	
		}
		
		@RequestMapping("/empManage")
		public String regist() {
			return "adEmpManage";
		}
	
	  /**
		 * 管理员新增用户
		 * @return
		 */
	  @RequestMapping("/addEmp")
	  public String addEmp(Model model) {
		  List<Resume>list=resumeService.queryResumeByAccept("接受录用");
		  model.addAttribute("resumeList", list);
		  List<Dept>list2=selectJobService.queryALLDept();
			model.addAttribute("deptList", list2);
			
		return "addEmp";
		  
	  }
	  
	  @RequestMapping("/addEmpTrue")
	  public String addEmpTrue(int deptId,int pid,int uid,int rid,String salay,Model model) {
		  /*System.out.println(deptId);
		  System.out.println(pid);
		  System.out.println(uid);
		  System.out.println(salay);*/
		 
		  if(deptId==0||pid==0
				  ||uid==0||salay==null) {
			  model.addAttribute("msg","添加失败，请输入必填项");
			  return "adde";
		  }
			  
			  int salay2= Integer.parseInt(salay);
			  Resume resume=resumeService.queryResumeByRid(rid);
			  User user=userService.queryById(uid);
			  
			  Employee emp=new Employee();
			  emp.setAge( Integer.parseInt(resume.getAge()));
			  emp.setSalary(salay2);
			//Dept dept= deptService.queryByName(deptName);
			  emp.setDeptId(deptId);
			
			  emp.setPid(pid);
			  emp.setEducation(resume.getEducation());
			  emp.setEmpName(resume.getName());
			  emp.setInterest(resume.getInterest());
			  emp.setLastWork(resume.getLastWork());
			  emp.setMail(resume.getMail());
			  emp.setMajor(resume.getMajor());
			  emp.setNational(resume.getNational());
			  emp.setNativePlace(resume.getNativePlace());
			  emp.setPhone(user.getPhone());
			  emp.setPoliticsStatus(resume.getPoliticsStatus());
			  emp.setPsw(user.getPsw());
			  emp.setSchool(resume.getSchool());
			  emp.setSex(resume.getSex());
			  emp.setTelphone(resume.getPhone());
			  emp.setWorkExperience(resume.getWorkExperience());
			 
			  empService.addEmp(emp);
			  userService.del(uid);
			  resumeService.delResume(rid);
			 
			 
			  model.addAttribute("emp", emp);
			  model.addAttribute("msg","添加成功");
			  return "adde";
			  
	
	  }
	  @RequestMapping("/updateEmp")
	 public String updateEmp(Model model) {
		  List<Dept>list2=selectJobService.queryALLDept();
			model.addAttribute("deptList", list2);
		  
		return "updateEmp";
		 
	 }
	  @ResponseBody
	  @RequestMapping("/updateEmployee")
	  public String updateEmployee(String phone,Integer deptId,Integer pid) {
		 /* System.out.println(phone);
		  System.out.println(deptId);
		  System.out.println(pid);*/
		  if(phone==null||phone==""||deptId==0||pid==0||deptId==null||pid==null) {
			  return"必填项不能为空";
		  }
		  Employee emp=empService.queryEmp2(phone);
		  if(emp==null) {
			  return "没有找到该员工";
		  }
		  emp.setDeptId(deptId);
		  emp.setPid(pid);
		  empService.updateEmp(emp);
		return "该员工换岗成功";
		  
	  }
	  @RequestMapping("/delempl")
	  public String delempl() {  
		return "delempl";
		  
	  }
	  @ResponseBody
	  @RequestMapping("/delEmp")
	  public String   delEmp(String phone) {
		  if(phone==null||phone=="") {
			  return"账号不能为空";
		  }
		  Employee emp=empService.queryEmp2(phone);
		  if(emp==null) {
			  return"没有找到该员工";
		  }
		  if(("离职").equals(emp.getStatus())) {
			  empService.delEmpbyphone(phone);
			  return"删除成功";
		  }
		return "该员工处于在职状态,不能删除";
		  
	  }
	  
	  @RequestMapping("/adLookAllEmp")
	  public String adLookAllEmp(Model model) {
		  List<Employee>list=empService.queryAllEmp();
		  if(list.size()==0) {
			  model.addAttribute("msg", "没有员工");
			  return "adLookAllEmp";
		  }
		  model.addAttribute("empList", list);
		return "adLookAllEmp";
		  
	  }
	  @RequestMapping("/empLookAllEmp")
	  public String empLookAllEmp(Model model) {
		  List<Dept>list=selectJobService.queryALLDept();
			model.addAttribute("deptList", list);
		return "empLookAllEmp";
		  
	  }
	  @ResponseBody
		@RequestMapping("/queryPos222")
		public String queryPos(int deptId) {
			List<Position> list=selectJobService.queryPositionbyId(deptId);
			return JSONObject.toJSONString(list);
			
		}
	  @RequestMapping("/lookemp")
	  public String lookemp(int deptId,int pid,Model model) {
		  if(deptId==0||pid==0) {
			  model.addAttribute("msg", "请输入必填项");
			   return "lookemp";
		  }
		  List<Employee>list=empService.querybypid222(pid);
		  if(list.size()==0) {
			  model.addAttribute("msg", "该职位下没有员工");
			   return "lookemp";
		  }
		 model.addAttribute("empList", list);
		return "lookemp";
		  
	  }
	  
	  /**
	   * 考勤打卡页面
	   */
	  @RequestMapping("/Attendance")
	  public String Attendance() {
		return "Attendance";
		  
	  }
	  /**
	   * 打卡
	   * @return
	   */
	  @ResponseBody
	  @RequestMapping("/on")
	  public String on(HttpSession session) {
		  //员工的打卡时间 年月日
		 Date date=DateUtils.getToday3();
		 Employee emp=(Employee) session.getAttribute("emp");
		 if(date==null||emp==null) {
			 return"没找到该用户";
		 }
		 int empId=emp.getEmpId();
		
		 /**
		  * 先根据打卡的年月日  和empId 查找有没有打卡记录 
		  * 如果有 说明该员工重复打上班卡 
		  * 此时提醒他不可重复打卡
		  */
			Attendance attendance=new Attendance();
			attendance.setEmpId(empId);
			attendance.setToday(date);
			Attendance att= attendanceService.queryAttendance(attendance);
			if(att!=null) {
				//说明今天已经打过上班卡了
				return "你已经打过上班卡，不可重复打卡";
			}
		  //员工的上班打卡时间 年月日  时分秒
		 Date dt=DateUtils.getToday();
		 // System.out.println(dt);
		
		  attendanceService.onMinute(dt,empId);
		  return"上班打卡成功!";
		  
	  }
	  @ResponseBody
	  @RequestMapping("/off")
	  public String off(HttpSession session) {
		//员工的打卡时间 年月日
			 Date date=DateUtils.getToday3();
			 Employee emp=(Employee) session.getAttribute("emp");
			
			 if(date==null||emp==null) {
				 return"没找到该用户";
			 }
			 int empId=emp.getEmpId();
			 Attendance attendance=new Attendance();
				attendance.setEmpId(empId);
				attendance.setToday(date);
				Attendance att= attendanceService.queryAttendance(attendance);
				if(att==null) {
					//说明今天还没打上班卡
					return "今天未打卡!";
				}
				if(att.getOffTime()!=null) {
					return"已经打过下班卡";
				}
				//员工的下班打卡时间 年月日  时分秒
				 Date dt=DateUtils.getToday();
				//attendanceService.offMinute(dt,empId);
				 //System.out.println(dt);
				 att.setOffTime(dt);
				return attendanceService.offMinute(att);
		             
		  
	  }
	  
	  @RequestMapping("/emplookpay")
	  public String emplookpay() {
		  
		return "emplookpay";
		  
	  }
	  @RequestMapping("/empPay")
	  public String empPay(String userdate,HttpSession session,Model model) {
		  if(userdate==null||userdate=="") {
			  model.addAttribute("msg", "请输入必填项");
			  
			  return"empPay2";
		  }
		  Employee emp=(Employee) session.getAttribute("emp");
		  if(emp==null) {
				 model.addAttribute("msg", "没有找到该员工");
							  
							  return"empPay2";
		  }
		  
		  String s=userdate+"-01";//2018-09-01
		 Date time= DateUtils.getDate2(s);
		 Payroll payroll=payrollService.queryPayroll(emp.getEmpId(), time);
		 if(payroll==null) {
			 model.addAttribute("msg", "该月工资还没发放");
			  
			  return"empPay2";
		 }
		 model.addAttribute("payroll", payroll);
		return "empPay";
		  
	  }
	  @RequestMapping("/lookRep")
	  public String lookRep(Model model,HttpSession session) {
		  Employee emp=(Employee) session.getAttribute("emp");
		  if(emp==null) {
				 model.addAttribute("msg", "没有找到该员工");
							  
							  return"lookRep";
		  }
		  List<Rep>list=attendanceService.queryRepById(emp.getEmpId());
		  model.addAttribute("repList", list);
		return "lookRep";
		  
	  }
	  
	  //查看所有的复议
	  @RequestMapping("/lookAllRev")
	  public String lookAllRev(Model model) {
		  List<Review>list=attendanceService.queryAll();
		  model.addAttribute("revList", list);
		  
		return "lookAllRev";
		  
	  }
	  @RequestMapping("/agree")
	  public String agree(Model model,int empId,String money2) {
		  if(empId==0||money2==null||money2=="") {
			  model.addAttribute("msg", "必填项不能为空");
			  return"agree";
		  }
		  Date date=attendanceService.getNextfirst();
		 int money= Integer.parseInt(money2);
		 Rep rep=new Rep();
		 rep.setConn("复议工资");
		 rep.setEmpId(empId);
		 rep.setMoney(money);
		 rep.setRepTime(date);
		 repDao.addRep(rep);
		 model.addAttribute("msg", "添加奖惩信息成功");
		return "agree";
		  
	  }
	  @RequestMapping("/empmsg")
	  public String empmsg(Model model,HttpSession session) {
		  Employee emp2=(Employee) session.getAttribute("emp");
		  if(emp2==null) {
			  model.addAttribute("msg", "没有找到该员工");
			  return "empmsg";
		  }
		  Employee emp=empService.queryEmpbyid222(emp2.getEmpId());
		  if(emp==null) {
			  model.addAttribute("msg", "没有找到该员工");
			  return "empmsg";
		  }
		  model.addAttribute("emp", emp);
		return "empmsg";
		  
	  }
	  
}
