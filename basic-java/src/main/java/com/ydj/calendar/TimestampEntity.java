package com.ydj.calendar;

import java.sql.Timestamp;

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
public class TimestampEntity {

    private String id;

    private Timestamp timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
