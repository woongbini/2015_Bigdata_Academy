package com.ensoa.order.controller.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ensoa.order.domain.Customer;
import com.ensoa.order.model.CustomerModel;
import com.ensoa.order.service.CustomerService;

/*컨트롤러 클래스로부터 @requestmapping 어노테이션 설정을 읽어 http요청을 처리할 핸들러를 찾아낸다
따라서 컨트롤러 클래스에는 다음과 같이 @Controller 어노테이션을 지정해야한다.
*/

@Controller
@RequestMapping(value="/")
//@RequestMapping(value={"edit.do", ""})
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="edit.do", method=RequestMethod.GET)
	public String edit(Model model) {
		CustomerModel customer = new CustomerModel();
		model.addAttribute("customer",customer);
		return "edit";
	}
	/*public ModelAndView edit() {
		ModelAndView model = new ModelAndView();
		CustomerModel customer = new CustomerModel();
		model.addObject("customer", customer);
		model.setViewName("edit");
		return model;
	} */
	
	@RequestMapping(value = "/edit.do", method = RequestMethod.POST)
	public String add(@ModelAttribute("customer") CustomerModel model) {
		try {
				customerService.saveCustomer(model.buildDomain());
		 	} catch(Exception e) {
	 			return "forward:/error.do";
		 	}
		return "result";
	}
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	@ModelAttribute("customers")
	public List<CustomerModel> list() {
		List<Customer> customers = customerService.getCustomers();
		List<CustomerModel> customerModels = convert(customers);
		return customerModels;
	}
	
	@RequestMapping(value = "/error.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String error(Model model) {
		return "error";
	}
	
	private List<CustomerModel> convert (List<Customer> customers) {
		List<CustomerModel> customerModels = new ArrayList <CustomerModel>();
		for(Customer customer : customers) {
				CustomerModel customerModel = new CustomerModel();
				customerModel.buildModel(customer);
				customerModels.add(customerModel);
		}
		return customerModels;
	}
	
}
