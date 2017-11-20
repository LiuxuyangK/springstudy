package com.lxy.study.mq;

import com.study.lxy.dao.impl.UserDAOImpl;
import com.study.lxy.model.User;
import com.study.lxy.redis.RedisCacheManager;
import com.study.lxy.redis.client.RedisClientTemplate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Harry on 17/11/16.
 */
public class RedisTest extends BaseTest {

  @Autowired
  private RedisCacheManager redisCacheManager;

  @Autowired
  private UserDAOImpl userDAO;

  @Autowired
  private RedisClientTemplate redisClientTemplate;

  @Test
  public void RedisFirstTest() throws Exception {
    String key = "name";
    String name = "harry坎坎坷坷扩扩";
    redisCacheManager.set(key, name.getBytes("UTF-8"));
  }

  @Test
  public void UserRedis_SpringRedis_Test() {
    User user = new User();
    user.setAge(123);
    user.setId(234234);
    user.setArea("平遥");
    user.setLevel(123123);
    user.setName("我就是刘旭阳啊");
    userDAO.saveUser(user);

  }

  @Test
  public void redis_JedisPool_Test() {

    String key = "jedis_pool";
    String name = "harry坎坎坷坷扩扩";

    redisClientTemplate.set(key, name);
  }
}
