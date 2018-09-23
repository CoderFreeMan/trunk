package com.ydj.consumer.userConsumer;

import com.ydj.common.activemq.listener.AbstractJMSObjectMsgListener;
import com.ydj.entity.User;
import org.springframework.stereotype.Component;

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
@Component(value = "userConsumer")
public class UserConsumer extends AbstractJMSObjectMsgListener {

    @Override
    public void doService(Serializable serializable) throws Exception {
        User user = (User) serializable;
        System.out.println(user.toString());
    }


}
