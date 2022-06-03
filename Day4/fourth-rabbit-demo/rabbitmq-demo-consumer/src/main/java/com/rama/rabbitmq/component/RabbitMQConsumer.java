package com.rama.rabbitmq.component;

import com.rama.rabbitmq.model.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

  /*
  If you are using boot, you can simply add a Jackson2JsonMessageConverter
  @Bean to the configuration and it will be automatically wired into the listener (
   */
  @Bean
  public Jackson2JsonMessageConverter converter() {
    return new Jackson2JsonMessageConverter();
  }

  public void send(Employee company) {
    rabbitTemplate.convertAndSend(exchange, routingkey, company);
    System.out.println("Send msg = " + company);

  }

  @RabbitListener(queues = "${rabbitmq.queue.name}")
  public void recievedMessage(Employee employee) {
    System.out.println("Recieved Message From RabbitMQ: " + employee);
  }
}
