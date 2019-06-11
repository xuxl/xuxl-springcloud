package com.xuxl.feign.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-client")
public interface EurekaClientInterface {

	@RequestMapping(method=RequestMethod.GET,value="/add")
	Integer add(@RequestParam(value="a")Integer a ,@RequestParam(value="b")Integer b);
}
