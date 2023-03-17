package com.eduit.bootcamp.springbootapi.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

	public static Date toDate(final LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public static LocalDate toLocalDate(final Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
