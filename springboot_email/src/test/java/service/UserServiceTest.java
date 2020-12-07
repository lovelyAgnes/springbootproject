package com.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.entity.User;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {
	@Autowired
	private UserService userService;
	private User usercre;
	/**
	 * 每次启动都先执行这个方法，然后创建对象，设置
	 */
	@Before
	public final void createUser(){
		usercre = new User();
		usercre.setAge(22);
		usercre.setName("唐代并");
		usercre.setSex("男");
	}
	@Test
    public void testAdd() throws Exception {
		
		User user2 = userService.addUser(usercre);
        log.info(user2.getName());
        TestCase.assertEquals(22, user2.getAge());
    }
	
	@Test(expected=Exception.class)
    public void testAdd02() throws Exception {
		User user = null;
		User user2 = userService.addUser(user);
        
    }
	
	
	

}
