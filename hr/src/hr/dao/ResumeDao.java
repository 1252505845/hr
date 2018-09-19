package hr.dao;

import java.util.List;

import hr.bean.Resume;

public interface ResumeDao {
  /**
   * 
   * 增加简历
   * @param resume
   */
	
	public void  addResume(Resume resume);
	/**
	 * 根据游客ID查询简历
	 */
	public Resume queryResume(int uid);
	/**
	 * 根据简历ID查询简历
	 */
	public Resume queryResumeByRid(int rid);
	/**
	 * 管理员查询所有的简历
	 */
	public List<Resume> queryAllResume();
	
	/**
	 * 修改简历
	 */
	public void updateResume(Resume resume);
	
	public void delResume(int uid);

	/**
	 * 查找所有接受面试的简历
	 */
	public List<Resume> queryAccept(String status);
	/**
	 * 查找所有游客已经接受录用的简历
	 */
	public  List<Resume>  queryResumeByAccept(String accept);
	

	
}
