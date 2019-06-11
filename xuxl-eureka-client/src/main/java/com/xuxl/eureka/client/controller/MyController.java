package com.xuxl.eureka.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	
	
	@RequestMapping("/my")
	@ResponseBody
	public String index(){
		
		return "WelCome Dragon !";
	}
	
}
