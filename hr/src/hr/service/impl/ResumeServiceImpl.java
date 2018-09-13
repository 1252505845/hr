package hr.service.impl;

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


}
