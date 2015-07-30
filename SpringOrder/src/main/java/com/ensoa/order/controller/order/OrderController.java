package com.ensoa.order.controller.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ensoa.order.domain.Product;
import com.ensoa.order.model.CustomerModel;
import com.ensoa.order.model.OrderItemModel;
import com.ensoa.order.model.OrderModel;
import com.ensoa.order.model.ProductModel;
import com.ensoa.order.service.OrderService;
import com.ensoa.order.service.ProductService;

@Controller
@RequestMapping(value="/")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}
	
	@RequestMapping(value="create.do", method=RequestMethod.GET)
	public String createOrder(Model model) {
			List<Product> products = productService.getProducts();
			List<ProductModel> productModels = convert(products);
			OrderModel order = new OrderModel();
			customer.setId(1);
			customer.setName("±è¿Ã");
			customer.setAddress("°æ±â");
			customer.setEmail("wsjdk@sdkjd.com");
			order.setCustomer(customer);
			order
			
			
	}
}
