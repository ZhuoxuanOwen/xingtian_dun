package com.zhuoxuan.common.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 处理时间的工具类
 * 
 * @author Gao Jiangtao
 * 
 */
public class DateUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 格式化传入的时间
	 * 
	 * @param date
	 *            传入的时间
	 * @return 格式化的结果
	 */
	public static String getDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	/**
	 * 格式化传入的时间
	 * 
	 * @param date
	 *            传入的时间
	 * @return 格式化的结果
	 */
	public static String getDateTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 取得当前日期 此方法名称与返回值含义不一致，不推荐使用。 取得当前日期及时间请用 getNow()
	 * 
	 * @return 当前日期
	 * @since 0.1
	 */
	public static Date getToday() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * 取得当前时间
	 * 
	 * @return 当前时间
	 */
	public static Date getNow() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * 求两个日期中较小的日期
	 * 
	 * @param 日期1
	 *            ，日期2
	 * @return 返回小日期
	 * @since 0.1
	 */
	public static Date getSmallDate(Date date1, Date date2) {
		return date1.compareTo(date2) < 0 ? date1 : date2;
	}

	/**
	 * 求两个日期中较大的日期
	 * 
	 * @param 日期1
	 *            ，日期2
	 * @return 返回大日期
	 * @since 0.1
	 */
	public static Date getBigDate(Date date1, Date date2) {
		return date1.compareTo(date2) > 0 ? date1 : date2;
	}

	/**
	 * 在给定日期上增减一段时间
	 * 
	 * @param monthAmount
	 *            月数
	 * @param date
	 *            给定日期
	 * @return 增减后的日期
	 */
	public static Date addMonth2Date(int monthAmount, Date date) {
		Date newDate = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MONTH, monthAmount);
			newDate = calendar.getTime();
		}
		return newDate;
	}

	/**
	 * 在给定日期上增减一段时间
	 * 
	 * @param dayAmount
	 *            天数
	 * @param date
	 *            给定日期
	 * @return 增减后的日期
	 */
	public static Date addDay2Date(int dayAmount, Date date) {
		Date newDate = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH, dayAmount);
			newDate = calendar.getTime();
		}
		return newDate;
	}

	/**
	 * 在给定日期上增减一段时间
	 * 
	 * @param hourAmount
	 *            小时数
	 * @param date
	 *            给定日期
	 * @return 增减后的日期
	 */
	public static Date addHour2Date(int hourAmount, Date date) {
		Date newDate = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.HOUR_OF_DAY, hourAmount);
			newDate = calendar.getTime();
		}
		return newDate;
	}

	/**
	 * 在给定日期上增减一段时间
	 * 
	 * @param minuteAmount
	 *            分钟数
	 * @param date
	 *            给定日期
	 * @return 增减后的日期
	 */
	public static Date addMinute2Date(int minuteAmount, Date date) {
		Date newDate = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MINUTE, minuteAmount);
			newDate = calendar.getTime();
		}
		return newDate;
	}

	/**
	 * 此方法将给出的和日期格式化成本地日期形式的字符串。(只含有年月日)
	 * 
	 * @param 待格式的日期
	 * @return 本地日期形式的字符串。例：1983-12-29
	 * @since 0.1
	 */
	public static String formatDate2NN(Date date) {
		StringBuffer dateBuffer = new StringBuffer("");
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			dateBuffer.append(calendar.get(Calendar.YEAR) + "-");
			dateBuffer.append((calendar.get(Calendar.MONTH) + 1) + "-");
			dateBuffer.append(calendar.get(Calendar.DAY_OF_MONTH));
		}
		return dateBuffer.toString();
	}

	/**
	 * 此方法将给出的和日期格式化成本地日期形式的字符串。(含有年月日时分)
	 * 
	 * @param 待格式的日期
	 * @return 本地日期形式的字符串。例：1983-12-29 08:05
	 * @since 0.1
	 */
	public static String formatDateTime2NN(Date date) {
		StringBuffer dateBuffer = new StringBuffer("");
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			dateBuffer.append(calendar.get(Calendar.YEAR) + "-");
			dateBuffer.append((calendar.get(Calendar.MONTH) + 1) + "-");
			dateBuffer.append(calendar.get(Calendar.DAY_OF_MONTH) + " ");
			dateBuffer.append(StringUtil.formatNumber(calendar
					.get(Calendar.HOUR_OF_DAY), 2, '0')
					+ ":");
			dateBuffer.append(StringUtil.formatNumber(calendar
					.get(Calendar.MINUTE), 2, '0'));
		}
		return dateBuffer.toString();
	}

	/**
	 * 此方法将给出的和日期格式化成本地日期形式的字符串。 （含有年月日时分秒)
	 * 
	 * @param 待格式的日期
	 * @return 本地日期形式的字符串。例：1983-12-29 08:05:12
	 * @since 0.1
	 */
	public static String formatFullDateTime2NN(Date date) {
		StringBuffer dateBuffer = new StringBuffer("");
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			dateBuffer.append(calendar.get(Calendar.YEAR) + "-");
			dateBuffer.append((calendar.get(Calendar.MONTH) + 1) + "-");
			dateBuffer.append(calendar.get(Calendar.DAY_OF_MONTH) + " ");
			dateBuffer.append(StringUtil.formatNumber(calendar
					.get(Calendar.HOUR_OF_DAY), 2, '0')
					+ ":");
			dateBuffer.append(StringUtil.formatNumber(calendar
					.get(Calendar.MINUTE), 2, '0')
					+ ":");
			dateBuffer.append(StringUtil.formatNumber(calendar
					.get(Calendar.SECOND), 2, '0'));
		}
		return dateBuffer.toString();
	}

	/**
	 * 此方法将给出的和日期格式化成本地日期形式的字符串。（只含有年月日
	 * 
	 * @param 待格式的日期
	 * @return 本地日期形式的字符串。例：1983年12月29日
	 * @since 0.1
	 */
	public static String formatDate2NC(Date date) {
		StringBuffer dateBuffer = new StringBuffer("");
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			dateBuffer.append(calendar.get(Calendar.YEAR) + "年");
			dateBuffer.append((calendar.get(Calendar.MONTH) + 1) + "月");
			dateBuffer.append(calendar.get(Calendar.DAY_OF_MONTH) + "日");
		}
		return dateBuffer.toString();
	}

	/**
	 * 此方法将给出的和日期格式化成本地日期形式的字符串。 （只含有年月日
	 * 
	 * @param 待格式的日期
	 * @return 本地日期形式的字符串。例：1983-12-29
	 * @since 0.1
	 */
	public static String formatDateTime2NC(Date date) {
		StringBuffer dateBuffer = new StringBuffer("");
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			dateBuffer.append(calendar.get(Calendar.YEAR) + "年");
			dateBuffer.append((calendar.get(Calendar.MONTH) + 1) + "月");
			dateBuffer.append(calendar.get(Calendar.DAY_OF_MONTH) + "日 ");
			dateBuffer.append(StringUtil.formatNumber(calendar
					.get(Calendar.HOUR_OF_DAY), 2, '0')
					+ "时");
			dateBuffer.append(StringUtil.formatNumber(calendar
					.get(Calendar.MINUTE), 2, '0')
					+ "分");
		}
		return dateBuffer.toString();
	}

	/**
	 * 此方法将给出的和日期格式化成本地日期形式的字符串。 （只含有年月日
	 * 
	 * @param 待格式的日期
	 * @return 本地日期形式的字符串。例：1983-12-29
	 * @since 0.1
	 */
	public static String formatFullDateTime2NC(Date date) {
		StringBuffer dateBuffer = new StringBuffer("");
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			dateBuffer.append(calendar.get(Calendar.YEAR) + "年");
			dateBuffer.append((calendar.get(Calendar.MONTH) + 1) + "月");
			dateBuffer.append(calendar.get(Calendar.DAY_OF_MONTH) + "日 ");
			dateBuffer.append(StringUtil.formatNumber(calendar
					.get(Calendar.HOUR_OF_DAY), 2, '0')
					+ "时");
			dateBuffer.append(StringUtil.formatNumber(calendar
					.get(Calendar.MINUTE), 2, '0')
					+ "分");
			dateBuffer.append(StringUtil.formatNumber(calendar
					.get(Calendar.SECOND), 2, '0')
					+ "秒");
		}
		return dateBuffer.toString();
	}

	/**
	 * 此方法将给出的指定日期所在周的第一天日期(周日所的日期)
	 * 
	 * @param 指定日期
	 * @return 第一天的日期
	 * @since 0.1
	 * @author noco
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar weekStart = Calendar.getInstance();
		weekStart.setTime(date);
		weekStart.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return weekStart.getTime();
	}

	/**
	 * 此方法将给出的指定日期所在周的第最后一天日期(周六所有的日期)
	 * 
	 * @param 指定日期
	 * @return 最后一天的日期
	 * @since 0.1
	 * @author noco
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar weekStart = Calendar.getInstance();
		weekStart.setTime(date);
		weekStart.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		return weekStart.getTime();
	}

	/**
	 * 此方法将给出的指定日期所在月的第一天日期(周日所的日期)
	 * 
	 * @param 指定日期
	 * @return 第一天的日期
	 * @since 0.1
	 * @author noco
	 */
	public static Date getFirstDayOfMonth(Date date) {

		Calendar cal = Calendar.getInstance();
		int mindate = cal.getActualMinimum(Calendar.DATE);
		cal.set(Calendar.DATE, mindate);
		return cal.getTime();
	}

	/**
	 * 此方法将给出的指定日期所在月的第最后一天日期(周六所有的日期)
	 * 
	 * @param 指定日期
	 * @return 最后一天的日期
	 * @since 0.1
	 * @author noco
	 */
	public static Date getLastDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		int maxdate = cal.getActualMaximum(Calendar.DATE);
		cal.set(Calendar.DATE, maxdate);
		return cal.getTime();
	}

	public static void main(String[] args) {
		System.out.println(DateUtil.formatDateTime2NN(DateUtil
				.getFirstDayOfMonth(DateUtil.getNow())));
		System.out.println(DateUtil.formatDateTime2NN(DateUtil
				.getLastDayOfMonth(DateUtil.getNow())));
		System.out.println(DateUtil.formatDateTime2NN(DateUtil
				.getFirstDayOfWeek(DateUtil.getNow())));
		System.out.println(DateUtil.formatDateTime2NN(DateUtil
				.getLastDayOfWeek(DateUtil.getNow())));
	}

	/**
	 * 将字符串解析成日期类型，如果字符串含有/则按/分割,否则以-分
	 * 
	 * @param 待解析的字符串
	 * @return 解析后的日期
	 * @since 0.1
	 */
	public static Date getDate(String dateStr) {
		Date date = null;
		try {
			if (dateStr != null) {
				String separator = dateStr.indexOf('/') > 0 ? "/" : "-";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy"
						+ separator + "MM" + separator + "dd");
				date = simpleDateFormat.parse(dateStr);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return date;
	}

	/**
	 * 将字符串解析成日期时间类型，如果字符串含有/则按/分割,否则以-分
	 * 
	 * @param dateTimeStr
	 *            待解析的字符串
	 * @return 解析后的日期
	 */
	public static Date getDateTime(String dateTimeStr) {
		Date date = null;
		try {
			String separator = dateTimeStr.indexOf('/') > 0 ? "/" : "-";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy"
					+ separator + "MM" + separator + "dd HH:mm:ss");
			date = simpleDateFormat.parse(dateTimeStr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return date;
	}

	/**
	 * 取得传入日期的年
	 * 
	 * @param 待解析的日期
	 * @return 该日期的年份
	 * @since 0.1
	 */
	public static int getYear(Date date) {
		Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}

	/**
	 * 取得传入日期的月
	 * 
	 * @param 待解析的日期
	 * @return 该日期的月份
	 * @since 0.1
	 */
	public static int getMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * 取得传入日期的日
	 * 
	 * @param 待解析的日期
	 * @return 该日期的月份
	 * @since 0.1
	 */
	public static int getday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DATE);
	}

	/**
	 * 两个日期的月份差
	 * 
	 * @param 起始日期
	 *            ，结束日期
	 * @return 两日期的月分差，例1998-4-21~1998-6-21 相差两个月 返回2
	 * @since 0.1
	 */
	public static int getDiffMonth(Date fromDate, Date toDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(fromDate);
		int fromYear = c.get(Calendar.YEAR);
		int fromMonth = c.get(Calendar.MONTH) + 1;
		c.setTime(toDate);
		int toYear = c.get(Calendar.YEAR);
		int toMonth = c.get(Calendar.MONTH) + 1;
		int monthCount = 0;

		if (toYear == fromYear) {
			monthCount = toMonth - fromMonth;
		} else if (toYear - fromYear == 1) {
			monthCount = 12 - fromMonth + toMonth;
		} else {
			monthCount = 12 - fromMonth + 12 * (toYear - fromYear - 1)
					+ toMonth;
		}
		return monthCount;
	}

	/**
	 * 两个日期的天数差
	 * 
	 * @param 起始日期
	 *            ，结束日期
	 * @return 两日期的月分差，例1998-4-21~1998-4-25 相差两个月 返回4
	 * @since 0.1
	 */
	public static int getDiffDays(Date fromDate, Date toDate) {
		return (int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24));
	}

	/**
	 * 两个日期的天数差
	 * 
	 * @param 起始日期
	 *            ，结束日期
	 * @return 两日期的月分差，例1998-4-21~1998-4-25 相差两个月 返回4
	 * @since 0.1
	 */
	public static int getDiffMins(Date fromDate, Date toDate) {
		return (int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60));
	}

	public static String getTimeStampId() {
		Calendar c = Calendar.getInstance();
		int iYear = c.get(Calendar.YEAR);
		int iMon = c.get(Calendar.MONTH) + 1;
		int iDay = c.get(Calendar.DAY_OF_MONTH);
		int iHour = c.get(Calendar.HOUR_OF_DAY);
		int iMin = c.get(Calendar.MINUTE);
		int iSec = c.get(Calendar.SECOND);
		String s = String.valueOf(iYear);
		if (iMon < 10)
			s += "0";
		s = s + String.valueOf(iMon);
		if (iDay < 10)
			s += "0";
		s = s + String.valueOf(iDay);
		if (iHour < 10)
			s += "0";
		s = s + String.valueOf(iHour);
		if (iMin < 10)
			s += "0";
		s = s + String.valueOf(iMin);
		if (iSec < 10)
			s += "0";
		s = s + String.valueOf(iSec);
		return s;
	}

	public static String getTimeStamp() {
		Calendar c = Calendar.getInstance();
		int iYear = c.get(Calendar.YEAR);
		int iMon = c.get(Calendar.MONTH) + 1;
		int iDay = c.get(Calendar.DAY_OF_MONTH);
		int iHour = c.get(Calendar.HOUR_OF_DAY);
		int iMin = c.get(Calendar.MINUTE);
		int iSec = c.get(Calendar.SECOND);
		String s = String.valueOf(iYear);
		s += "-";
		if (iMon < 10)
			s += "0";
		s = s + String.valueOf(iMon);
		s += "-";
		if (iDay < 10)
			s += "0";
		s = s + String.valueOf(iDay);
		s += " ";
		if (iHour < 10)
			s += "0";
		s = s + String.valueOf(iHour);
		s += ":";
		if (iMin < 10)
			s += "0";
		s = s + String.valueOf(iMin);
		s += ":";
		if (iSec < 10)
			s += "0";
		s = s + String.valueOf(iSec);
		return s;
	}

	public static int getDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}

	public static int getDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		return dayOfMonth;
	}

	/**
	 * 格式化年、月
	 * 
	 * @param date
	 *            待格式化的日期
	 * @return 如'200711'
	 */
	public static String getYearAndMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String yearAndMonth = StringUtil.formatNumber(calendar
				.get(Calendar.YEAR), 4, '0');
		yearAndMonth = yearAndMonth
				+ StringUtil.formatNumber(calendar.get(Calendar.MONTH) + 1, 2,
						'0');
		return yearAndMonth;
	}

}
