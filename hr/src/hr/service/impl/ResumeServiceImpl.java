package hr.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import hr.bean.Resume;
import hr.dao.ResumeDao;
import hr.service.ResumeService;
@Service
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeDao resumeDao;
	
	@Override
	public void addResume(Resume resume) {
		// TODO Auto-generated method stub
		resumeDao.addResume(resume);
	}

	@Override
	public Resume queryResume(int uid) {
		// TODO Auto-generated method stub
		return resumeDao.queryResume(uid);
	}

	@Override
	public List<Resume> queryAllResume() {
		// TODO Auto-generated method stub
		return resumeDao.queryAllResume();
	}

	


}
