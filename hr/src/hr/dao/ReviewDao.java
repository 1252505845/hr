package hr.dao;

import java.util.Date;
import java.util.List;

import hr.bean.Review;

public interface ReviewDao {

	
	public Review query(int empId,Date date);
	
	public void addRev(Review review);
	
	public List<Review> queryAll();
	
}
