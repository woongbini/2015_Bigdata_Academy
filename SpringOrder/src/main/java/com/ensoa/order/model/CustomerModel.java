package com.ensoa.order.model;

import com.ensoa.order.domain.Customer;

/*������Ŭ������ ���� ��� �Ǵ� dto�μ��� ������ �ϸ�, ����Ƽ Ŭ������ ���߿� ���캸�Ե� or���ο� ���ȴ�
�׸��� �� Ŭ������ �信 ���� �����͸� ǥ���ϴµ� ���ȴ�. 
*/

public class CustomerModel {
	private long id;
	private String name;
	private String address;
	private String email;
	
	public long getId() {	return id;	}
	public void setId(long id) {	this.id = id;	}
	public String getName() {	return name;	}
	public void setName(String name) {	this.name = name;	}
	public String getAddress() {	return address;	}
	public void setAddress(String address) {	this.address = address;	}
	public String getEmail() {	return email;	}
	public void setEmail(String email) {	this.email = email;	}
	
	public String toString() {
		return "id : " + id + ", name : " + name + ", address : " + address + ", email : " + email;
		//return "name : " + name + ", address : " + address + ", email : " + email;
	}
	
	public Customer buildDomain() {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setAddress(address);
		customer.setEmail(email);
		return customer;
	}
	
	public void buildModel(Customer customer) {
		id = customer.getId();
		name = customer.getName();
		address = customer.getAddress();
		email = customer.getEmail();
	}
	
	/*CustomerModel.java������ CustomerEntity.java�� �����ϰ� �ڽ��� �� Ŭ���� �ν��Ͻ��κ��� ������ Ŭ������
	�ν��Ͻ��� �����ϴ� buildDomain()�� ������ Ŭ���� �ν��Ͻ��κ��� �ڽ��� �� Ŭ���� �ν��Ͻ��� �����ϴ�
	buildDomain()�� ���Եȴ�. 
	�� ��ü �Ǵ� �÷����� jsp���� ��Ʈ�ѷ��� ��û �ڵ鷯 �޼��忡 �� ��Ʈ����Ʈ�� �Ű� ������ ���޵Ǿ�
	���� ������ ó���ϴµ� ���Ǹ�, ��û �ڵ鷯 �޼���κ��� ���ϵɶ� �� ��Ʈ����Ʈ�� ���ԵǾ� jsp���� 
	�並 �������Ҷ� ���ȴ�.
	*/
	
}
