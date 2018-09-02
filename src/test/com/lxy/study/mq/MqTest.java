package com.lxy.study.mq;

import com.study.lxy.mq.springdemo.MessageProducer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Harry on 17/11/13.
 */
public class MqTest extends BaseTest{

  @Autowired
  private MessageProducer messageProducer;

  @Test
  public void SendMessageTest(){
    messageProducer.sendMessage("这是我的消息");
  }

  @Test
  public void RecvMessageTest() throws InterruptedException {
    Thread.sleep(1000000000L);

  }
}

