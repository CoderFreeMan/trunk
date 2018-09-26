package com.ydj.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
    private static DateFormat dateFormat = null;

    /**
     * 时分秒 DataFormat
     */
    private static DateFormat timeFormat = null;

    /**
     * 年月日 时分秒 DataFormat
     */
    private static DateFormat datetimeFormat = null;

    /**
     * 类加载时创建对象，防止在方法中创建多余的对象
     */
    static {
        dateFormat = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
        timeFormat = new SimpleDateFormat(TIME_DEFAULT_FORMAT);
        datetimeFormat = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
    }

}
