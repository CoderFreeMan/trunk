package com.ydj.config;

import com.sun.jndi.ldap.pool.PooledConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * <p> Date             :2018/9/22 </p>
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
//@Profile(value = "activemqconfig")
//@Configuration
//@PropertySource(value = {"classpath:properties/activemq.properties"})
//@ConfigurationProperties(prefix = "activemq")
public class ActiveMQConfig {

    /*@Value(value = "${activemq.brokerURL}")
    private String brokerURL;

    @Value(value = "${activemq.userName}")
    private String userName;

    @Value(value = "${activemq.password}")
    private String password;

    @Value(value = "${activemq.maximumRedeliveries}")
    private Integer maximumRedeliveries;

    @Value(value = "${activemq.initialRedeliveryDelay}")
    private Long initialRedeliveryDelay;

    @Value(value = "${activemq.backOffMultiplier}")
    private Double backOffMultiplier;

    @Value(value = "${activemq.maximumRedeliveryDelay}")
    private Long maximumRedeliveryDelay;*/

    /**
     * activemq 连接工厂
     * @return
     */
    /*@Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(RedeliveryPolicy redeliveryPolicy) {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerURL);
        activeMQConnectionFactory.setUserName(userName);
        activeMQConnectionFactory.setPassword(password);
        activeMQConnectionFactory.setObjectMessageSerializationDefered(true);
        activeMQConnectionFactory.setTrustAllPackages(true);
        // @TODO 重发机制
        activeMQConnectionFactory.setRedeliveryPolicy(redeliveryPolicy);
        return activeMQConnectionFactory;
    }*/

    /**
     * 重发机制
     * @return
     */
    /*@Bean(value = "redeliveryPolicy")
    public RedeliveryPolicy redeliveryPolicy() {
        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
        redeliveryPolicy.setUseExponentialBackOff(true);
        redeliveryPolicy.setMaximumRedeliveries(maximumRedeliveries);
        redeliveryPolicy.setInitialRedeliveryDelay(initialRedeliveryDelay);
        redeliveryPolicy.setBackOffMultiplier(backOffMultiplier);
        redeliveryPolicy.setMaximumRedeliveryDelay(maximumRedeliveryDelay);
        return redeliveryPolicy;
    }*/

}
