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
     

     @RequestMapping("/queryRes")
     public String queryRes(Model model,HttpSession session) {

    	User user= (User) session.getAttribute("user");//
    	//从后台查询游客的信息
    	
    	List<Dept>deptList=selectJobService.queryALLDept();
    	model.addAttribute("deptList", deptList);
    	
    		Resume resume=resumeService.queryResume(user.getUid());
        	if(resume!=null) {
            	session.setAttribute("resume", resume);
                //如果没有
            	return "lookmain";
        	}
        	return "main";
    
     }
     @RequestMapping("/main")
     public String main() {
    	 return "main";
    	 
     }
     
     @ResponseBody
	@RequestMapping("/queryPosition")
	public String queryPos(int deptId) {
		List<Position> list=selectJobService.queryPositionbyId(deptId);
	  for (Position p : list) {
		System.out.println(p.getDeptId()+","+p.getPid()+","+p.getpName());
	}
		System.out.println(JSONObject.toJSONString(list));
		return JSONObject.toJSONString(list);
		
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
    	 if(resume.getName()==null||resume.getSex()==null||resume.getAge()==null||
    resume.getNational()==null||resume.getSchool()==null||resume.getEducation()==null
    ||resume.getMajor()==null||resume.getNativePlace()==null||resume.getPhone()==null
    ||resume.getMail()==null||resume.getDeptId()==0||resume.getPid()==0
    ||resume.getPoliticsStatus()==null||resume.getLastWork()==null||
    resume.getWorkExperience()==null) {
    		 model.addAttribute("msg", "请输入必填项");
    		 return"main";
    	 }
    	 User user= (User) session.getAttribute("user");
    	 resume.setUid(user.getUid());
		 resumeService.addResume(resume);
		 //转到有用户信息的表
		 return"lookmain";
     }
	
}
