package hr.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hr.bean.Resume;
import hr.bean.User;
import hr.service.ResumeService;
import hr.service.SelectJobService;
import hr.service.UserService;
import hr.util.DateUtils;

@Controller
public class ResumeController {
     @Autowired
	private ResumeService resumeService;
     @Autowired
     private SelectJobService selectJobService;
     @Autowired
     private UserService userService;
     
     @RequestMapping("/main")
     public String main() {
    	 return "main";
    	 
     }
     

     @RequestMapping("/queryRes")
     public String queryRes(Model model,HttpSession session) {

    	User user= (User) session.getAttribute("user");//
    	//从后台查询游客的信息
    	if(user!=null) {
    		Resume resume=resumeService.queryResume(user.getUid());
        	if(resume!=null) {
            	session.setAttribute("resume", resume);
                
            	return "lookmain";
        	}
        	return "main";
    	}
		return "";
    		
    
     }
    
    
     /**
      * 添加简历
      * @param model
      * @param resume
      * @param session
      * @return
      */
     @RequestMapping("/addResume")
     public String addResume(Model model,Resume resume,HttpSession session) {
    	
    
    	 if(resume.getName()==null||resume.getName()==""||resume.getSex()==null||resume.getSex()==""
    ||resume.getAge()==null||resume.getAge()==""||resume.getNational()==null||resume.getNational()==""||resume.getSchool()==null||resume.getSchool()==""
    ||resume.getEducation()==null||resume.getEducation()==""||resume.getMajor()==null||resume.getMajor()==""||resume.getNativePlace()==null||resume.getNativePlace()==""
    ||resume.getPhone()==null||resume.getPhone()==""||resume.getMail()==null||resume.getMail()==""||resume.getJob()==null||resume.getJob()==""
    ||resume.getPoliticsStatus()==null||resume.getPoliticsStatus()==""
    || resume.getWorkExperience()==null||resume.getWorkExperience()=="")
    	 {
    		 model.addAttribute("msg", "请输入必填项");
    		 return"main";
    	 }
    	 String reg="^1[3|5|7|8]\\d{9}$";
 		if(!resume.getPhone().matches(reg)) {
 	     model.addAttribute("msg","输入的手机号不合法");
 	     return "main";
 		}
 		
 		
    	 User user= (User) session.getAttribute("user");
    	 resume.setUid(user.getUid());
		 resumeService.addResume(resume);
		 //转到有用户信息的页面
		 return"lookmain";
     }
     
     @RequestMapping("/updateResume")
     public String updateResume(Model model,Resume resume,HttpSession session) {
         
        
    	
    	 if(resume.getName()==null||resume.getName()==""||resume.getSex()==null||resume.getSex()==""
    ||resume.getAge()==null||resume.getAge()==""||resume.getNational()==null||resume.getNational()==""||resume.getSchool()==null||resume.getSchool()==""
    ||resume.getEducation()==null||resume.getEducation()==""||resume.getMajor()==null||resume.getMajor()==""||resume.getNativePlace()==null||resume.getNativePlace()==""
    ||resume.getPhone()==null||resume.getPhone()==""||resume.getMail()==null||resume.getMail()==""||resume.getJob()==null||resume.getJob()==""
    ||resume.getPoliticsStatus()==null||resume.getPoliticsStatus()==""
    || resume.getWorkExperience()==null||resume.getWorkExperience()==""||resume.getSalaryExpectation()==null||resume.getSalaryExpectation()=="")
    	 {
    		 model.addAttribute("msg", "必填项不能为空");
    		 return"lookmain";
    	 }
    	 String reg="^1[3|5|7|8]\\d{9}$";
 		if(!resume.getPhone().matches(reg)) {
 	     model.addAttribute("msg","输入的手机号不合法");
 	     return "lookmain";
 		}
 		User user= (User) session.getAttribute("user");//
 		if(user!=null) {
 			resume.setUid(user.getUid());
 			resumeService.updateResume(resume);
 	    	  model.addAttribute("msg","简历修改成功");
 			return "lookmain";
 		}
		return "";
    	 
		//redirect:
     }
     @RequestMapping("/del")
     public String del(HttpSession session) {
    	 User user= (User) session.getAttribute("user");//
    	 if(user!=null) {
    		 resumeService.delResume(user.getUid());
    		 return"main";
    	 }
    	 return "";
     }
     
     
     @RequestMapping("/apply")
     public   String apply(HttpSession session,Model model) {
    	User user= (User) session.getAttribute("user");
    	 Resume resume=resumeService.queryResume(user.getUid());
    	 if(resume==null) {
    		 //没有简历的用户申请职位跳转到添加简历界面
    		 return"main";
    	 }
    	 model.addAttribute("msg","你已经投递过简历了");
		return "lookRec";
    	 
     }
     
