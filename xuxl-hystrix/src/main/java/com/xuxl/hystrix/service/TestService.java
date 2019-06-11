package com.xuxl.hystrix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TestService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="fallback")
	public String test(){
		return restTemplate.getForObject("http://EUREKA-CLIENT/stop",String.class);
	}
	
	@HystrixCommand(fallbackMethod="fallback")
	public String test1(){
		return restTemplate.getForObject("http://EUREKA-CLIENT/stop",String.class);
	}
	
	public String fallback(){
		return "fallback";
	}
}
