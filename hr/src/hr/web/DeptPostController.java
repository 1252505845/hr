package hr.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import hr.bean.Dept;
import hr.bean.Employee;
import hr.bean.Position;
import hr.service.DeptService;
import hr.service.EmpService;
import hr.service.PositionService;
import hr.service.SelectJobService;
import hr.util.DateUtils;

@Controller
public class DeptPostController {
   @Autowired
	private DeptService deptService;
   @Autowired
   private SelectJobService selectJobService;
   @Autowired
   private PositionService positionService;
   @Autowired
   private EmpService empService;
	
   @RequestMapping("/deptPost")
	public String deptPost(Model model) {
		List<Dept>list=selectJobService.queryALLDept();
		model.addAttribute("deptList", list);
		return "addeptPost";
		
	}
	
	@ResponseBody
	@RequestMapping("/addDept")
	public String addDept(String deptName) {
		if(deptName==null||deptName=="") {
			return "部门名不能为空";
		}
		if(deptService.queryByName(deptName)!=null) {
			return"该部门已存在";
		}
		
		Dept dept=new Dept();
		Date createTime=DateUtils.getToday();
		
			dept.setCreateTime(createTime);
			dept.setDeptName(deptName);
		
				deptService.addDept(dept);
				return "部门添加成功";
		
		
	}
	@ResponseBody
	@RequestMapping("/queryDept")
	public String queryDept() {
		List<Dept>list=selectJobService.queryALLDept();
		 return JSONObject.toJSONString(list);
		
	}
	@ResponseBody
	@RequestMapping("/addPosition")
	public String addPosition(Integer deptId,String posName) {
		if(deptId==0||deptId==null||posName==null||posName=="") {
			return"必填项不能为空";
		}
		if(!positionService.queryPosbyName(deptId, posName)) {
			return  "本部门下该岗位已存在";
		}
		Position position =new Position();
		Date createTime=DateUtils.getToday();
		
		position.setCreateTime(createTime);
		position.setDeptId(deptId);
		position.setPosName(posName);
		positionService.addPos(position);
		return "该岗位添加成功";
		
	}
	@ResponseBody
	@RequestMapping("/delDept")
	public String delDept(String deptName) {
		if(deptName==null||deptName=="") {
			return"必填项不能为空";
		}
		Dept dept=deptService.queryByName(deptName);
		if(dept==null) {
			return "要删除的部门不存在";
		}
		
		if(empService.queryempInDept(dept.getDeptId())) {//说明此时部门表里没有员工
			//先删除职位表
			int deptId=dept.getDeptId();
			positionService.delPosInDept(deptId);
           deptService.delDept(deptId);
			return"删除部门成功";
		}
		return "该岗位还有员工，不能删除";
		
	}
	@RequestMapping("/watchDept")
	public String watchDept(int deptId,Model model) {
		if(deptId==0) {
			model.addAttribute("msg", "请选择部门");
			return "watchDept";
		}
		Dept dept=deptService.queryDeptById(deptId);
		model.addAttribute("dept", dept);
		return "watchDept";
		
	}
	@RequestMapping("/watchPosEmp")
	public String watchPosEmp(int deptId,Model model) {
		if(deptId==0) {
			model.addAttribute("msg", "请选择部门");
			return "watchPosEmp";
		}
		List<Position>list=positionService.queryPositionbyId(deptId);
		List<Employee>list2=empService.queryempInDept2(deptId);
		if(list.size()==0) {
			model.addAttribute("msg", "该部门没有岗位，也没用员工");
			return "watchPosEmp";
		}
		if(list.size()>0&&list2.size()==0) {
			model.addAttribute("posList", list);
			model.addAttribute("msg", "该部门有岗位，但是没有员工");
		}
		if(list.size()>0&&list2.size()>0) {
			model.addAttribute("posList", list);
			model.addAttribute("empList", list2);
			return "watchPosEmp";
		}
		return null;
		
		
	}
	
	@ResponseBody
	@RequestMapping("/quePosition")
	public String queryPos(int deptId) {
		List<Position> list=selectJobService.queryPositionbyId(deptId);
		return JSONObject.toJSONString(list);
		
	}
	@RequestMapping("/lookpos")
	public String  lookpos(int deptId,int pid,Model model) {
		if(deptId==0||pid==0) {
			model.addAttribute("msg", "没有选择职位或部门");
			return "lookpos";
		}
		Dept dept=deptService.queryDeptById(deptId);
		Position position=positionService.querybypid(pid);
		List<Employee> list=empService.queryByDeptIdPid(deptId, pid);
		//需要连表查询
		
		return null;
		
		
	}
	
	
	@ResponseBody
	@RequestMapping("/quePos")
	public String quePos(int deptId) {
		List<Position> list=selectJobService.queryPositionbyId(deptId);
		return JSONObject.toJSONString(list);
		
	}
	
	@RequestMapping("/delpos")
	public String delpos(int deptId,int pid,Model model) {
		if(deptId==0||pid==0) {
			model.addAttribute("msg", "没有选择职位或部门");
			return "delpos";
		}
		List<Employee>list=empService.querybypid(pid);
		if(list.size()==0) {
			positionService.delbypid(pid);
			model.addAttribute("msg", "已经删除该职位");
			return "delpos";
		}
		model.addAttribute("msg", "不能删除该职位，此职位下面还有员工");
		return "delpos";	
		
	}
	
	
	
	
	
	
	
}
