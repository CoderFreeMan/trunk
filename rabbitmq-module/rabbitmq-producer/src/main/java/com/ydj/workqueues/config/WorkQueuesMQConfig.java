package com.ydj.workqueues.config;

import com.ydj.hello.producer.RabbitMQProducer;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile(value = "workqueues")
@Configuration
public class WorkQueuesMQConfig {

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
     * 队列
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue("workqueues");
    }

    /**
     * 生产者
     * @return
     */
    @Bean
    public RabbitMQProducer rabbitMQProducer() {
        return new RabbitMQProducer();
    }

}
