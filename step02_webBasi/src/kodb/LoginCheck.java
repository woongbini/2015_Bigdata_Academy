package kodb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kodb.domain.PeopleDTO;

public class LoginCheck extends HttpServlet {
	
 
    public LoginCheck() {
    	System.out.println("생성");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//client가 전송하는 데이터 착출
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
						
		/*step01
		//안녕하세요 id 님.
		//응답 객체 한글 인코딩
		response.setContentType("text/html;charset=euc-kr");
		
		출력 객체를 응답 객체로 부터 획득
		PrintWriter out = response.getWriter();
		out.print("<font color = 'blue'>");
		out.println("안녕하세요");
		out.println(id + "님</font>");
		out.close();
		*/
		
		/*step02 - id/pw값과 내 짝궁정보를 자바 객체에 저장해서 jsp라는 파일로 출력 위임
		page이동 API - servlet page이동 API
		1. 포워드 = 디스패치
		2. re다이렉트
		*/
		
		//이동되는 jsp에서 해당 데이터 활용을 위해 요청 객체에 저장
		request.setAttribute("s", new PeopleDTO("뱅뱁뱅", 23));
		
		//페이지 이동API : 이미 생성된 요청 객체를 이동되는 page에 공유하는 api
		request.getRequestDispatcher("view.jsp").forward(request, response);
		
		//2.리다이렉트
		response.sendRedirect("view2.jsp");
		
				
	}

}
