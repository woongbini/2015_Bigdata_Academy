package com.ensoa.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensoa.order.domain.Customer;

@WebServlet(
		name="customerServlet",
		urlPatterns={"/customer"},
		loadOnStartup=1
	)
public class CustomerServlet extends HttpServlet {
	private String driverClassName = null;
	private String url = null;
	private String username = null;
	private String password = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println(config.getServletName() + " º≠∫Ì∏¥¿Ã Ω√¿€!");
	}
	@Override
	public void destroy() {
		System.out.println("º≠∫Ì∏¥ ≥°¿ÃøË §–§–");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		List<Customer> customers = new ArrayList<Customer>();
		for(int i = 0; i < 10; ++i) {
			Customer customer = new Customer();
			customer.setName("¿Ã∏ß"+i);
			customer.setAddress("¡÷º“" + i);
			customer.setEmail("email"+i+"@gmail.com");
			customers.add(customer);
		}
		request.setAttribute("customers", customers);
		Customer customer = new Customer();
		customer.setName("±Ë∫Ì∏¥");
		customer.setAddress("ø¿«œ¿Ãµµ");
		customer.setEmail("wppngnistrljdf@jkdsfjkdf.com");
		request.setAttribute("customer", customer);
		String url = "customer";
		url += request.getParameter("action");
		url += ".jsp";
		request.getRequestDispatcher(url) .forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		Customer customer = new Customer();
		customer.setName(name);
		customer.setAddress(address);
		customer.setEmail(email);
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("result.jsp") .forward(request, response);
	}
}
