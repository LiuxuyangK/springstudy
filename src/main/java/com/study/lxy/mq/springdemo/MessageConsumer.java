package com.study.lxy.mq.springdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;


/**
 * Created by Harry on 17/11/12.
 */

public class MessageConsumer implements MessageListener {

  private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

  @Override
  public void onMessage(Message message) {

    System.out.println("--------收到了收到了啊！！" + message);
    logger.info("receive message:{}", message);

    String s = null;
    try {
      s = new String(message.getBody(), "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    System.out.println(s);
  }

}