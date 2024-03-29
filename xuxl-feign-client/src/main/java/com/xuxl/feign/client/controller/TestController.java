package com.xuxl.feign.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xuxl.feign.client.service.EurekaClientInterface;
import com.xuxl.feign.client.util.RedisUtil;

@RestController
public class TestController {
	Logger logger = LoggerFactory.getLogger(TestController.class) ;

	@Autowired
	RestTemplate restTemplate;
	
	
	@Autowired
	EurekaClientInterface ii;
	
	@Autowired
	RedisUtil redisUtil;
	
	
	/** Ribbon服务消费者  使用url调用
	 * @return
	 */
	@RequestMapping("/byUrl")
	public String testDc(){
		logger.info("-----------info feign client 服务消费者--------------");
		return restTemplate.getForEntity("http://EUREKA-CLIENT/dc", String.class).getBody();
	}
	
	/**
	 * Feign消费者  使用接口方式调用
	 * @return
	 */
	@GetMapping("/byInterface")
	public Integer testAdd(){
		
		return ii.add(3, 9);
	}
	
	/**
	 * Redis get 
	 * @return
	 */
	@GetMapping("/getRedis")
	public String testGet(@RequestParam String key){
		
		Object o = redisUtil.get(key);
		return o!=null?o.toString():"";
	}
	
	/**
	 * Redis set 
	 * @return
	 */
	@GetMapping("/setRedis")
	public String testSet(@RequestParam String key,@RequestParam String value){
		
		redisUtil.set(key, value);
		Object o = redisUtil.get(key);
		return o!=null?o.toString():"";
	}
}
