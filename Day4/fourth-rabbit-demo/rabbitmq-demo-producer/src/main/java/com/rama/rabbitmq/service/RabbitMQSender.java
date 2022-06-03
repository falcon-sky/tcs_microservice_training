package com.rama.rabbitmq.service;

import com.rama.rabbitmq.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
  @Autowired
  private AmqpTemplate rabbitTemplate;

  @Value("${rabbitmq.exchange.name}")
  private String exchange;

  @Value("${rabbitmq.routingkey.name}")
  private String routingkey;

  public void send(Employee company) {
    rabbitTemplate.convertAndSend(exchange, routingkey, company);
    System.out.println("Send msg = " + company);

  }

  @RabbitListener(queues = "${rabbitmq.queue.name}")
  public void recievedMessage(Employee employee) {
    System.out.println("Recieved Message From RabbitMQ: " + employee);
  }

}