     @RequestMapping("/adLookRes")
     public String adLookRes(Model model) {
    	 
    List<Resume>list= resumeService.queryAllResume();
     model.addAttribute("resumeList", list);
       
    	 return "adLookRes";
     }
     
     @RequestMapping("/adseeRes")
	public String adseeRes(int rid,Model model) {
    	
    	 if(rid!=0) {
    		 Resume resume=resumeService.queryResumeByRid(rid);
    		 //点击查看按钮 进入游客简历界面，此时游客的简历应该变为已查看状态
    		
        	 model.addAttribute("resume", resume);
        	 resume.setSign("已查看");
        	 resumeService.updateResume(resume);
    		return "adseeRes";
    	 }
    	 return"";
		
	}
     @ResponseBody
     @RequestMapping("/addtime")
     public String addtime(String date,int rid) {
    	
    	 if(date==null||date==""||rid==0) {
    		
    		 return "输入时间有误或没找到该简历";
    	 }
    	 //修改简历表 date status
            Date date2=DateUtils.getDate(date);
           Resume resume= resumeService.queryResumeByRid(rid);
           resume.setDate(date2);
           resume.setStatus("已通知面试");
           resumeService.updateResume(resume);
    	 return"已通知面试";
     }
     
     @RequestMapping("/lookint")
     public String lookint(HttpSession session,Model model) {
    	 User user=(User) session.getAttribute("user");
    	 if(user!=null) {
    		 Resume resume=resumeService.queryResume(user.getUid());
    		 model.addAttribute("resume", resume);
    		 return"lookint";
    	 }
    	 
    	 return"";
     }
     @ResponseBody
     @RequestMapping("/accpet")
     public String accpet(Integer uid) {
    	 
    	 if(uid==null) {
    		 return"找不到该用户";
    	 }
    	 Resume resume=resumeService.queryResume(uid);
    	 resume.setStatus("接受面试");
    	 resumeService.updateResume(resume);
		return "已接收面试";	 
     }
     @ResponseBody
     @RequestMapping("/reject")
     public String reject(Integer uid) {
    	 
    	 if(uid==null) {
    		 return"找不到该用户";
    	 }
    	 Resume resume=resumeService.queryResume(uid);
    	 resume.setStatus("拒绝面试");
    	 resumeService.updateResume(resume);
		return "已拒绝面试";	 
     }
     /**
      * 管理员处理面试进行录用
      * @return
      */
     @RequestMapping("/adinterv")
     public String adinterv(Model model) {
    	 List<Resume>list=resumeService.queryAccept("接受面试");
    
    	 model.addAttribute("resumeList", list);
    	 
    	 return"adinterv";
     }
     /**
      * 管理员开始面试
      */
     @RequestMapping("/adinter")
     public String adinter(int rid,Model model) {
    	 if(rid!=0) {
    		 Resume resume=resumeService.queryResumeByRid(rid);
    		 
    		 model.addAttribute("resume", resume);
        	 return"inter";
    	 }
    	 return"";
    	
     }
     @ResponseBody
     @RequestMapping("/hire")
     public String hire(Integer uid ) {
    	 if(uid==null) {
    		 return"找不到该用户";
    	 }
    	 Resume resume=resumeService.queryResume(uid);
    	 resume.setStatus("已面试");
    	 resume.setOffer("面试成功");
    	 resumeService.updateResume(resume);
		return "面试成功";	
    
     }
     @ResponseBody
     @RequestMapping("/nohire")
     public String nohire(Integer uid ) {
    	 if(uid==null) {
    		 return"找不到该用户";
    	 }
    	 Resume resume=resumeService.queryResume(uid);
    	 resume.setStatus("已面试");
    	 resume.setOffer("面试失败");
    	 resumeService.updateResume(resume);
		return "面试失败";	
    
     }
     /**
      * 游客接受录用
      * @param uid
      * @return
      */
     @ResponseBody
     @RequestMapping("/accpet2")
     public String accpet2(Integer uid) {
    	 if(uid==null) {
    		 return"找不到该用户";
    	 }
    	 Resume resume=resumeService.queryResume(uid);
    	 resume.setAccept("接受录用");
    	 resumeService.updateResume(resume);
		return "已接收录用";	 
     }
     @ResponseBody
     @RequestMapping("/reject2")
     public String reject2(Integer uid) {
    	 if(uid==null) {
    		 return"找不到该用户";
    	 }
    	 Resume resume=resumeService.queryResume(uid);
    	 resume.setAccept("拒绝录用");
    	 resumeService.updateResume(resume);
		return "已拒绝录用";	 
     }
     
}
