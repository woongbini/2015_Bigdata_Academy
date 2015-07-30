package com.ensoa.order.service;

public interface OrderService {
	void purchaseOrder(Order order);
	List<order> getOrders(Customer customer);
	Order getOrder(long id);
	
}
