package com.ydj.rpc.client;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * <p> Date             :2018/9/16 </p>
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
@Service
public class RPCClient {

    @Autowired
    private RabbitTemplate template;

    public String  send() {
       return (String) this.template.convertSendAndReceive("serverclient", "rpc", "rabbitmq rpc test");
    }

}
