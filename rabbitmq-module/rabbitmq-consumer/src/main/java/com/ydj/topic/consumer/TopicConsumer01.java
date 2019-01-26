package com.ydj.topic.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * <p> Date             :2018/9/14 </p>
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

public class TopicConsumer01 {

    @RabbitListener(queues = "topicqueue1")
    public void test(String message) {
        System.out.println(message);
    }

}
