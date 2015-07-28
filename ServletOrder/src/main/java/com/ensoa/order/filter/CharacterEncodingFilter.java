package com.ensoa.order.filter;

import java.io.IOException;
import java.time.Instant;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*필터는 리소스에 대한 요청과 리소스로부터의 응답을 가로채서 요청과 응답에 대하여 어떤 행위를 수행하는것을 말한다. 
필터는 요청과 응답을 검사해서 변경시킬수 있으며, 요청을 거부하거나 다른 url로 이동 또는 전송할수도 있다.
서블릿과 마찬가지로 필터는 배포디스크립터/어노테이션을 사용해 선언될수 있고, 초기 파라미터를 가질수도있고
서블릿컨텍스트에 접근할수도 있다. 
*/

/*JavaEE 웹app 구현시 힘든건, 한글사용(파라미터 읽을때마다 디코딩해야됨)
그래서 문자를 인코딩하는 CharacterEncodingFilter class를 구현하자.*/
public class CharacterEncodingFilter implements Filter {
	
	private String encoding = null;
	
	//매개변수로 전달된 FilterConfig인터페이스를 사용해 초기 파라미터를 읽는다.
	public void init(FilterConfig config) throws ServletException {
		this.encoding = config.getInitParameter("encoding");
		System.out.println(config.getFilterName() + "필터가 시작되었습니다.");
	}
	
	public void destroy() { }
	
	//필터에 매핑된 요청이 들어올때 호출, 매개변수로 servletrequest, servltresponse, filterchain 인터페이스를 사용해 인코딩 수행
	public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		if(request.getCharacterEncoding() == null) {
				if(encoding != null) {
						request.setCharacterEncoding(encoding);
						response.setCharacterEncoding(encoding);
				}
		}
		chain.doFilter(request, response);
	}
	
	/*doFilter()안에서 요청을 계속 진행하거나 거절시킬수 있으며, 요청과 응답을 변경시킬수도 있다. 
	FilterChain객체의 doFilter()를 호출하면 요청이 계속 진행되며, 이 메서드를 호출하지 않으면 요청을 거절하고 클라이언트에 응답을 보낸다.
	서블릿은 하나의 서블릿이 하나의 요청만 처리할수있지만, 하나의 요청에 대하여 필터체인을 구성하는 여러 개의 칠터가 요청을 가로챌수있다.
	FilterChain 객체의 doFilter()를 호출하는것은 필터 체인에서 필터 실행을 계속하게 하며, 현재의 필터가 필터 체인의 마지막 필터라면
	서블릿 컨테이너에 제어권을 넘겨주고 서블릿컨테이너는 요청을 서블릿에 전달한다. 만약 현재의 필터가 FilterChain객체의 doFilter()
	를 호출하지 않으면 칠터 체인의 실행이 중단되고 나머지 칠터와 서블릿은 요청을 처리할수없게 된다.
	*/
	
}


/*
@WebFilter(
		filterName="characterEncodingFilter",
		urlPatterns={"/*"},
		initParams={
				@WebInitParam(name="encoding", value="UTF-8")
		}
)
public class CharacterEncodingFilter implements Filter {
	
	private String encoding = null;

	public void init(FilterConfig config) throws ServletException {
		this.encoding = config.getInitParameter("encoding");
		System.out.println(config.getFilterName() + " �븘�꽣媛� �떆�옉�릺�뿀�뒿�땲�떎.");
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(request.getCharacterEncoding() == null) {
			if(encoding != null) {
				request.setCharacterEncoding(encoding);
				response.setCharacterEncoding(encoding);
			}
		}
		chain.doFilter(request, response);
	}
}
*/