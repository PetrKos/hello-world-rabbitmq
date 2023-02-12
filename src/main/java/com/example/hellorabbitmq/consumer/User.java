package com.example.hellorabbitmq.consumer;

import com.example.hellorabbitmq.config.MessagingConfig;
import com.example.hellorabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//can be a separate application/service just a demo here.
@Component
public class User {
  @RabbitListener(queues = MessagingConfig.SHIPPING_QUEUE)
  public void consumeMessageFromQueue(OrderStatus orderStatus) {
    System.out.println("Message received from queue: " + orderStatus);
  }
}
