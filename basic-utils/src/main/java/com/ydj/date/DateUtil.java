package com.ydj.date;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * <p> Date             :2017/10/9 </p>
 * <p> Module           : </p>
 * <p> Description      : </p>
 * <p> Remark           : </p>
 *
 * @author yangdejun
 * @version 1.0
 * <p>--------------------------------------------------------------</p>
 * <p>修改历史</p>
 * <p>    序号    日期    修改人    修改原因    </p>
 * <p>    1                                     </p>
 */
public class DateUtil {

    /**
     * 私有构造方法，防止被实例化
     */
    private DateUtil() {
        throw new AssertionError();
    }

    /**
     * 年月日默认格式
     */
    public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";

    /**
     * 时分秒默认格式
     */
    public static final String TIME_DEFAULT_FORMAT = "HH:mm:ss";

    /**
     * 年月日 时分秒默认格式
     */
    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年月日 DataFormat
     */
    private static DateFormat defaultDateFormat = null;

    /**
     * 时分秒 DataFormat
     */
    private static DateFormat defaultTimeFormat = null;

    /**
     * 年月日 时分秒 DataFormat
     */
    private static DateFormat defaultDatetimeFormat = null;

    /**
     * 类加载时创建对象，防止在方法中创建多余的对象
     */
    static {
        defaultDateFormat = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
        defaultTimeFormat = new SimpleDateFormat(TIME_DEFAULT_FORMAT);
        defaultDatetimeFormat = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
    }

    public static final String NULL_OR_BLANK_EXCEPTION = "params must be not null or blank string";

    public static final String NULL_EXCEPTION = "params must be not null";

    /**
     * 将"年-月-日" 格式的字符串转换为Date类型
     * @param dateStr 需要转换的"年-月-日"格式的字符串
     * @return 转换后的 Date 格式
     * @throws ParseException
     */
    public static Date parseDefaultDate(String dateStr) throws ParseException {
        if (StringUtils.isBlank(dateStr)) {
            throw new NullPointerException(NULL_OR_BLANK_EXCEPTION);
        }
        return defaultDateFormat.parse(dateStr);
    }

    /**
     * 将"时:分:秒"格式的字符串转换为Date类型，没有多少实际意义
     * @param timeStr 需要转换的"时:分:秒"格式的字符串
     * @return 转换后的 Date 格式, 年月日时 1970-01-01
     * @throws ParseException
     */
    public static Date parseDefaultTime(String timeStr) throws ParseException {
        if (StringUtils.isBlank(timeStr)) {
            throw new NullPointerException(NULL_OR_BLANK_EXCEPTION);
        }
        return defaultTimeFormat.parse(timeStr);
    }

    /**
     * 将"年-月-日 时:分:秒"格式的字符串转换为Date类型
     * @param dateTimeStr 需要转换的"年-月-日 时:分:秒"格式的字符串
     * @return 转换后的 Date 格式
     * @throws ParseException
     */
    public static Date parseDefaultDateTime(String dateTimeStr) throws ParseException {
        if (StringUtils.isBlank(dateTimeStr)) {
            throw new NullPointerException(NULL_OR_BLANK_EXCEPTION);
        }
        return defaultDatetimeFormat.parse(dateTimeStr);
    }

    /**
     * 将Date类型的时间转换为"年-月-日"类型的时间字符串
     * @param date 需要转换的 Date
     * @return 转换后的"年-月-日"格式的时间字符串
     */
    public static String parseDefaultDate(Date date) {
        if (null == date) {
            throw new NullPointerException(NULL_EXCEPTION);
        }
        return defaultDateFormat.format(date);
    }

    /**
     * 将Date类型的时间转换为"时:分:秒"类型的时间字符串
     * @param date 需要转换的 Date
     * @return 转换后的"时:分:秒"格式的时间字符串
     */
    public static String parseDefaultTime(Date date) {
        if (null == date) {
            throw new NullPointerException(NULL_EXCEPTION);
        }
        return defaultTimeFormat.format(date);
    }

    /**
     * 将Date类型的时间转换为"年-月-日 时:分:秒"类型的时间字符串
     * @param date 需要转换的 Date
     * @return 转换后的"年-月-日 时:分:秒"格式的时间字符串
     */
    public static String parseDefaultDateTime(Date date) {
        if (null == date) {
            throw new NullPointerException(NULL_EXCEPTION);
        }
        return defaultDatetimeFormat.format(date);
    }

    /**
     * 将时间戳转换为 Date
     * @param timestamp 需要转换为 Date 格式的时间戳
     * @return 转换为Date
     * @throws ParseException
     */
    public static Date parseTimestampToDate(Long timestamp) throws ParseException {
        if (null == timestamp) {
            throw new NullPointerException(NULL_EXCEPTION);
        }
        return defaultDatetimeFormat.parse(defaultDatetimeFormat.format(timestamp));
    }

    /**
     * 将Date类型转换为时间戳类型
     * @param date 需要转换为时间戳类型的Date
     * @return 转换为时间戳后的值
     */
    public static long parseDateToTimestamp(Date date) {
        if (null == date) {
            throw new NullPointerException(NULL_EXCEPTION);
        }
        return date.getTime();
    }

    /**
     * 获取当前时间的上个月的第一天
     * @return 返回当前时间的上个月的第一天的零时零分零秒
     */
    public static Date getBeforMonthFirstDate() {
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR, -12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前月份的第一天
     * @return 返回当前时间月的第一天的零时零分零秒
     */
    public static Date getBeforMonthLastDate() {
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR, -12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前周的上一周的第一天
     * @return 返回当前周的上一周第一天的零时零分零秒
     */
    public static Date getBeforWeekFirstDate() {
        Calendar calendar=Calendar.getInstance(Locale.CHINA);
        calendar.add(Calendar.WEEK_OF_MONTH, -1);
        calendar.set(Calendar.DAY_OF_WEEK, 2);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前周的第一天的第一天
     * @return 返回当前周的第一天的零时零分零秒
     */
    public static Date getBeforWeekLastDate() {
        Calendar calendar=Calendar.getInstance(Locale.CHINA);
        calendar.set(Calendar.DAY_OF_WEEK, 2);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

}
