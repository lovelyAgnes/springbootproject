package com.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.entity.User;


public class CacheUtil {
	
	private volatile static CacheUtil mapCacheObject;// 缓存实例对象
	
	private static Map<String,User> map = new ConcurrentHashMap<String,User>();
	
	/**
     * 采用单例模式获取缓存对象实例
     * 
     * @return
     */
    public static CacheUtil getInstance() {
        if (null == mapCacheObject) {
            synchronized (CacheUtil.class) {
                if (null == mapCacheObject) {
                    mapCacheObject = new CacheUtil();
                }
            }
        }
        return mapCacheObject;
    }
	
	public void putMapCache(String key, User value){
		map.put(key, value);
	}
	
	public Map<String,User> getMapCache(){
		return this.map;
	}
	
	public User get(String key){
		return map.get(key);
	}

}
