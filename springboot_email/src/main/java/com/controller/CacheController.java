package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cache.MyCacheManager;

import io.swagger.annotations.Api;

@Api(description="缓存刷新")
@Controller
public class CacheController {
	
	@Autowired
	private MyCacheManager myCacheManager;
	@GetMapping("/upd")
	@ResponseBody
	public void update(){
		myCacheManager.updateCache();
	}

}
