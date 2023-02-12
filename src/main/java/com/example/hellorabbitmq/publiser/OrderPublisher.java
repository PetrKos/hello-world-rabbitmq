package com.example.hellorabbitmq.publiser;

import com.example.hellorabbitmq.config.MessagingConfig;
import com.example.hellorabbitmq.dto.Order;
import com.example.hellorabbitmq.dto.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderPublisher {

  private final RabbitTemplate rabbitTemplate;

  @PostMapping("/{restaurantName}")
  public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
    order.setOrderId(UUID.randomUUID().toString());
    //some service call here
    OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully in " + restaurantName);
    rabbitTemplate.convertAndSend(MessagingConfig.SHIPPING_EXCHANGE,MessagingConfig.SHIPPING_ROUTING_KEY,orderStatus);
    return "success";
  }
}
