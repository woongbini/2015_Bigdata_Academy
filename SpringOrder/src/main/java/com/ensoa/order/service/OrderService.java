package com.ensoa.order.service;

import java.util.List;

import com.ensoa.order.domain.Customer;
import com.ensoa.order.domain.Order;

public interface OrderService {
	void purchaseOrder(Order order);
	List<order> getOrders(Customer customer);
	Order getOrder(long id);
	
}
