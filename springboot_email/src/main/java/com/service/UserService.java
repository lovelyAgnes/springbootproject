package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.cache.MyCacheManager;
import com.dao.UserRepository;
import com.entity.User;
import com.service.query.UserQuery;
import com.util.CacheUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	private Example example;
	
	public List<User> queryUsers(){
		List<User> userList=userRepository.findAll();
		return userList;
	}
	/**
	 * //条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                                        .withMatcher("tag",ExampleMatcher.GenericPropertyMatchers.contains())
                                        .withMatcher("fileOriginalName",ExampleMatcher.GenericPropertyMatchers.contains());
		//                                        .withMatcher("processStatus",ExampleMatcher.GenericPropertyMatchers.exact());//如果不设置匹配器默认精确匹配

        //定义example条件对象
        Example<MediaFile> example = Example.of(mediaFile,exampleMatcher);

	 */
	
	public List<User> queryUser(UserQuery userQuery){
		User user = new User();
		BeanUtils.copyProperties(userQuery, user);
		
		example = Example.of(user);
		List<User> userList=userRepository.findAll(example);
		return userList;
	}
	
	public User queryById(Integer id){
		User user = null;
		CacheUtil cacheManager = CacheUtil.getInstance();
//		Map<String,User> map = cacheManager.getMapCache();
		
		if(cacheManager.getMapCache().containsKey(id)){
			log.info("从缓存中获取到了");
			user = cacheManager.get(String.valueOf(id));
		}
		else{
			log.info("从数据库中获取");
			user=userRepository.findById(id).get();
		}
		
		return user;
	}
	public User addUser(User user) throws Exception{
		if(null == user){
			throw new Exception("null");
		}
		return userRepository.saveAndFlush(user);
	}
	public void deleteUser(User user){
		userRepository.findById(user.getId()).ifPresent(k->{
			userRepository.delete(k);
		});
		
	}

}
