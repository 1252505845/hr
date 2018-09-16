package hr.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConvert implements Converter<String, Date> {

	@Override
	public Date convert(String arg0) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = null;
		try {
			dd = df.parse(arg0);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dd;
	}

}
