package hr.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import hr.bean.Dept;
import hr.bean.Position;
import hr.bean.Resume;
import hr.bean.User;
import hr.service.ResumeService;
import hr.service.SelectJobService;
import hr.service.UserService;

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
    	
    		Resume resume=resumeService.queryResume(user.getUid());
        	if(resume!=null) {
            	session.setAttribute("resume", resume);
                
            	return "lookmain";
        	}
        	return "main";
    
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
     public String updateResume(Model model,Resume resume) {

    	 if(resume.getName()==null||resume.getName()==""||resume.getSex()==null||resume.getSex()==""
    ||resume.getAge()==null||resume.getAge()==""||resume.getNational()==null||resume.getNational()==""||resume.getSchool()==null||resume.getSchool()==""
    ||resume.getEducation()==null||resume.getEducation()==""||resume.getMajor()==null||resume.getMajor()==""||resume.getNativePlace()==null||resume.getNativePlace()==""
    ||resume.getPhone()==null||resume.getPhone()==""||resume.getMail()==null||resume.getMail()==""||resume.getJob()==null||resume.getJob()==""
    ||resume.getPoliticsStatus()==null||resume.getPoliticsStatus()==""
    || resume.getWorkExperience()==null||resume.getWorkExperience()=="")
    	 {
    		 model.addAttribute("msg", "必填项不能为空");
    		 return"lookmain";
    	 }
    	 String reg="^1[3|5|7|8]\\d{9}$";
 		if(!resume.getPhone().matches(reg)) {
 	     model.addAttribute("msg","输入的手机号不合法");
 	     return "lookmain";
 		}
    	 resumeService.updateResume(resume);
		return "lookmain";
    	 
    	 
     }
     
     
	
}
