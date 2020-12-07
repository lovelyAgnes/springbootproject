package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;
import com.service.query.UserQuery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="test",description="user操作")
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;
	
	@ApiOperation(notes="查询user", value = "queryUserById")
	//@RequestParam  当getMapping请求路径queryUserById和方法名相同时，请求参数可以不加注解获取
	@GetMapping("/queryUserById")
	public User queryUserById( String id){
		System.out.println(id);
		return userService.queryById(Integer.valueOf(id));
	}
	
	@ApiOperation(notes="查询users", value = "queryUser")
	@PostMapping("/queryUser")
	public List<User> queryUser(@RequestBody UserQuery userQuery){
		return userService.queryUser(userQuery);
	}
	
	@ApiOperation(notes="查询所有user", value = "queryAll")
	@GetMapping("/queryAll")
	public List<User> queryAll(){
		return userService.queryUsers();
	}
	
	@ApiOperation(notes="创建user", value = "add")
	@PostMapping("/addUser")
	@ResponseStatus(HttpStatus.CREATED)
	public User add(@RequestBody User user) throws Exception{
		return userService.addUser(user);
	}
	
	@ApiOperation(notes="删除user", value = "delete")
	@PostMapping("/del")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@RequestBody User user){
		 userService.deleteUser(user);
	}

}
