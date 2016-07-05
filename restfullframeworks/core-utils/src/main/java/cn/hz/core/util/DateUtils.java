package cn.hz.core.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author wangxf
 * @date 2016年4月7日
 *
 */
public final class DateUtils {

	public static final String PATTERN_DATESHORT = "yyyyMMdd";

	public static final String PATTERN_DATE = "yyyy-MM-dd";

	public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";

	public static final String PATTERN_DATEMINUTES = "yyyy-MM-dd HH:mm";

	public static final String PATTERN_DATEHOURS = "yyyy-MM-dd HH";

	public static final String PATTERN_HMS = "HH:mm:ss";

	public static int getCurrentUnixTimestamp() {
		return (int) (System.currentTimeMillis() / 1000);
	}

	public static String getLastDate(int year, int month) {
		int[] monthDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			monthDay[1] = 29;
		}
		int monthDayNum = monthDay[month - 1];
		String end = year + "-" + month + "-" + monthDayNum;
		return end;
	}

	public static String getToday(String format) {
		String tab = "";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		tab = sdf.format(calendar.getTime());
		return tab;
	}

	public static String getYesterday(String format) {
		String tab = "";
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		tab = sdf.format(calendar.getTime());
		return tab;
	}

	/* 格式化日期为短形式 */
	public static String getShortDate(Date myDate) {
		// SimpleDateFormat fd = new
		// SimpleDateFormat(patternDateShort,Locale.CHINA);
		SimpleDateFormat fd = new SimpleDateFormat(PATTERN_DATESHORT);
		return (fd.format(myDate));
	}

	/* 格式化日期为标准形式 */
	public static String formatDateTime(Date myDate, String pattern) {
		myDate = isDate(myDate);
		// SimpleDateFormat fd = new SimpleDateFormat(pattern, Locale.CHINA);
		SimpleDateFormat fd = new SimpleDateFormat(pattern);
		return (fd.format(myDate));
	}

	/* 格式化日期为标准形式 */
	public static String formatDateTime(Date myDate, String pattern, Locale localcode) {
		myDate = isDate(myDate);
		SimpleDateFormat fd = new SimpleDateFormat(pattern, localcode);
		return (fd.format(myDate));
	}

	/* 判断myDate是否为null */
	public static Date isDate(Date myDate) {
		if (myDate == null)
			return new Date();
		return myDate;
	}

	// 日期差
	public static long getQuot(Date time1, Date time2) {
		long quot = 0;

		try {
			Date date1 = time1;
			Date date2 = time2;
			quot = date1.getTime() - date2.getTime();
			quot = quot / 1000 / 60 / 60 / 24;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quot;
	}

	// 判断日期为星期几,1为星期日com.vnvtrip.util,依此类推
	public static int dayOfWeek(Object date1) {
		Date date = (Date) date1;
		// 首先定义一个calendar，必须使用getInstance()进行实例化
		Calendar aCalendar = Calendar.getInstance();
		// 里面野可以直接插入date类型
		aCalendar.setTime(date);
		// 计算此日期是一周中的哪一天
		int x = aCalendar.get(Calendar.DAY_OF_WEEK);
		return x;
	}

	public static String dayOfWeek2(Object date1) {
		Date date = (Date) date1;
		// 首先定义一个calendar，必须使用getInstance()进行实例化
		Calendar aCalendar = Calendar.getInstance();
		// 里面野可以直接插入date类型
		aCalendar.setTime(date);
		// 计算此日期是一周中的哪一天
		int x = aCalendar.get(Calendar.DAY_OF_WEEK);
		return dayOfWeekByDayNum(x);
	}

	public static String dayOfWeekByDayNum(int x) {
		String str = "周日";
		if (x == 7) {
			str = "周六";
		} else if (x == 6) {
			str = "周五";
		} else if (x == 5) {
			str = "周四";
		} else if (x == 4) {
			str = "周三";
		} else if (x == 3) {
			str = "周二";
		} else if (x == 2) {
			str = "周一";
		}
		return str;
	}

	// 根据当前一个星期中的第几天得到它的日期
	public static Date getDateOfCurrentWeek(int day) {
		Calendar aCalendar = Calendar.getInstance();
		int x = aCalendar.get(Calendar.DAY_OF_WEEK);
		aCalendar.add(Calendar.DAY_OF_WEEK, day - (x - 1));
		return aCalendar.getTime();
	}

	// 某一天在一个月中的第几周
	public static int getWeekOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.WEEK_OF_MONTH);
	}

	public static int getHourOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	public static Date addSomeDay(Date oldDate, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(oldDate);
		calendar.add(Calendar.DATE, num);
		return calendar.getTime();
	}

	// 把日期“2006-09-01”转化成20060901
	public static String Dateformat(String date) {
		int i = date.length();
		StringBuffer newdate = new StringBuffer(date.substring(0, 4));
		if (i == 8) {

			newdate.append(0);
			newdate.append(date.substring(5, 6));
			newdate.append(0);
			newdate.append(date.substring(7, 8));
		} else if (i == 9) {
			if (date.substring(7, 8).equalsIgnoreCase("-")) {

				newdate.append(date.substring(5, 7));
				newdate.append(0);
				newdate.append(date.substring(8, 9));
			} else {
				newdate.append(0);
				newdate.append(date.substring(5, 6));
				newdate.append(date.substring(7, 9));
			}

		} else {

			newdate.append(date.substring(5, 7));
			newdate.append(date.substring(8, 10));
		}

		return newdate.toString();

	}

	public static String getOffsetDate2String(int dayNum) {
		Date d = addDay(Calendar.getInstance().getTime(), dayNum);
		String strD = DateUtils.formatDate(d);
		return strD;
	}

	/* 新增static方法 */
	/* 格式话日期为yyyy-MM-dd形式 */
	public static String formatDate(Date myDate) {
		return formatDateTime(myDate, PATTERN_DATE);
	}

	public static String formatDate(Date myDate, String pattern) {
		return formatDateTime(myDate, pattern);
	}

	/* 格式话日期为yyyy-MM-dd HH:mm形式 */
	public static String formatDateMinutes(Date myDate) {
		return formatDateTime(myDate, PATTERN_DATEMINUTES);
	}

	/* 格式话日期为yyyy-MM-dd HH:mm:ss形式 */
	public static String formatDateTime(Date myDate) {
		return formatDateTime(myDate, PATTERN_DATETIME);
	}

	/* 将字符串转换成日期 */
	public static Date getDateByString(String rq) {
		// DateFormat df = DateFormat.getDateInstance();
		DateFormat df = new SimpleDateFormat(PATTERN_DATE);
		Date d = null;
		try {
			d = df.parse(rq);
			// System.out.println(" parse " + d);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return d;
	}

	/* 将字符串转换成日期 */
	public static Date getDateString(String rq) {
		// DateFormat df = DateFormat.getDateInstance();
		DateFormat df = new SimpleDateFormat(PATTERN_DATEMINUTES);
		Date d = null;
		try {
			d = df.parse(rq);
			// System.out.println(" parse " + d);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return d;
	}

	public static Date getDateByString(String str, String pattern) {
		SimpleDateFormat sdf = null;
		try {
			sdf = new SimpleDateFormat(pattern);
		} catch (Exception ex) {
			sdf = new SimpleDateFormat(PATTERN_DATE);
		}
		try {
			return sdf.parse(str);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return null;
	}

	/* 将字符串转换成日期 */
	public static Date parse(String param) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATETIME);
		try {
			date = sdf.parse(param);

		} catch (Exception ex) {
		}
		return date;
	}

	public static final Date convertStringToDate(String aMask, String strDate) {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);

		try {
			date = df.parse(strDate);
		} catch (Exception pe) {
			pe.printStackTrace();
		}

		return (date);
	}

	// add by csg
	// 当前月份第一天
	public static Date getCurrentMonthFirstDay() {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		date = DateUtils.getDateByString(DateUtils.formatDate(date));// 转化成零点
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	// 增加或减少几个月
	public static Date addMonth(Date date, int num) {
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.MONTH, num);
		return startDT.getTime();
	}

	// 增加或减少天数
	public static Date addDay(Date date, int num) {
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.DAY_OF_MONTH, num);
		return startDT.getTime();
	}

	// 增加或减少小时数
	public static Date addHour(Date date, int num) {
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.HOUR, num);
		return startDT.getTime();
	}

	/* 将字符串转换成日期 */
	public static Date getDateTimeByString(String rq) {
		DateFormat df = new SimpleDateFormat(PATTERN_DATETIME);
		// DateFormat df = DateFormat.getDateTimeInstance();
		Date d = null;
		try {
			d = df.parse(rq);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return d;
	}

	// 得到当前系统日期．add by lnb 12.12

	public static String getCurrentTime() {
		Date myDate = new Date(System.currentTimeMillis());
		return formatDateTime(myDate);
	}

	public static boolean isSameDay(Date c1, Date c2) {
		return formatDate(c1).equals(formatDate(c2));
	}

	public static Calendar string2Cal(String arg) {
		SimpleDateFormat sdf = null;
		String trimString = arg.trim();
		if (trimString.length() > 14)
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		else
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = sdf.parse(trimString);
		} catch (ParseException e) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		return cal;
	}

	/**
	 * 匹配是否在某个时间段中
	 *
	 * @param timePeriod
	 *            "00:00-06:00"格式
	 * @param time
	 *            "07:30"
	 * @return
	 */
	public static boolean isInPeriod(String timePeriod, String time) {
		String startTime = timePeriod.substring(0, 5);

		String endTime = timePeriod.substring(6);

		String timeTime = time;

		// 和时间段的开始或者结束刚好相等的时候
		if (startTime.equalsIgnoreCase(timeTime) || endTime.equalsIgnoreCase(timeTime)) {
			return true;
		}

		SimpleDateFormat d = new SimpleDateFormat("HH:mm");

		try {
			Date startDate = d.parse(startTime);

			Date endDate = d.parse(endTime);

			Date timeDate = d.parse(timeTime);

			if (timeDate.after(startDate) && timeDate.before(endDate)) {
				return true;
			}
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

		return false;
	}

	@Deprecated
	/**
	 * @param time
	 * @return
	 */
	public static String unix2DStr(Long time, String pattern) {
		if (time == null)
			return "";
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return formatDate(calendar.getTime(), pattern);
	}

	/**
	 * unix时间戳转指定格式
	 * 
	 * @param time
	 * @param pattern
	 * @return
	 */
	public static String unix2DStr(Integer time, String pattern) {
		return millisecond2DStr(time * 1000l, pattern);
	}

	public static String millisecond2DStr(Long time, String pattern) {
		if (time == null)
			return "";
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return formatDate(calendar.getTime(), pattern);
	}

	public static int getUnixTime() {
		return Long.valueOf(System.currentTimeMillis() / 1000).intValue();
	}

	public static Timestamp getTimeStamp(Integer time) {
		Timestamp timestamp = new Timestamp(time * 1000L);
		return timestamp;
	}

	public static int getUnixTimeTen() {
		return Long.valueOf(System.currentTimeMillis()).intValue();
	}

	public static int getNextStart(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return Long.valueOf(cal.getTimeInMillis() / 1000).intValue();
	}

	/**
	 * 取精确到小时的时间字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getYYYYMMddHH(Date date) {
		String ret;
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHH");
			ret = sf.format(date);
		} catch (Exception e) {
			ret = "";
		}
		return ret;
	}

	/**
	 * 获取指定日期0:0:0的unix时间戳
	 * 
	 * @param date
	 * @return
	 */
	public static Integer getDateUnixTime(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		Integer cdate = Long.valueOf(now.getTimeInMillis() / 1000).intValue();
		return cdate;
	}

	public static Integer getUnixTime(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		Integer cdate = Long.valueOf(now.getTimeInMillis() / 1000).intValue();
		return cdate;
	}

	/**
	 * 获取指定日期23:59:59的unix时间戳
	 * 
	 * @param date
	 * @return
	 */
	public static Integer getDayEndUnixTime(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.HOUR_OF_DAY, 23);
		now.set(Calendar.MINUTE, 59);
		now.set(Calendar.SECOND, 59);
		Integer cdate = Long.valueOf(now.getTimeInMillis() / 1000).intValue();
		return cdate;
	}

	/**
	 * 获取指定日期23:59:59的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp getDayEndTime(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.HOUR_OF_DAY, 23);
		now.set(Calendar.MINUTE, 59);
		now.set(Calendar.SECOND, 59);
		now.set(Calendar.MILLISECOND, 0);
		return new Timestamp(now.getTime().getTime());
	}

	/**
	 * 获取指定日期00:00:00的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp getDayOfStartTime(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.HOUR_OF_DAY, 00);
		now.set(Calendar.MINUTE, 00);
		now.set(Calendar.SECOND, 00);
		now.set(Calendar.MILLISECOND, 0);
		return new Timestamp(now.getTime().getTime());
	}

	public static Timestamp getCurrentTime(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		return new Timestamp(now.getTime().getTime());
	}

	/**
	 * 获取当天0:0:0的unix时间戳
	 * 
	 * @return
	 */
	public static Integer getTodayStartUnixTime() {
		return getDateUnixTime(new Date());
	}

	/**
	 * 获取当天23:59:59的unix时间戳
	 * 
	 * @return
	 */
	public static Integer getTodayEndUnixTime() {
		return getDayEndUnixTime(new Date());
	}

	public static Integer getDayUnixTime(Date date) {
		Integer fs = Long.valueOf(date.getTime() / 1000).intValue();
		Integer ds = getDateUnixTime(date);
		return fs - ds;
	}

	public static boolean isSameDay(Integer time, Integer nexttime) {
		if (time == nexttime) {
			return true;
		}
		if (!getShortDate(new Date(time * 1000l)).equals(getShortDate(new Date(nexttime * 1000l)))) {
			return false;
		} else {
			return true;
		}
	}

	/* 格式化日期为短形式 */
	public static String getShortDate(Calendar calendar) {
		SimpleDateFormat fd = new SimpleDateFormat(PATTERN_DATESHORT);
		if (calendar != null) {
			return (fd.format(calendar.getTime()));
		}
		return null;
	}

	public static String format(Long stamp, String format) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(stamp);
		String stampStr = DateUtils.formatDate(c.getTime(), format);
		return stampStr;
	}

	public static Integer getUnixtime(Timestamp time) {
		if (time == null)
			return null;
		return Long.valueOf(time.getTime() / 1000).intValue();
	}

	public static Map<String, Integer> getHourTimeMap() {
		SimpleDateFormat format_hour = new SimpleDateFormat(PATTERN_DATEHOURS);
		Map<String, Integer> map = new HashMap<String, Integer>(0);
		Date date = new Date();
		String endDate = formatDate(date, "yyyy-MM-dd HH");
		Date preHour = addHour(date, -1);
		String startDate = formatDate(preHour, "yyyy-MM-dd HH");
		Date starttime = null;
		try {
			starttime = format_hour.parse(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date endtime = null;
		try {
			endtime = format_hour.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer starttimeNum = (int) (starttime.getTime() / 1000);
		Integer endtimeNum = (int) (endtime.getTime() / 1000);
		map.put("startTime", starttimeNum);
		map.put("endTime", endtimeNum);
		return map;
	}

	public static int getCurrentHour() {

		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.HOUR_OF_DAY);

	}

	public static String formatUnixTimeToDate(String timeStr, String formatStr) {
		Long time = Long.parseLong(timeStr) * 1000;
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(time);
	}

	/**
	 * 获取指定日期0:0:0的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDayStartTime(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		return now.getTime();
	}

	public static void main(String arg[]) throws ParseException {
		SimpleDateFormat fd = new SimpleDateFormat("yyyy");
		System.out.println(fd.format(new Date()));
	}
}