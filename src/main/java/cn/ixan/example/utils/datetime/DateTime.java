package cn.ixan.example.utils.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Java8日期API简单使用
 *
 * @author stack_zhang@outlook.com
 * @date 2019年3月3日, 0003
 */
public class DateTime {
	/**
	 * 获得一周中的第几天
	 *
	 * @return String
	 */
	public static int getDayOfWeek(LocalDate localDate) {
		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		return dayOfWeek.getValue();
	}

	/**
	 * 获得明天的日期
	 *
	 * @return Date
	 */
	public static String getNextDayString() {
		LocalDate localDate = LocalDate.now();
		LocalDate date = localDate.plusDays(1);
		return date.toString();
	}

	/**
	 * 获得昨天的日期
	 *
	 * @return Date
	 */
	public static String getYesterdayString() {
		LocalDate localDate = LocalDate.now();
		LocalDate date = localDate.minusDays(1);
		return date.toString();
	}

	/**
	 * 获取过去的分钟
	 *
	 * @param lastDay 过去的时间
	 * @return long
	 */
	public static long pastMinutes(LocalDateTime lastDay) {
		LocalDateTime now = LocalDateTime.now();
		return Duration.between(lastDay, now).toMinutes();
	}

	/**
	 * 获取过去的小时
	 *
	 * @param lastDay 过去的时间
	 * @return long
	 */
	public static long pastHour(LocalDateTime lastDay) {
		LocalDateTime now = LocalDateTime.now();
		return Duration.between(lastDay, now).toHours();
	}

	/**
	 * 获取过去的天数
	 *
	 * @param lastDay 过去的时间
	 * @return long
	 */
	public static long pastDays(LocalDateTime lastDay) {
		LocalDateTime now = LocalDateTime.now();
		return Duration.between(lastDay, now).toDays();
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E");
		return formatter.format(localDate);
	}

	/**
	 * 得到当天字符串 格式（HH）
	 */
	public static String getHour() {
		LocalTime now = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");
		return formatter.format(now);
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		LocalDate localDate = LocalDate.now();
		return String.valueOf(localDate.getDayOfMonth());
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static int getMonth() {
		LocalDate localDate = LocalDate.now();
		return localDate.getMonthValue();
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		LocalDate localDate = LocalDate.now();
		return String.valueOf(localDate.getYear());
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		LocalTime localTime = LocalTime.now().withNano(0);
		return DateTimeFormatter.ISO_LOCAL_TIME.format(localTime);
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		return DateTimeFormatter.ISO_DATE_TIME.format(localDateTime);
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDateString(String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return formatter.format(LocalDateTime.now());
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDateString() {
		LocalDate localDate = LocalDate.now();
		return DateTimeFormatter.ISO_DATE.format(localDate);
	}


	//5.如何获取直到现在距离指定的时间还有多久ms
	public static long getSecondsBetweenDates(LocalDateTime d1, LocalDateTime d2) {
		return Duration.between(d1, d2).toMillis();
	}

	//5.如何获取直到现在距离指定的时间还有多久
	public static long getSecondsBetweenDates(Date d1, Date d2) {
		return Math.abs((d1.getTime() - d2.getTime()) / 1000);
	}
	//4.如何获取指定日期所在周从一天开始？

	//3.如何获取当前的年份？
	public static int getNumberOfCurrentYear() {
		LocalDate localDate = LocalDate.now();
		return localDate.getYear();
	}

	//2.如何获取当前的月份？
	public static String getNameOfCurrentMonth() {
		LocalDate localDate = LocalDate.now();
		return localDate.getMonth().name();
	}

	//1.如何获取当前的月份？
	public static int getNumberOfCurrentMonth() {
		LocalDate localDate = LocalDate.now();
		return localDate.getMonth().getValue();
	}
}
