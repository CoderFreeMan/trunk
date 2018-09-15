package com.ydj.rpc.config;

import com.ydj.rpc.rpcserver.RPCServer;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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
    public Queue rpcQueue() {
        return new Queue("rpcqueue");
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("serverclient");
    }

    @Bean
    public Binding binding(DirectExchange exchange, Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("rpc");
    }

    @Bean
    public RPCServer server() {
        return new RPCServer();
    }
}
