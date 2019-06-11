package com.xuxl.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.xuxl.zuul.filter.AccessTokenFilter;
import com.xuxl.zuul.filter.AccessTokenFilter1;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) {

		SpringApplication.run(ZuulApplication.class, args);
	}
	
	@Bean
	public AccessTokenFilter accessTokenFilter(){
		return new AccessTokenFilter();
	}
	
	@Bean
	public AccessTokenFilter1 accessTokenFilter1(){
		return new AccessTokenFilter1();
	}

}
