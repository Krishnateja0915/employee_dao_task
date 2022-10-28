package com.medplus.employee.utils;

import java.sql.Date;

public class DateConversion {
	public static Date convertDate(String strDate) {
		Date sqldate = Date.valueOf(strDate);
		return sqldate;
	}
}
