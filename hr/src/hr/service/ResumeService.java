package hr.service;




import java.util.List;

import hr.bean.Resume;


public interface ResumeService {
	/**
	 * 增加简历
	 * @param resume
	 */
	public void  addResume(Resume resume);
	
	public Resume queryResume(int uid);
	
	public List<Resume> queryAllResume();
	

	
}