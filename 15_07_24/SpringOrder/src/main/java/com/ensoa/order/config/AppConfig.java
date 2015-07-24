package com.ensoa.order.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ensoa.order.service.CustomerService;
import com.ensoa.order.service.CustomerServiceImpl;

@Configuration //Configuration어노테이션은 클래스 위에 붙여준다.
public class AppConfig {
	
	@Bean //Bean어노테이션은 메소드 위에 붙여준다. 
	CustomerService customerService() {
		return new CustomerServiceImpl();
	}
	
}
