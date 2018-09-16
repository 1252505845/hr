package hr.util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static Date getToday() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		 String dt=df.format(new Date());
		 try {
			return  df.parse(dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
