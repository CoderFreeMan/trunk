package com.ydj.rpc.config;

import com.ydj.rpc.client.RPCClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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
@Profile(value = "rpc")
@Configuration
public class RPCConfig {

    @Bean
    public RPCClient rpcClient() {
        return new RPCClient();
    }

}
