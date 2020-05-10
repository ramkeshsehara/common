package com.self.learning.pool.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.self.learning.pool.MqttThreadPoolExecutor;

@Configuration
public class ExecutorServiceConfig {

  @Bean(name="fixedThreadPool")
  public ExecutorService fixedThreadPool() {
    return Executors.newFixedThreadPool(5);
  }

  @Bean(name="singleThreaded")
  public ExecutorService singleThreadedExecutor() {
    return Executors.newSingleThreadExecutor();
  }

  @Bean(name="cachedThreadPool")
  public ExecutorService cachedThreadPool() {
    return Executors.newCachedThreadPool();
  }

  @Bean(name="customIoThreadPool")
  public ExecutorService customIoThreadPool() {
    return new MqttThreadPoolExecutor(10, 50, 600, TimeUnit.SECONDS, "io-Thread");
  }
}
