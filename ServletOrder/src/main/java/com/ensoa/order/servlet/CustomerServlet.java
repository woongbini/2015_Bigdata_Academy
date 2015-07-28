package com.ensoa.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*만약 서블릿에서 DB설정을 읽어들여 처리해야 한다면 서블릿 컨텍스트의 초기파라미터를 사용할수 있다. 
컨테스트초기 파라미터는 web.xml서블릿 설정하거나 @webInitParam어노테이션으로 설정할수 있다*/
@WebServlet (
		name = "customerServlet", 
		urlPatterns={"/customer"}, 
		loadOnStartup=1, 
		initParams={
				@WebInitParam(name = "driverClassName", value = "com.mysql.jdbc.Driver"),
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/order_system"),
				@WebInitParam(name = "username", value = "root"),
				@WebInitParam(name = "password", value = "1234")
			}
		)

//현재 javaEE에서는 서블릿프로토콜이 HTTP만 지원하므로 서블릿 클래스가 HttpServelet클래스에서 파생하도록 하면 된다.
public class CustomerServlet extends HttpServlet {
	
	private String driverClassName = null;
	private String url = null;
	private String username = null;
	private String password = null;
	
	
	/*
	만약 서블릿에 서블릿메서드를 override(재정의)하지 않으면 http요청을 받아들이지 않게 되고, 
	이 경우에 http405상태, 즉 메서드가 허용되지 않음 에러로 응답하게 된다.
	이런 서블릿은 쓸모가 없으므로 customerservelet이 http get메서드 요청을 지원하도록 doGet()메서드를 재정의할수 있다.
	*/
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html> /n")
			.append("<html>\n")
			.append("<meta charset = utf-8/>\n")
			.append("<title> 고객 정보 입력 </title> /n")
			.append("</head> \n")
			.append("<body> \n")
			.append("<h3> 고객 정보 입력 </h3> \n")
			.append("<fieldset>\n")
			.append("<form action=\"customer\" method=\"POST\"> \n")
			.append("<label for = \"name\"> 이름 : </label> \n")
			.append("<input type =\"text\" name =\"name\" /> <br>\n")
			.append("<label for = \"address\"> 주소 : </label> \n")
			.append("<input type =\"text\" name =\"address\" /> <br>\n")
			.append("<label for = \"email\"> 이멜 : </label> \n")
			.append("<input type =\"text\" name =\"email\" /> <br>\n")
			.append("<input type=\"submit\" value=\"저장\"/> \n")
			.append("</form> \n")
			.append("</body> \n")
			.append("</html>");
	}
	
	/*이제 CustomerServelt은 http get 메서드 요청에 응답하여 응답 본문에 웹폼을 표시하는 html 웹페이지로
	응답을 반환한다. 한글을 출력하기 위해서는 utf-8로 인코딩해야한다. 다른 로우 레벨의 http요청과 응답의 
	세부적인 사항에 대해서는 걱정할 필요가 없다. 웹 컨테이너가 소켓으로부터 요청을 해석하여 헤더와 파라미터를 읽는
	작업을 대신해 줄것이다. 메서드가 반환되면 응답헤더와 몸체를 구성하고 소켓에 도로 쓰는 작업도 해주게 된다
	*/
	
	//서블릿이 생성된 후에 첫번째 요청을 받고 응답하기 전에 호출된다, 설정 파일을 읽거나, jdbc로 DB에 연결등등
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println(config.getServletName() + "서블릿이 시작되었습니다.");
		driverClassName = config.getInitParameter("driverClassName");
		url = config.getInitParameter("url");
		username = config.getInitParameter("username");
		password = config.getInitParameter("password");
	} 
	
	//서블릿이 요청 받을수 없을때, 웹app이 종료시나 웹컨테이너가 종료될때 사용
	@Override
	public void destroy() {
		System.out.println("서블릿이 종료되었습니다.");
	}
	
	//doGet() 요청에 대하여 표시된 웹 폼에서 각 항목의 값을 입력하고, 저장하면 doPost()가 요청된다
	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html> \n")
				.append("<html> \n")
				.append("<meta charset=utf-8/> \n")
				.append("<title> 고객 등록 정보 </title> \n")
				.append("<head> \n")
				.append("</head> \n")
				.append("<body> \n")
				.append("<h1> 고객 등록 정보 </h1> \n")
				.append("이름 : ").append(name).append("<br> \n")
				.append("주소 : ").append(address).append("<br> \n")
				.append("이멜 : ").append(email).append("<br> \n")
				.append("<p> \n")
				.append("<a href = \"customer\"> 고객 정보 입력 </a> \n")
				.append("</body> \n")
				.append("</html>");
	}
	
	/*
	doPost()에서는 요청 객체의 getParameter()를 호출하여 웹 폼에서 폼 파라미터로 전달한 name폼변수의 값을 읽어서 인사하는
	html을 응답 객체에 작성한다. getParamete()를 호출하기 전에 setCharacterEncoding을 호풀한다
	*/
	
	
}//class end


