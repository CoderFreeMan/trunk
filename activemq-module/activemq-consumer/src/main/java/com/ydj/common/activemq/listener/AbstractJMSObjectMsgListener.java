package com.ydj.common.activemq.listener;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.beans.ExceptionListener;
import java.io.Serializable;

/**
 * <p> Date             :2018/9/23 </p>
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
@Component
public abstract class AbstractJMSObjectMsgListener implements SessionAwareMessageListener, ExceptionListener {

    private static final Logger logger = LoggerFactory.getLogger(AbstractJMSObjectMsgListener.class);

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        try {
            dealWithMsg(message);
        } catch (Exception e) {
            logger.error("onMessage error!!!", e);
            throw new RuntimeException("onMessage RuntimeException!!!");
        }
    }

    public void onException(JMSException e) {
        logger.error("occured JMSException:", e);
    }

    public void dealWithMsg(Message msg) throws Exception {
        logger.debug("mq deal msg queue ===> [{}]", ((ActiveMQObjectMessage) msg).getMessage().getDestination());
        Serializable serializable = getMessageBean(msg);
        doService(serializable);
    }

    public Serializable getMessageBean(Message msg) throws JMSException {
        ObjectMessage objectMessage = (ObjectMessage) msg;
        return objectMessage.getObject();
    }

    @Override
    public void exceptionThrown(Exception e) {

    }

    public abstract void doService(Serializable serializable) throws Exception;
}
