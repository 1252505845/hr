package hr.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.bean.Dept;
import hr.bean.Employee;
import hr.bean.Train;
import hr.service.DeptService;
import hr.service.SelectJobService;
import hr.service.TrainService;
import hr.util.DateUtils;

@Controller
public class trainManageController {
	  @Autowired
		private DeptService deptService;
	   @Autowired
	   private SelectJobService selectJobService;
	  @Autowired
	   private TrainService  trainService;
	
	@RequestMapping("/trainManage")
	public String trainManage(Model model) {
		List<Dept>list=selectJobService.queryALLDept();
		model.addAttribute("deptList", list);
		List<Train>list2=trainService.queryAllTrain();
		model.addAttribute("trainList", list2);
		return "trainManage";
	}
	@RequestMapping("/addTrain")
	public String addTrain(String trainName,String time,int deptId,Model model) {
		if(trainName==null||trainName==""||time==null||time==""||deptId==0) {
			model.addAttribute("msg", "必填项不能为空");
			return "addTrain";
		}
		if(trainService.queryTrain(trainName,deptId)!=null) {
			model.addAttribute("msg", "该部门已经有这个培训");
			return "addTrain";
		}
		Date time2=DateUtils.getDate(time);
		Train train=new Train();
		train.setDeptId(deptId);
		train.setTrainName(trainName);
		train.setTime(time2);
		trainService.addTrain(train);
		model.addAttribute("msg", "添加培训成功");
		return "addTrain";
		
		
	}
	@RequestMapping("/updateTrain")
	public  String updateTrain(Model model) {
		List<Dept>list=selectJobService.queryALLDept();
		model.addAttribute("deptList", list);
		return "updateTrain";
		
	}
	@RequestMapping("/update")
	public String update(String trainName,String time,int deptId,Model model) {
		if(trainName==null||trainName==""||time==null||time==""||deptId==0) {
			model.addAttribute("msg", "必填项不能为空");
			return "update";
		}
		if(trainService.queryTrain(trainName,deptId)!=null) {
			model.addAttribute("msg", "该部门已经有这个培训");
			return "update";
		}
		Date time2=DateUtils.getDate(time);
		Train train=new Train();
		train.setDeptId(deptId);
		train.setTrainName(trainName);
		train.setTime(time2);
		trainService.update(train);
		model.addAttribute("msg", "培训修改完成");
		return "update";
		
	}
	@RequestMapping("/delTrain")
	public String delTrain(String trainName,int deptId,Model model) {
		if(trainName==null||trainName==""||deptId==0) {
			model.addAttribute("msg", "删除失败");
			return "delTrain";
		}
		//System.out.println(trainName);
		//System.out.println(deptId);
		
	 Train train=trainService.queryTrain(trainName, deptId);
	
	 if(train==null) {
		 model.addAttribute("msg", "没有找到此培训");
			return "delTrain";
	 }
	 //System.out.println(train);
	
	 trainService.delTrain(train.getTrainId());
	 model.addAttribute("msg", "培训删除成功");
		return "delTrain";
	}
	/**
	 * 员工查看自己的培训信息
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/lookTrain")
	public String lookTrain(HttpSession session,Model model) {
		Employee emp=(Employee) session.getAttribute("emp");
		if(emp==null) {
			model.addAttribute("msg", "找不到该员工");
			return "lookTrain";
		}
		List<Train>list=trainService.queryByDeptId(emp.getDeptId());
		if(list.size()==0) {
			model.addAttribute("msg", "没有安排培训");
			return "lookTrain";
		}
		model.addAttribute("trainList", list);
		return "lookTrain";
		
	}
	
}