/*
@WebServlet(
		name="customerServlet",
		urlPatterns={"/customer"},
		loadOnStartup=1,
		initParams={
				@WebInitParam(name="driverClassName", 
					value="com.mysql.jdbc.Driver"),
				@WebInitParam(name="url", 
					value="jdbc:mysql://localhost:3306/order_system"),
				@WebInitParam(name="username", value="root"),
				@WebInitParam(name="password", value="1234")
		}
	)
public class CustomerServlet extends HttpServlet {
	private String driverClassName = null;
	private String url = null;
	private String username = null;
	private String password = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println(config.getServletName() + " �꽌釉붾┸�씠 �떆�옉�릺�뿀�뒿�땲�떎.");
		driverClassName = config.getInitParameter("driverClassName");
		url = config.getInitParameter("url");
		username = config.getInitParameter("username");
		password = config.getInitParameter("password");
	}
	@Override
	public void destroy() {
		System.out.println("�꽌釉붾┸�씠 醫낅즺�릺�뿀�뒿�땲�떎.");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>\n")
		  .append("<html>\n")
		  .append("<meta charset=utf-8/>\n")
		  .append("<title>怨좉컼 �젙蹂� �엯�젰</title>\n")
		  .append("</head>\n")
		  .append("<body>\n")
		  .append("<h3>怨좉컼 �젙蹂� �엯�젰</h3>\n")
		  .append("<fieldset>\n")		  
		  .append("<form action=\"customer\" method=\"POST\">\n")
		  .append("<label for=\"name\">�씠由� : </label>\n")		  
		  .append("<input type=\"text\" name=\"name\" /> <br>\n")
		  .append("<label for=\"address\">二쇱냼 : </label>\n")		  
		  .append("<input type=\"text\" name=\"address\" /> <br>\n")
		  .append("<label for=\"email\">�씠硫붿씪 : </label>\n")		  
		  .append("<input type=\"text\" name=\"email\" /> <br>\n")		  
		  .append("<input type=\"submit\" value=\"���옣\"/>\n")
		  .append( "</form>\n")
		  .append("</fieldset>\n")				  
		  .append("</body>\n")
		  .append("</html>");		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>\n")
			   .append("<html>\n")
			   .append("<meta charset=utf-8/>\n")
			   .append("<title>怨좉컼 �벑濡� �젙蹂�</title>\n")
			   .append("</head>\n")
			   .append("<body>\n")
			   .append("<h1>怨좉컼 �벑濡� �젙蹂�</h1>\n")
			   .append("�씠由� : ").append(name).append("<br>\n")
			   .append("二쇱냼 : ").append(address).append("<br>\n")
			   .append("�씠硫붿씪 : ").append(email).append("<br>\n")	
			   .append("<p>\n")			 	
			   .append("<a href=\"customer\">怨좉컼�젙蹂� �엯�젰</a>\n")		
			   .append("<h3>�뜲�씠�꽣踰좎씠�뒪 �꽕�젙</h3>\n")
			   .append("dirverClassName : " ).append(driverClassName).append("<br/>\n")
			   .append("url : ").append(url).append("<br/>\n")
			   .append("username : ").append(username).append("<br/>\n")
			   .append("password : ").append(password).append("<br/>\n")			   
			   .append("</body>\n")
			   .append("</html>");			
	}
}
*/