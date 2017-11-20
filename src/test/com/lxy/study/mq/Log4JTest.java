package com.lxy.study.mq;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by Harry on 17/11/15.
 */
public class Log4JTest extends BaseTest{

  private static final Logger logger = Logger.getLogger(Log4JTest.class);

  @Test
  public void printTest(){
    logger.debug("debug");
    logger.info("info");
    logger.warn("warn");
    logger.error("error");

    System.out.println("sdfsf");
  }

}
