package com.ydj.routing.config;

import com.ydj.routing.producer.RoutingProducer;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile(value = "routing")
@Configuration
public class RoutingConfig {

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
     * producer
     * @return
     */
    @Bean
    public RoutingProducer routingProducer() {
        return new RoutingProducer();
    }

    /**
     * exchange
     * @return
     */
    @Bean
    public DirectExchange direct() {
        return new DirectExchange("routingExchange");
    }

    private static class QueueConfig {
        /**
         * 队列1
         * @return
         */
        @Primary
        @Bean(name = "routingqueue1")
        public Queue routingqueue1() {
            return new Queue("routingqueue1");
        }

        /**
         * 队列2
         * @return
         */
        @Qualifier
        @Bean(name = "routingqueue2")
        public Queue routingqueue2() {
            return new Queue("routingqueue2");
        }

        @Bean
        public Binding binding1a(DirectExchange direct,
                                 @Qualifier("routingqueue1") Queue routingqueue1) {
            return BindingBuilder.bind(routingqueue1)
                    .to(direct)
                    .with("error");
        }

        @Bean
        public Binding binding1b(DirectExchange direct,
                                 @Qualifier("routingqueue2")Queue routingqueue2) {
            return BindingBuilder.bind(routingqueue2)
                    .to(direct)
                    .with("warning");
        }

    }

}
