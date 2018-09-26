package hr.util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static Date getToday3() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 String dt=df.format(new Date());
		 try {
			return  df.parse(dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	public static Date getToday() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String dt=df.format(new Date());
		 try {
			return  df.parse(dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date getToday2(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String dt=df.format( date);
		 try {
			return  df.parse(dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static Date getToday4(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 String dt=df.format(date);
		 try {
			return  df.parse(dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String today() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String dt=df.format(new Date());
		 return dt;
	}
	public static String today2(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 String dt=df.format(date);
		return dt;
		
	}
	
	
	public  static Date getDate(String date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			//return df.parse(date.toString());
			return  (Date)df.parseObject(date);
			//Date start = (Date)sdf.parseObject(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public  static Date getDate2(String date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//return df.parse(date.toString());
			return  (Date)df.parseObject(date);
			//Date start = (Date)sdf.parseObject(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public  static Date getDate3(String date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM");
		try {
			//return df.parse(date.toString());
			return  (Date)df.parseObject(date);
			//Date start = (Date)sdf.parseObject(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
