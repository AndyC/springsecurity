package com.isbing.springsecurity.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by songbing
 * Created time 2019/3/17 上午11:31
 */
public class MyDateUtil extends DateUtils {


    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String STANDARD_DATE_FORMAT = "yyyy-MM-dd";
    public static final String STANDARD_MONTH_FORMAT = "yyyy-MM";
    public static final String STANDARD_FORMAT = "yyyy";
    public static final String CHINESE_DATETIME_FORMAT = "yyyy年MM月dd日 HH:mm:ss";
    public static final String CHINESE_DATETIME_HOUR_FORMAT = "yyyy年MM月dd日HH点mm分";
    public static final String STANDARD_CHINESE_DATE_FORMAT = "yyyy年MM月dd日";

    /**
     * 年月日时分秒(无下划线) yyyyMMddHHmmss
     */
    public static final String DEFAULT_DATETIME_FORMAT_NO_UNDERLINE = "yyyyMMddHHmmss";

    /**
     * 年月日(无下划线) yyyyMMdd
     */
    public static final String STANDARD_DATE_FORMAT_NO_UNDERLINE = "yyyyMMdd";

    public static final Date getDate(String dateStr, String format) throws ParseException {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw e;
        }
    }

    /**
     * 得到当前日期
     *
     * @param format 默认 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static final String getCurrentDate(String format) {
        if (StringUtils.isBlank(format)) {
            format = DEFAULT_DATETIME_FORMAT;
        }
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String cdate = sdf.format(cal.getTime());
        return cdate;
    }

    /**
     * 把毫秒时间转换成指定格式的时间字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static final String getDateStr(Date date, String format) {
        if (null == date) {
            return null;
        }
        if (StringUtils.isBlank(format)) {
            format = DEFAULT_DATETIME_FORMAT;
        }
        SimpleDateFormat fm = new SimpleDateFormat(format);
        return fm.format(date);
    }

    /**
     * 返回短日期，yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static final Date getShortDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 返回当天的中文星期几
     *
     * @return
     */
    public static String currentDayInWeek() {
        return dayInWeek(new Date());
    }

    /**
     * 返回中文星期几
     *
     * @param d 传入的日期
     * @return
     */
    public static String dayInWeek(Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int time = c.get(Calendar.DAY_OF_WEEK);
        String[] weekNames = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        String weekName = weekNames[time - 1];
        return weekName;
    }

    /**
     * 获得两个日期之间相差的天数(返回值去掉了小数部分，即只返回)。（date1 - date2）
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int intervalDays(Date date1, Date date2) {
        long intervalMillSecond = getShortDate(date1).getTime() - getShortDate(date2).getTime();
        return (int) (intervalMillSecond / (24 * 3600 * 1000));
    }

    /*
     * 取本周7天的第一天（周一的日期）
     */
    public static Date getFirstDayOfThisWeek() {
        int mondayPlus;
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        if (dayOfWeek == 0) {
            mondayPlus = -6;
        } else {
            mondayPlus = 1 - dayOfWeek;
        }
        return DateUtils.addDays(getShortDate(new Date()), mondayPlus);
    }

    /*
     * 取下周第一天（周一的日期）
     */
    public static Date getFirstDayOfNextWeek() {
        int mondayPlus;
        Calendar cal = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        if (dayOfWeek == 0) {
            mondayPlus = 1;
        } else {
            mondayPlus = 8 - dayOfWeek;
        }
        return DateUtils.addDays(getShortDate(new Date()), mondayPlus);
    }

    /**
     * 获取日期所在月份的第一天，返回格式：YYYY-MM-DD
     */
    public static Date getMonthFirstDay(Date dateParam) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateParam);
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
        SimpleDateFormat format = new SimpleDateFormat(STANDARD_DATE_FORMAT);
        return calendar.getTime();
    }

    /**
     * 获取日期所在月份的最后天，返回格式：YYYY-MM-DD
     */
    public static Date getMonthLastDay(Date dateParam) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateParam);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        SimpleDateFormat format = new SimpleDateFormat(STANDARD_DATE_FORMAT);
        return calendar.getTime();
    }

    /**
     * 年份加减
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date getReduceDate(Date date, int amount) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.YEAR, amount);//日期减1年
        return rightNow.getTime();
    }


    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = Math.abs((time2 - time1) / (1000 * 3600 * 24));

        return Integer.parseInt(String.valueOf(between_days));
    }

    public static void main(String[] args) throws ParseException {
    }

}

