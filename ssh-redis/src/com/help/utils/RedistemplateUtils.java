package com.help.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;



public class RedistemplateUtils{

	private static Logger logger = LoggerFactory.getLogger(RedistemplateUtils.class); 
	protected RedisTemplate<String, Object> redisTemplate=new RedisTemplate<String,Object>();
/*	@Autowired
	public RedisTemplate<String, Object> redisTemplate;*/
	  /** 
     * 自动注入Redis连接实例对象线程池 
     */  
    
    private static JedisPool jedisPool =new JedisPool();
	
	private static RedistemplateUtils redistemplateUtils = new RedistemplateUtils();
	/**
	 * 设置redisTemplate
	 * 
	 * @param redisTemplate
	 *            the redisTemplate to set
	 */
	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
		
	}
	

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	/**
	 * 获取 RedisSerializer <br>
	 * ------------------------------<br>
	 */
	protected RedisSerializer<String> getRedisSerializer() {
		return redisTemplate.getStringSerializer();
	}
	
    /** 
     * 获取Jedis对象 
     * @return 
     */  
    public static Jedis getJedis(){  
        Jedis jedis = jedisPool.getResource();  
        
       // System.out.println(jedis);
        return jedis;  
    } 
	public static RedistemplateUtils getInstance() {
		return redistemplateUtils;
	}
	/**
	 * 返还到连接池
	 *
	 * @param pool
	 * @param jedis
	 */
    public static  void returnResource(Jedis  jedis){  
        if(jedis != null){  
            jedisPool.returnResource(jedis);  
        }  
    } 
    
    /** 
     * Jedis对象出异常的时候，回收Jedis对象资源 
     * @param jedis 
     */  
    public static  void returnBrokenResource(Jedis  jedis){  
        if(jedis != null){  
            jedisPool.returnBrokenResource(jedis);  
        }  
          
    } 
    
	/**
	 * 新增 <br>
	 * ------------------------------<br>
	 * 
	 * @param user
	 * @return
	 */
	
	public boolean redisadd(final String Key, final String value) {
		boolean result = false;
		if (Key != null && !"".equals(Key)) {
			result = redisTemplate.execute(new RedisCallback<Boolean>() {
				public Boolean doInRedis(RedisConnection connection)
						throws DataAccessException {
					RedisSerializer<String> serializer = getRedisSerializer();
					byte[] key = serializer.serialize(Key);
					byte[] name = serializer.serialize(value);
					return connection.setNX(key, name);
				}
			});
		}
		return result;
	}

	/**
	 * 批量新增
	 * ------------------------------<br>
	 *
	 * @param list
	 * @return
	 */
	
	public boolean redisadd(final List<Map<String, String>> list) {
		boolean result = false;
		if (list != null && list.size() > 0) {
			result = redisTemplate.execute(new RedisCallback<Boolean>() {
				public Boolean doInRedis(RedisConnection connection)
						throws DataAccessException {
					RedisSerializer<String> serializer = getRedisSerializer();
					for (Map<String, String> map : list) {
						for (Entry<String, String> m : map.entrySet()) {
							byte[] key = serializer.serialize(m.getKey());
							byte[] name = serializer.serialize(m.getValue());
							connection.setNX(key, name);
						}
					}
					return true;
				}
			}, false, true);
		}
		return result;
	}

	/**
	 * 删除 <br>
	 * ------------------------------<br>
	 * 
	 * @param key
	 */
	
	public void redisdelete(final String key) {
		if (key != null && !"".equals(key)) {
			List<String> list = new ArrayList<String>();
			list.add(key);
			redisdelete(list);
		}
	}

	/**
	 * 删除多个 <br>
	 * ------------------------------<br>
	 * 
	 * @param keys
	 */
	
	public void redisdelete(final List<String> keys) {
		if (keys != null && keys.size() > 0) {
			redisTemplate.execute(new RedisCallback<Boolean>() {
				public Boolean doInRedis(RedisConnection connection)
						throws DataAccessException {
					RedisSerializer<String> serializer = getRedisSerializer();
					for (String key : keys) {
						byte[] keyByte = serializer.serialize(key);
						connection.del(keyByte);
					}
					return true;
				}
			}, false, true);
		}
	}

	/**
	 * 修改 <br>
	 * ------------------------------<br>
	 * 
	 * @param user
	 * @return
	 */
	
	public boolean redisupdate(final String Key, final String value) {
		if (redisget(Key) == null) {
			throw new NullPointerException("数据行不存在, key = " + Key);
		}
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(Key);
				byte[] name = serializer.serialize(value);
				connection.set(key, name);
				return true;
			}
		});
		return result;
	}

	/**
	 * 通过key获取 <br>
	 * ------------------------------<br>
	 * 
	 * @param keyId
	 * @return
	 */
	
	public Map<String, String> redisget(final String keyId) {
		Map<String, String> result = new HashMap<String, String>();
		if(keyId != null && !"".equals(keyId)) {
			result = redisTemplate.execute(new RedisCallback<Map<String, String>>() {
				public Map<String, String> doInRedis(RedisConnection connection)
						throws DataAccessException {
					RedisSerializer<String> serializer = getRedisSerializer();
					byte[] key = serializer.serialize(keyId);
					byte[] value = connection.get(key);
					if (value == null) {
						return null;
					}
					String valueS = serializer.deserialize(value);
					Map<String, String> map = new HashMap<String, String>();
					map.put(keyId, valueS);
					return map;
				}
			});
		}
		return result;
	}
}