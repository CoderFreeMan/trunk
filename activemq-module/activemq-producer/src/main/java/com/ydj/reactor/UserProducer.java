package com.ydj.reactor;

import com.ydj.common.activemq.producer.AbstractProducer;
import com.ydj.common.activemq.producer.ProducerConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

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
@Service("userProducer")
public class UserProducer extends AbstractProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    private static final String QUEUE_NAME = "user";

    private static final String THREAD_NAME = "userConnector";


    @Override
    protected ProducerConfigBean InitProducer() {
        return new ProducerConfigBean(QUEUE_NAME, THREAD_NAME, jmsTemplate);
    }
}
