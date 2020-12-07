package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.EmailService;

@Controller
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/sendEmail2")
	@ResponseBody
	public String sendEmail2(){
		emailService.sendEmail2("2760485622@qq.com", "测试邮件", "测试邮件");
		return "send email success! 02";
	}
}
