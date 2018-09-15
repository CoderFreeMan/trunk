package com.ydj.rpc.rpcserver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

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
public class RPCServer {

    @RabbitListener(queues = {"rpcqueue"})
    public String in(String message) {
        return message;
    }

}
