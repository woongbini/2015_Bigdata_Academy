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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*Java EE사양으로는 필터가 http가 아닌 요청과 응답을 필터링할수있지만 현재로서는 요청객체는 항상
httpserverletrequest이고, 응답 객체는 항상httpServerletResponse이므로 이들 인터페이스 타입으로 형변환을 하여 사용할수있다.
logging기능을 수행하는 필터를 작성한다.
*/

@WebFilter(
		filterName="loggingFilter",
		servletNames={"customerServlet"},
		dispatcherTypes={DispatcherType.REQUEST}
)
public class LoggingFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {
		System.out.println(config.getFilterName() + "필터링이 시작되었습니다.");
	}
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Instant time = Instant.now();
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String remoteAddr = req.getRemoteAddr();
		String httpMethod = req.getMethod();
		String uri = req.getRequestURI();
		String protocol = req.getProtocol();
		int status = res.getStatus();
		System.out.println("[" + time + "] " + remoteAddr + " : " + httpMethod + " " + uri + " " + protocol + " " + status );
		chain.doFilter(request, response);
	}
}
