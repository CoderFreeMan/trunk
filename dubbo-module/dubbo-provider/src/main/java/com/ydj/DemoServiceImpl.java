package com.ydj;

import com.alibaba.dubbo.rpc.RpcContext;
import com.ydj.entity.User;
import com.ydj.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p> Date             :2018/2/24 </p>
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
@Service(value = "demoService")
public class DemoServiceImpl implements DemoService {

    /**
     * log
     */
    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    public User sayHello(User user) {
        logger.info("消费者地址" + RpcContext.getContext().getRemoteAddress().toString());
        logger.info("本机地址" + RpcContext.getContext().getLocalAddress().toString());
        return user;

    }
}
