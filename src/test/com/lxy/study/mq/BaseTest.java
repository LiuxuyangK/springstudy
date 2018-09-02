package com.lxy.study.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Harry on 17/11/13.
 */

@RunWith(JUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:config/spring/spring*.xml","classpath*:config/spring/dis*.xml"})
@ContextConfiguration(locations = {"classpath:config/spring/spring*.xml"})
public class BaseTest {

  @Test
  public void testBase() {
    System.out.println("==========开始测试=============");
  }

}