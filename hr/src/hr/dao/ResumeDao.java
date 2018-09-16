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
	 * 管理员查询所有的简历
	 */
	public List<Resume> queryAllResume();
	
	/**
	 * 修改简历
	 */
	public void updateResume(Resume resume);
}
