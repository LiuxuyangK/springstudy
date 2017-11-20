package com.study.lxy.log4j;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by Harry on 17/11/15.
 */

public class Log4JTest {

  public static void main(String[] args) {
//    Logger logger = LoggerFactory.getLogger(Log4JTest.class);
//
//    logger.
//    BasicConfigurator.configure();
//
//    logger.debug("debug");
//    logger.info("info");
//    logger.warn("warn");
//    logger.error("error");


    final Logger logger = Logger.getLogger(Log4JTest.class);
    //使用默认的配置信息，不需要写log4j.properties
//    BasicConfigurator.configure();
//    //设置日志输出级别为info，这将覆盖配置文件中设置的级别
//    logger.setLevel(Level.INFO);

    logger.debug("debug");
    logger.info("info");
    logger.warn("warn");
    logger.error("error");
  }

}
