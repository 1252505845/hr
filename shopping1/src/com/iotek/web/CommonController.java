package com.iotek.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.iotek.bean.PairVo;
import com.iotek.service.CommonService;

@Controller
public class CommonController {

	@Autowired
	private CommonService commonService;

	@ResponseBody
	@RequestMapping("/loadCity.action")
	public String loadCity(Integer pid) {
		List<PairVo> list = commonService.loadCity(pid);
		return JSONObject.toJSONString(list);
	}
	
	@ResponseBody
	@RequestMapping("/loadArea.action")
	public String loadArea(Integer cid) {
		List<PairVo> list = commonService.loadArea(cid);
		return JSONObject.toJSONString(list);
	}
}
