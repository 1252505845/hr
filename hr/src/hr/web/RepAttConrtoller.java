package hr.web;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.bean.Attendance;
import hr.bean.Employee;
import hr.bean.Payroll;
import hr.bean.Rep;
import hr.bean.Review;
import hr.dao.EmpDao;
import hr.service.AttendanceService;
import hr.service.PayrollService;
import hr.util.DateUtils;

@Controller
public class RepAttConrtoller {
   @Autowired
	private AttendanceService attendanceService;
	@Autowired
   private EmpDao empDao;
   @Autowired
	private PayrollService payrollService;
   @RequestMapping("/adlookRep")
	public String adlookRep(Model model) {
		
		List<Rep>list=attendanceService.queryAllRep();
		model.addAttribute("repList", list);
		return  "adlookRep";		
	}
   
   @RequestMapping("/adlookAtt")
   public String adlookAtt(Model model) {
	   
	   List<Attendance>list=attendanceService.queryAllAtt();
	   model.addAttribute("attList", list);
	  return "adlookAtt";
	   
   }
   
   
   /**
    * 
    * 
    */
   
   @RequestMapping("/adlookPay")
   public String adlookPay(Model model) {
	   List<Employee>list=empDao.queryAllEmp();
	   model.addAttribute("empList", list);
	return "adlookPay";
	   
   }
   
   @RequestMapping("/addPay")
     public String addPay(String userdate,int empId,Model model) {
	   if(userdate==null||userdate==""||empId==0) {
		   model.addAttribute("msg", "请输入必填项");
		   return "addPay";
	   }
	   
	   
	   //2018-09
	   //System.out.println(userdate);
	   String s=userdate+"-01";//2018-09-01
	  // System.out.println(s);
	   Long l1=DateUtils.getDate2(s).getTime();
	
	   String s2=attendanceService.getfirstDay();
	   Long l2=DateUtils.getDate2(s2).getTime();
         if((l2-l1)/86400000<31) {
		  // System.out.println("p");
        	 model.addAttribute("msg", "请于本月20号结算工资");
		   return"addPay";
	   }
	   Employee emp=empDao.queryEmpbyid(empId);
	   if(emp==null) {
		   model.addAttribute("msg", "没找到该用户");
		   return"addPay";
	   }
	       //把选中年月的第一天存进去   2018-09-01
	 		Date time=DateUtils.getDate2(s);
	 		Payroll payroll2=payrollService.queryPayroll(empId, time);
	 		if(payroll2!=null) {
	 			model.addAttribute("msg", "该员工此月的工资已经发放了");
	 		   return"addPay";
	 		}
	   double salary=emp.getSalary();
	  // overtime   加班工资
	   
	   int count=attendanceService.queryWorkCount(1, userdate, empId);
	  // System.out.println(count);
	   double overtime=count*100;
		
	   
	   // rep;   奖惩工资
	  // 1迟到扣钱
	  int count2=attendanceService.queryStatusCount(2, userdate, empId);
	   double m1=count2*20;//迟到要扣的钱
	   // 2早退扣钱
	   int count3=attendanceService.queryStatus222Count(2, userdate, empId);
	   double m2=count3*50;
	   //3 旷工扣钱
	   int count4=attendanceService.queryStatusCount(3, userdate, empId)+
			   attendanceService.queryStatus222Count(3, userdate, empId);
		//一天的工资
	   double m22=emp.getSalary()/166*8;
	   BigDecimal   b1  =   new   BigDecimal(m22);  
	   double   money   =   b1.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		double m3=money*count4;
		//算有工资的天数
		/*status 上班考勤状态 ，正常上班1，迟到2， 迟到超过三小时旷工3

		status222   下班考勤状态   正常下班1 早退2   早退超过三小时旷工3 

		1  1
		1  2
		2   1
		2    2*/
		int c1=attendanceService.queryStatus333Count(1, 1, userdate, empId);
		int c2=attendanceService.queryStatus333Count(1, 2, userdate, empId);
		int c3=attendanceService.queryStatus333Count(2, 1, userdate, empId);
		int c4=attendanceService.queryStatus333Count(2, 2, userdate, empId);
		
		double m=money*(c1+c2+c3+c4);
		//没有打卡的 要扣的钱
		double c=emp.getSalary()-m;
		//复议的工资
		/*Rep rep=attendanceService.query(empId, "复议工资");
		if(rep!=null) {
			double repmoney=rep.getMoney();
		}*/
		   //performance;  绩效奖金
		
		   double f=emp.getSalary()*0.15/21*(c1+c2+c2+c3);
		   BigDecimal   b   =   new   BigDecimal(f);  
		   double   performance   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
		//底薪   emp.getSalary()
		
	   //social;  社保  要交15%
		double social=(emp.getSalary()+overtime-m1-m2-m3)*0.15;
		double realitysal=(emp.getSalary()+performance+overtime-m1-m2-m3-c)*0.85;
	   //realitySal;  //实际工资，到手的工资
		Payroll payroll=new Payroll();
		payroll.setEmpId(empId);
		payroll.setOvertime(overtime);
		payroll.setRealitysal(realitysal);
		payroll.setSalary(emp.getSalary());
		payroll.setSocial(social);
		payroll.setRep(m1+m2+m3+c);
		payroll.setPerformance(performance);
		
		payroll.setTime(time);
		//System.out.println(time);
	   payrollService.addPayRoll(payroll);
		model.addAttribute("msg", "工资结算成功");
		return "addPay";
    	 
     }
   
   @RequestMapping("/adlookAllPay")
   public String adlookAllPay(Model model) {
	   List<Payroll>list=payrollService.queryAll();
	   model.addAttribute("payList", list);
	   return "adlookAllPay";
	   
   }
	@RequestMapping("/review")
   public String review(String conn,String money2,HttpSession session,Model model) {
		
		if(conn==null||conn==""||money2==null||money2=="") {
			model.addAttribute("msg", "必填项不能为空");
		    return "review";
		}
		Employee emp=(Employee) session.getAttribute("emp");
		if(emp==null) {
			model.addAttribute("msg", "没有找到该员工");
		    return "review";
		}
		Date date=DateUtils.getToday3();
		Review review2=attendanceService.query(emp.getEmpId(), date);
		if(review2!=null) {
			model.addAttribute("msg", "已经复议了");
		    return "review";
		}
		int money=Integer.parseInt(money2);
		Review review=new Review();
		review.setConn(conn);
		review.setDate(date);
		review.setEmpId(emp.getEmpId());
		review.setMoney(money);
		attendanceService.addRev(review);
		model.addAttribute("msg", "申请成功");
	    return "review";
	   
   }
   
}
