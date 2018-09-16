package hr.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import hr.bean.Admin;
import hr.bean.Dept;
import hr.bean.Position;
import hr.bean.Recruit;
import hr.service.RecruitService;
import hr.service.SelectJobService;
import hr.util.DateUtils;

@Controller
public class RecruitController {
    @Autowired
	private RecruitService recruitService;
	@Autowired
    private SelectJobService selectJobService;
	
	@RequestMapping("/toAdmin")
	public String toAdmin() {
		return "admin";
		
	}
	
	@RequestMapping("/toAdminrec")
	public String adminrec() {
		return "adminrec";
	}
	@RequestMapping("/showRec")
	public String showRec() {
		return "showRec";
	}
	
	
	@RequestMapping("/toAddRec")
	public String toAddRec(Model model) {
		List<Dept>list=selectJobService.queryALLDept();
		model.addAttribute("deptList", list);
		return"addRec";
	}
	@ResponseBody
	@RequestMapping("/queryPosition")
	public String queryPos(int deptId) {
		List<Position> list=selectJobService.queryPositionbyId(deptId);
		return JSONObject.toJSONString(list);
		
	}
	
	
	/**
	 * 游客查看招聘信息
	 */
	@RequestMapping("/tolookRec")
	public String lookRecruit(Model model) {
		List<Recruit> list=recruitService.queryAllRecruit();
		model.addAttribute("recruitList", list);
		return "lookRec";
		
	}
	
	/**
	 * 增加招聘信息
	 * @param recruit
	 * @return
	 */
	@RequestMapping("/addRec")
	public String addRec(Recruit recruit,HttpSession session,Model model) {
		
		if(recruit.getCompany()==null||recruit.getCompany()==""||recruit.getDeptId()==0||recruit.getPid()==0
				||recruit.getAddr()==null||recruit.getAddr()==""||recruit.getPay()==null||recruit.getPay()==""
				||recruit.getEducation()==null||recruit.getEducation()==""||recruit.getWorkExperience()==null||
				recruit.getWorkExperience()==""||recruit.getContent()==null||recruit.getContent()=="") {
			 model.addAttribute("msg", "招聘信息不能为空");
			return "addRec";
		}
		Admin admin=(Admin) session.getAttribute("admin");
		recruit.setAdminId(admin.getAdminId());
		recruit.setCreateTime(DateUtils.getToday());
		recruitService.addRecruit(recruit);
		session.setAttribute("recruit", recruit);
		return "showRec";
		
	}
	
}
