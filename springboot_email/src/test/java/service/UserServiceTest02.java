package com.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.entity.User;
import com.util.CacheUtil;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import mockit.Mock;
import mockit.MockUp;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest02 {
	@Autowired
	private UserService userService;
	
	private User usercre;
	/**
	 * 每次启动都先执行这个方法，然后创建对象，设置
	 */
	@Before
	public final void createUser(){
		usercre = new User();
		usercre.setId(1);
		usercre.setAge(22);
		usercre.setName("唐代并");
		usercre.setSex("男");
	}
	@Test
    public void testQuery() {
		final User user = usercre;
		final Map<String,User> map = new HashMap();
    	map.put("1", user);
		new MockUp<CacheUtil>() {
            @Mock
            public Map<String,User> getMapCache(){
        		return map;
        	}
        };
		User user2 = userService.queryById(1);
		TestCase.assertEquals(22, user2.getAge());
        
    }

}
