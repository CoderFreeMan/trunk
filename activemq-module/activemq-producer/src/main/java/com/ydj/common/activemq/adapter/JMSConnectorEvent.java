package com.ydj.common.activemq.adapter;

/**
 * <p> Date             :2018/9/22 </p>
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
public class JMSConnectorEvent {

    public String threadName;

    public Type type;

    public Object event;

    public JMSConnectorEvent(String threadName, Type type, Object event) {
        this.threadName = threadName;
        this.type = type;
        this.event = event;
    }

    public enum Type {
    SEND, DELAY_SEND, COMMIT
    }

}
