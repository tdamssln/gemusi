package org.gemusi.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	public static String firstDayStr(Date date){
		if(date == null){
			return null;
		}
		return date.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate()
				.with(TemporalAdjusters.firstDayOfMonth())
				.toString();
	}

	public static String lastDayStr(Date date){
		if(date == null){
			return null;
		}
		return date.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate()
				.with(TemporalAdjusters.lastDayOfMonth())
				.toString();
	}

	public static String currentYearFirstDayStr(Date date){
		if(date == null){
			return null;
		}
		return date.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate()
				.with(TemporalAdjusters.firstDayOfYear())
				.toString();
	}

	public static int getYear(Date date){
		if(date == null){
			return 0;
		}
		return date.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate()
				.getYear();
	}

	public static int getMonth(Date date){
		if(date == null){
			return 0;
		}
		return date.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate()
				.getMonth()
				.getValue();
	}


	public static String monthFormat(String dateSrt,int month)  {
		Date dt = null;
		try {
			dt =  new SimpleDateFormat("yyyy-MM-dd").parse(dateSrt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return monthFormat(dt,month);
	}

	public static String monthFormat(Date date,int month)  {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		Date dt1 = calendar.getTime();
		String reStr =  new SimpleDateFormat("yyyy-MM-dd").format(dt1);
		return reStr;
	}

	public static String dayFormat(String dateSrt,int day)  {
		Date dt = null;
		try {
			dt =  new SimpleDateFormat("yyyy-MM-dd").parse(dateSrt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dayFormat(dt,day);
	}

	public static String dayFormat(Date date,int day)  {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		Date dt1 = calendar.getTime();
		String reStr =  new SimpleDateFormat("yyyy-MM-dd").format(dt1);
		return reStr;
	}

    public static String dateFormat(Date date,String expression)  {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Date dt1 = calendar.getTime();
        String reStr =  new SimpleDateFormat(expression).format(dt1);
        return reStr;
    }

    public static String dateFormat(String dateSrt,String expression)  {
        Date dt = null;
        try {
            dt =  new SimpleDateFormat(expression).parse(dateSrt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat(dt,expression);
    }

	public static Date previousYearMonth(Date date){
		if(date==null){
			return null;
		}

		return Date.from(date.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate()
				.minusYears(1)
				.atStartOfDay(ZoneId.systemDefault())
				.toInstant());
	}

    public static String getPreYearCurrentDay(Date date){
		if(date == null){
			return null;
		}
		return date.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate()
				.minusYears(1)
				.toString();
	}


}
