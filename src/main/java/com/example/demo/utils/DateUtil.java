package com.example.demo.utils;

import com.example.demo.environment.Constants;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATETIME_PATTERN);
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(Constants.DATE_PATTERN,
            Locale.CHINESE);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATETIME_PATTERN,
            Locale.CHINESE);

    public static String formatDate(Date date) {
        if (date == null) {
            return Constants.EMPTY_STRING;
        } else {
            return sdf.format(date);
        }
    }
    
    public static String formatDate(Date date, String dateFormat) {
        if (date == null) {
            return Constants.EMPTY_STRING;
        } else {
        	SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            return sdf.format(date);
        }
    }

    public static String formatDate(LocalDateTime dateTime) {
        return dateTime.format(formatter);
    }

    public static String getBeginDateTimeStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return Constants.EMPTY_STRING;
        }
        try {
            LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
            return dateTime.format(formatter);
        } catch (DateTimeParseException e) {
            try {
                LocalDate date = LocalDate.parse(str, dateFormatter);
                return date.toString().concat(" 00:00:00");
            } catch (DateTimeParseException e1) {
                try {
                    return LocalDateTime.now().format(formatter);
                } catch (DateTimeParseException e2) {
                    return Constants.EMPTY_STRING;
                }
            }
        }
    }

    public static String getBeginDateTimeStr(LocalDate date) {
        return date.format(dateFormatter).concat(" 00:00:00");
    }

    public static String getEndDateTimeStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return Constants.EMPTY_STRING;
        }
        try {
            LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
            return dateTime.format(formatter);
        } catch (DateTimeParseException e) {
            try {
                LocalDate date = LocalDate.parse(str, dateFormatter);
                return date.toString().concat(" 23:59:59");
            } catch (DateTimeParseException e1) {
                try {
                    return LocalDateTime.now().format(formatter);
                } catch (DateTimeParseException e2) {
                    return Constants.EMPTY_STRING;
                }
            }
        }
    }

    public static String getEndDateTimeStr(LocalDate date) {
        return date.format(dateFormatter).concat(" 23:59:59");
    }
    
    public static String formatDate(Long dateTime, String formatStr){
		//format = yyyy-MM-dd HH:mm:ss
		String format = StringUtils.isEmpty(formatStr) ? Constants.DATETIME_PATTERN : formatStr;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(dateTime);
	}
    
    public static String nowTime(){
		return formatDate(System.currentTimeMillis(), Constants.DATETIME_PATTERN);
	}
    
    public static String nowTime(String formatStr){
		return formatDate(System.currentTimeMillis(), formatStr);
	}
    
    public static Date getDateByStrFormat(String dateStr, String formatStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        if (StringUtils.isEmpty(formatStr)){
        	formatStr = Constants.DATETIME_PATTERN;
        }
        try {
        	DateFormat format = new SimpleDateFormat(formatStr);
        	return format.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static String getDateStrByDateFormat(Date date, String formatStr) {
        if (date == null) {
            return null;
        }
        if (StringUtils.isEmpty(formatStr)){
        	formatStr = Constants.DATETIME_PATTERN;
        }
        try {
        	DateFormat format = new SimpleDateFormat(formatStr);
        	return format.format(date);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Date addYear(Date date, Integer years) {
        if(date == null){
            return null;
        }
        if(years == null || years == 0){
        	return date;
        }
        GregorianCalendar gc =new GregorianCalendar();
        gc.setTime(date);
        gc.add(GregorianCalendar.YEAR, years);
        return gc.getTime();
    }
    
    public static Date addMonth(Date date, Integer months) {
        if(date == null){
            return null;
        }
        if(months == null || months == 0){
        	return date;
        }
        GregorianCalendar gc =new GregorianCalendar();
        gc.setTime(date);
        gc.add(GregorianCalendar.MONTH, months);
        return gc.getTime();
    }
    
    public static Date addDay(Date date, Integer days) {
        if(date == null){
            return null;
        }
        if(days == null || days == 0){
        	return date;
        }
        GregorianCalendar gc =new GregorianCalendar();
        gc.setTime(date);
        gc.add(GregorianCalendar.DATE, days);
        return gc.getTime();
    }

    public static long getDistanceDays(String starttime, String endtime){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date one;
        Date two;
        long days=0;
        try {
            one = df.parse(starttime);
            two = df.parse(endtime);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            days = diff / (1000 * 60 * 60);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;//返回相差多少天
    }

    public static void main(String args[]) {
    	Date date = new Date();
    	System.out.println(formatDate(date));
    	date = addYear(date, 1);
    	System.out.println(formatDate(date));
    	date = addYear(date, -5);
    	System.out.println(formatDate(date));
    }
}
