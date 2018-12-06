package com.ydj.calendar;

/**
 *  
 *  <p> Date             : 2018/12/4 </p >
 *  <p> Module             : </p >
 *  <p> Description             : </p >
 *  <p> Remark             : </p >
 *  @author yangdj
 *  @version 1.0
 *  <p>--------------------------------------------------------------</p >
 *  <p>修改历史</p >
 *  <p>    序号    日期    修改人    修改原因    </p >
 *  <p>    1                           </p >
 *  
 */
public class TimestampTest {

    public static void main(String[] args) {
        TimestampEntity entity = new TimestampEntity();
        entity.setId("id");
        System.out.println(entity.getTimestamp());
    }

}
