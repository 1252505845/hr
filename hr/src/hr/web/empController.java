package hr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hr.bean.Dept;
import hr.bean.Employee;
import hr.bean.Position;
import hr.bean.Resume;
import hr.bean.User;
import hr.service.DeptService;
import hr.service.EmpService;
import hr.service.PositionService;
import hr.service.ResumeService;
import hr.service.SelectJobService;
import hr.service.UserService;

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
		  if(("已离职").equals(emp.getStatus())) {
			  empService.delEmpbyphone(phone);
			  return"删除成功";
		  }
		return "该员工处于在职状态,不能删除";
		  
	  }
}
