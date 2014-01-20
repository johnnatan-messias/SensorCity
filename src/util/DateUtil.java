package util;

import java.sql.Date;

public class DateUtil {
	public static java.sql.Date DateToSql(Date date) {
		return new java.sql.Date(date.getTime());
	}

	public static Date getLocalDateSql() {
		// SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/aaaa");
		return new Date(new java.util.Date().getTime());
	}
	
	public static java.util.Date getLocalDate() {
		// SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/aaaa");
		return new java.util.Date();
	}
}
