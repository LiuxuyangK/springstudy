package com.study.lxy.redis;

import redis.clients.jedis.ShardedJedis;

/**
 * Created by Harry on 17/11/17.
 */
public interface RedisDataSource {

  /**
   * 取得redis的客户端，可以执行命令了。
   * @return
   */
  ShardedJedis getRedisClient();

  /**
   * 将资源返还给pool
   * @param shardedJedis
   */
  void returnResource(ShardedJedis shardedJedis);

  /**
   * 出现异常后，将资源返还给pool （其实不需要第二个方法）
   * @param shardedJedis
   * @param broken
   */
  void returnResource(ShardedJedis shardedJedis, boolean broken);
}
