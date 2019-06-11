package com.xuxl.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xuxl.hystrix.service.TestService;

@RestController
public class TestController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	TestService testService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(){
		return testService.test();
	}
	
	@RequestMapping(value="/test1",method=RequestMethod.GET)
	public String test1(){
		return testService.test1();
	}
	
	@RequestMapping(value="/test2",method=RequestMethod.GET)
	public String test2(){
		return restTemplate.getForObject("http://EUREKA-CLIENT/stop", String.class);
	}
	
	@RequestMapping(value="/ttt",method=RequestMethod.GET)
	public String ttt(){
		return "ttt";
	}
}
