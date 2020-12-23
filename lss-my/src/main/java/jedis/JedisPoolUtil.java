package jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
    private static volatile JedisPool jedisPool = null;

    public JedisPoolUtil() {}
    static JedisPool getJedisPoolInstance(){
        if (null == jedisPool){
            synchronized (JedisPoolUtil.class){
                if (null == jedisPool){
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    poolConfig.setMaxWaitMillis(1000);
                    poolConfig.setMaxIdle(32);
                    poolConfig.setTestOnBorrow(true);
                    jedisPool = new JedisPool(poolConfig,"192.168.1.51",6379);
                }
            }
        }
        return jedisPool;
    }
    static void release(JedisPool jedisPool, Jedis jedis){
        if (null != jedis){
            jedisPool.close();
        }
    }
}
