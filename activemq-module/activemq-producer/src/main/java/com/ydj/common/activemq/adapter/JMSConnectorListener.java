package com.ydj.common.activemq.adapter;

import com.ydj.common.activemq.jms.JMSConnector;

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
public interface JMSConnectorListener {

    void beforeSend(JMSConnectorEvent e);

    void afterSend(JMSConnectorEvent e);

    void afterCommit(JMSConnectorEvent e);

    void setJMSConnector(JMSConnector jmsConnector);

}
