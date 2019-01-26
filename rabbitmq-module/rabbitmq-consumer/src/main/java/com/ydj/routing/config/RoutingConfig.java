package com.ydj.routing.config;

import com.ydj.pubsub.consumer.PubSubConsumer01;
import com.ydj.pubsub.consumer.PubSubConsumer02;
import com.ydj.routing.consumer.RoutingConsumer01;
import com.ydj.routing.consumer.RoutingConsumer02;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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
@Profile(value = "routing")
@Configuration
public class RoutingConfig {

    /**
     * 连接工厂
     *
     * @return
     */

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("127.0.0.1", 5672);
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }

    private static class RoutingRev {
        @Bean
        public RoutingConsumer01 routingConsumer01() {
            return new RoutingConsumer01();
        }

        @Bean
        public RoutingConsumer02 routingConsumer02() {
            return new RoutingConsumer02();
        }
    }

}
