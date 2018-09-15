package com.ydj.topic.config;

import com.ydj.topic.producer.TopicProducer;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile(value = "topic")
@Configuration
public class TopicConfig {

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
    public TopicProducer topicProducer() {
        return new TopicProducer();
    }

    /**
     * exchange
     * @return
     */
    @Bean
    public TopicExchange topic() {
        return new TopicExchange("topic");
    }

    private static class QueueConfig {
        /**
         * 队列1
         * @return
         */
        @Primary
        @Bean(name = "topicqueue1")
        public Queue topicqueue1() {
            return new Queue("topicqueue1");
        }

        /**
         * 队列2
         * @return
         */
        @Qualifier
        @Bean(name = "topicqueue2")
        public Queue topicqueue2() {
            return new Queue("topicqueue2");
        }

        @Bean
        public Binding binding1c(TopicExchange topic,
                                 @Qualifier("topicqueue1") Queue topicqueue1) {
            return BindingBuilder.bind(topicqueue1)
                    .to(topic)
                    .with("#.error");
        }

        @Bean
        public Binding binding1d(TopicExchange topic,
                                 @Qualifier("topicqueue2")Queue topicqueue2) {
            return BindingBuilder.bind(topicqueue2)
                    .to(topic)
                    .with("#.warning");
        }

    }

}
