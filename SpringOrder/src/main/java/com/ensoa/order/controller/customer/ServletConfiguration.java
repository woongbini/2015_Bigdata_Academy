package com.ensoa.order.controller.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class ServletConfiguration extends WebMvcConfigurationSupport {
	
	
	@Bean
	public ViewResolver beanNameViewResolver() {
			BeanNameViewResolver viewResolver = new BeanNameViewResolver();
			viewResolver.setOrder(1);
			return viewResolver;
	}
	
	@Bean
	public View edit() {
			JstlView view = new JstlView();
			view.setUrl("/WEB-INF/views/product/edit.jsp");
			return view;
	}
	
	@Bean
	public View list() {
			JstlView view = new JstlView();
			view.setUrl("/WEB-INF/views/product/lsit.jsp");
			return view;
	}
}
