package com.self.learning.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hivemq.client.mqtt.mqtt5.Mqtt5Client;

@Component
public class MqttClientFactory extends BasePooledObjectFactory<Mqtt5Client> {

  static String host;

  @Value("${vernemq.host}")
  public void setHost(String value) {
    this.host = value;
  }

  @Override
  public Mqtt5Client create() throws Exception {
    Mqtt5Client client = Mqtt5Client.builder().serverHost(host).build();
    client.toBlocking().connect();
    return client;
  }

  @Override
  public PooledObject<Mqtt5Client> wrap(Mqtt5Client mqttClient) {
    return new DefaultPooledObject<>(mqttClient);
  }

  @Override
  public boolean validateObject(PooledObject<Mqtt5Client> p) {
    System.out.println("Validated by" + Thread.currentThread().getName());
    return p.getObject().getState().isConnected();
  }

  @Override
  public void activateObject(PooledObject<Mqtt5Client> p) throws Exception {
    super.activateObject(p);
  }

  @Override
  public void passivateObject(PooledObject<Mqtt5Client> p) throws Exception {
    super.passivateObject(p);
  }
}
