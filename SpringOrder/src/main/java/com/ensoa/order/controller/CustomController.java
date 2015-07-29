package com.ensoa.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.ensoa.order.model.CustomerModel;

@Controller
//@RequestMapping(value="/")
public class CustomController {
	
	@RequestMapping(value="edit.do", method=RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView model = new ModelAndView();
		CustomerModel customer = new CustomerModel();
		model.addObject("customer", customer);
		model.setViewName("edit");
		return model;
	}
	
}
