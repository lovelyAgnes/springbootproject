package com.cache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dao.UserRepository;
import com.entity.User;
import com.service.UserService;
import com.util.CacheUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class MyCacheManager implements ApplicationRunner{
	@Resource
	private UserRepository userRepository;
	
	@Scheduled(cron = "0/59 * * * * ?")
	public void updateCache(){
		log.info("-------开始刷新缓存-------");
		CacheUtil cacheUtil = CacheUtil.getInstance();
		if(! cacheUtil.getMapCache().isEmpty()){
			cacheUtil.getMapCache().clear();
		}
		List<User> userlist = userRepository.findAll();
		userlist.forEach(k->{
			cacheUtil.putMapCache(String.valueOf(k.getId()), k);
		});
		
		log.info("-------刷新缓存结束-------更新了"+cacheUtil.getMapCache().size()+"条");
		
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		updateCache();
		
	}
	

}
