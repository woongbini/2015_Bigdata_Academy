package com.ensoa.order.model;

import com.ensoa.order.domain.Customer;

/*도메인클래스는 서비스 계약 또는 dto로서의 역할을 하며, 엔터티 클래스는 나중에 살펴보게될 or매핑에 사용된다
그리고 모델 클래스는 뷰에 사용될 데이터를 표현하는데 사용된다. 
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
	
	/*CustomerModel.java에서는 CustomerEntity.java와 유사하게 자신의 모델 클래스 인스턴스로부터 도메인 클래스의
	인스턴스를 생성하는 buildDomain()와 도메인 클래스 인스턴스로부터 자신의 모델 클래스 인스턴스를 생성하는
	buildDomain()가 포함된다. 
	모델 객체 또는 컬렉션은 jsp에서 컨트롤러의 요청 핸들러 메서드에 모델 애트리뷰트로 매개 변수에 전달되어
	업무 로직을 처리하는데 사용되며, 요청 핸들러 메서드로부터 리턴될때 모델 애트리뷰트에 포함되어 jsp에서 
	뷰를 랜더링할때 사용된다.
	*/
	
}
