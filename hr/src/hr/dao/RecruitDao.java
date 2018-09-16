package hr.dao;

import java.util.List;

import hr.bean.Recruit;

public interface RecruitDao {

	/**
	 * 增加招聘信息
	 */
	public void addRecruit(Recruit recruit);
	
	
	/**
	 * 游客查看所有的招聘信息
	 */
	public  List<Recruit> queryAllRecruit();
}
