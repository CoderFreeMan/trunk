package com.ydj.rpc.controller;

import com.ydj.rpc.client.RPCClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping(value = "/rabbitmq/rpc")
public class RPCController {

    @Autowired
    private RPCClient rpcClient;

    @RequestMapping(value = "/test")
    public String send() {
        return rpcClient.send();
    }

}
