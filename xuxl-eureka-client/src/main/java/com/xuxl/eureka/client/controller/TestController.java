package com.xuxl.eureka.client.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

	Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@Value("${myname}")
	private String myname;
	
	@GetMapping("/dc")
	public String dc(){
		
		logger.info("-----------info eureka client 服务提供者--------------");
		String services = "Services: " + discoveryClient.getServices() + new Date().getTime();
		System.out.println(services);
		return services;
	}
	
	@RequestMapping("/index")
	public String index(){
		
		return "WelCome Dragon !";
	}
	
	@GetMapping("/add")
	public Integer add(@RequestParam Integer a,@RequestParam Integer b){
		
		return a+b;
	}
	
	@GetMapping("/stop")
	public String stop() throws InterruptedException{
		Thread.sleep(5000L);
		return "stop";
	}
	
	@GetMapping("/testConfigClient")
	public String testConfigClient(){
		return myname;
	}
}
