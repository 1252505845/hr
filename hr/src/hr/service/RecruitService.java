package hr.service;

import java.util.List;

import hr.bean.Recruit;

public interface RecruitService {
/**
 * 增加招聘信息
 * @param recruit
 */
	public void addRecruit(Recruit recruit);
	
	public  List<Recruit> queryAllRecruit();
}
