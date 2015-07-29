package com.ensoa.order.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ensoa.order.config.AppConfig;
import com.ensoa.order.domain.Customer;
import com.ensoa.order.service.CustomerService;

public class Main {

	public static void main(String[] args) {
		//ApplicationContext ctx  = new ClassPathXmlApplicationContext("beans.xml"); //IOC컨테이너, 애플리케이션 컨텍스트를 생성하는 가장 일반적인 방법
		//ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/beans.xml"); //파일 시스템의 절대 경로 또는 상대 경로로 설정 파일을 지정할때
		ApplicationContext ctx = new AnnotationConfigApplicationContext("src/main/java/beans.xml");
		
		CustomerService customerService = (CustomerService)ctx.getBean("customerService");
		
		List<Customer> customers = customerService.getCustomers();
		for(Customer customer : customers) {
			System.out.println(customer);
		}
		
		customers = customerService.getCustomersByPage(3, 5);
		for(Customer customer : customers) {
			System.out.println(customer);
		}
		
		Customer customer = customerService.getCustomer(1);
		System.out.println(customer);
		
		customer = new Customer();
		customer.setId(1);
		customer.setName("김웅빈");
		customer.setEmail("woongnistelrooy@hanmail.net");
		customerService.saveCustomer(customer);
		
		customer.setName("이구역");
		customerService.updateCustomer(customer);
		customerService.deleteCustomer(1);
		
	}
}
