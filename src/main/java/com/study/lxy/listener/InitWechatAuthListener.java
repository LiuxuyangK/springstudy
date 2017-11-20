package com.study.lxy.listener;

import com.study.lxy.redis.RedisCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by Harry on 17/11/16.
 */
public class InitWechatAuthListener implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  private RedisCacheManager redisCacheManager;

  private static boolean isStart = false; // 防止二次调用

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    if (!isStart) {
      isStart = true;
      String token = "this is token";
      redisCacheManager.set("token", token, 3600); //1小时
    }
  }
}
