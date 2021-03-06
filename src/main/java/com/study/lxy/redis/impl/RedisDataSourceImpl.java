package com.study.lxy.redis.impl;

import com.study.lxy.redis.RedisDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by Harry on 17/11/17.
 */

@Component
public class RedisDataSourceImpl implements RedisDataSource {

  private static final Logger log = LoggerFactory.getLogger(RedisDataSourceImpl.class);

  @Autowired
  private ShardedJedisPool shardedJedisPool;

  @Override
  public ShardedJedis getRedisClient() {
    try {
      ShardedJedis shardJedis = shardedJedisPool.getResource();
      return shardJedis;
    } catch (Exception e) {
      log.error("getRedisClent error", e);
    }
    return null;
  }

  @Override
  public void returnResource(ShardedJedis shardedJedis) {
    shardedJedisPool.returnResource(shardedJedis);
  }

  @Override
  public void returnResource(ShardedJedis shardedJedis, boolean broken) {
    if (broken) {
      shardedJedisPool.returnBrokenResource(shardedJedis);
    } else {
      shardedJedisPool.returnResource(shardedJedis);
    }
  }
}
