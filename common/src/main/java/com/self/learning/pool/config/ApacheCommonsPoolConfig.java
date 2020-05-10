package com.self.learning.pool.config;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hivemq.client.mqtt.mqtt5.Mqtt5Client;
import com.paytm.iot.mqttpool.MqttClientFactory;;

@Configuration
public class ApacheCommonsPoolConfig {

    @Autowired
    private MqttClientFactory factory;

    @Bean(name="genericConnectionPool")
    public GenericObjectPool<Mqtt5Client> fixedThreadPool() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();

        config.setMaxTotal(15);
        config.setBlockWhenExhausted(true);
        config.setMaxWaitMillis(300 * 1000);
        return  new GenericObjectPool<>(factory, config);
    }
}
