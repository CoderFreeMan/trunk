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
public class JMSConnectorListenerAdapter implements JMSConnectorListener {
    @Override
    public void beforeSend(JMSConnectorEvent e) {
        
    }

    @Override
    public void afterSend(JMSConnectorEvent e) {

    }

    @Override
    public void afterCommit(JMSConnectorEvent e) {

    }

    @Override
    public void setJMSConnector(JMSConnector jmsConnector) {

    }
}
