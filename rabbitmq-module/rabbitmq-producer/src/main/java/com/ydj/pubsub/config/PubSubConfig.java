package com.ydj.pubsub.config;

import com.ydj.pubsub.producer.PubSubProducer;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * <p> Date             :2018/9/15 </p>
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
@Profile(value = "pubsub")
@Configuration
public class PubSubConfig {

    /**
     * 连接工厂
     * @return
     */
    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("127.0.0.1", 5672);
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }

    /**
     * Producer(生产者)
     * @return
     */
    @Bean
    public PubSubProducer pubSubProducer() {
        return new PubSubProducer();
    }

    /**
     * 路由
     *
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 队列并绑定路由
     */
    private static class QueueConfig {

        /**
         * 队列1
         * @return
         */
        @Primary
        @Bean(name = "pubsubqueue1")
        public Queue autoDeleteQueue1() {
            return new Queue("pubsubqueue1");
        }

        /**
         * 队列2
         * @return
         */
        @Qualifier
        @Bean(name = "pubsubqueue2")
        public Queue autoDeleteQueue2() {
//            new AnonymousQueue(); // 匿名队列只能在同一个工程中被消费，不能够跨工程，跨工程会报一个被lock的错误，坑啊
            return new Queue("pubsubqueue2");
        }

        /**
         * 队列1绑定路由
         * @param fanout
         * @param autoDeleteQueue1
         * @return
         */
        @Bean
        public Binding binding1(FanoutExchange fanout,
                                @Qualifier("pubsubqueue1") Queue autoDeleteQueue1) {
            return BindingBuilder.bind(autoDeleteQueue1).to(fanout);
        }

        /**
         * 队列2绑定路由
         * @param fanout
         * @param autoDeleteQueue2
         * @return
         */
        @Bean
        public Binding binding2(FanoutExchange fanout,
                                @Qualifier("pubsubqueue2") Queue autoDeleteQueue2) {
            return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
        }

    }
}
