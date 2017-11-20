package com.study.lxy.mq.springdemo;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Harry on 17/11/13.
 */

@Component
public class MessageProducer {
  private Logger logger = LoggerFactory.getLogger(MessageProducer.class);

  @Resource
  private AmqpTemplate amqpTemplate;

  public void sendMessage(Object message){
    logger.info("to send message:{}",message);
    amqpTemplate.convertAndSend("queueTestKey",message);
  }
}
