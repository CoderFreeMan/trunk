package com.ydj.date;

import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

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
public class DateUtilTest {

    @Test
    public void getDefaultDate() throws ParseException {
        System.out.println(DateUtil.parseDefaultDate("2018-9-27"));
    }

    @Test
    public void getDefaultTime() throws ParseException {
        System.out.println(DateUtil.parseDefaultTime("11:11:11"));
    }

    @Test
    public void getDefaultDateTime() throws ParseException {
        System.out.println(DateUtil.parseDefaultDateTime("2018-9-27 11:29:36"));
    }

    @Test
    public void parseDefaultDate() {
        System.out.println(DateUtil.parseDefaultDate(new Date()));
    }

    @Test
    public void parseDefaultTime() {
        System.out.println(DateUtil.parseDefaultTime(new Date()));
    }

    @Test
    public void parseDefaultDateTime() {
        System.out.println(DateUtil.parseDefaultDateTime(new Date()));
    }

    @Test
    public void parseTimestampToDate() throws ParseException {
        System.out.println(DateUtil.parseTimestampToDate(System.currentTimeMillis()));
    }

    @Test
    public void parseDateToTimestamp() {
        System.out.println(DateUtil.parseDateToTimestamp(new Date()));
    }

    @Test
    public void getBeforMonthFirstDate() throws ParseException {
        Date beforMonthFirstDate = DateUtil.getBeforMonthFirstDate();
        System.out.println(DateUtil.parseDefaultDateTime(beforMonthFirstDate));
    }

    @Test
    public void getBeforMonthLastDate() {
        Date beforMonthLastDate = DateUtil.getBeforMonthLastDate();
        System.out.println(DateUtil.parseDefaultDateTime(beforMonthLastDate));
    }

    @Test
    public void getBeforWeekFirstDate() {
        Date beforWeekFirstDate = DateUtil.getBeforWeekFirstDate();
        System.out.println(DateUtil.parseDefaultDateTime(beforWeekFirstDate));
    }

    @Test
    public void getBeforWeekLastDate() {
        Date beforWeekLastDate = DateUtil.getBeforWeekLastDate();
        System.out.println(DateUtil.parseDefaultDateTime(beforWeekLastDate));
    }
}