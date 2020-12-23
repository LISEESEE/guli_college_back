package jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {
    public static void main(String[] args) {
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis;
        jedis = jedisPool.getResource();
        jedis.set("aa","bb");
        JedisPoolUtil.release(jedisPool,jedis);

    }
}
