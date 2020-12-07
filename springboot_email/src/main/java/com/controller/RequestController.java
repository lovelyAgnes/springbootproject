package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.config.RequestParamAnnotation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="Request",description="测试注解类")//value不生效
public class RequestController {
	
	@GetMapping("/reqTest")
	@RequestParamAnnotation(describe="测试注解")
	@ApiOperation(value = "reqTest")
	public String reqTest(@RequestParam String name){
		return "hhhh";
	}
	

}
