package com.example.hellorabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

  //Better move these in a properties files.
  //keep them here for demo purpose.
  public static final String SHIPPING_QUEUE = "shipping_queue";
  public static final String SHIPPING_EXCHANGE = "shipping_exchange";
  public static final String SHIPPING_ROUTING_KEY = "shipping_routing_key";

  @Bean
  public Queue queue() {
    return new Queue(SHIPPING_QUEUE);
  }

  @Bean
  public TopicExchange exchange() {
    return new TopicExchange(SHIPPING_EXCHANGE);
  }

  @Bean
  public Binding binding(Queue queue, TopicExchange topicExchange) {
    return BindingBuilder.bind(queue()).to(exchange()).with(SHIPPING_ROUTING_KEY);
  }

  @Bean
  public MessageConverter converter() {
    return new Jackson2JsonMessageConverter();
  }

  /**
   * we publish the event or publish the message to queue and we can consume it
   * @param connectionFactory
   * @return
   */
  @Bean
  public AmqpTemplate template(ConnectionFactory connectionFactory) {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(converter());
    return rabbitTemplate;
  }

}
