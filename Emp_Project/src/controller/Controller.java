/** 처리 로직
 * 1. 모든 emp 정보 요청 : all.html
 * 2. 특정 emp 정보 요청 : empno.html
 * 3. 추가 저장로직 요청 : insert.html
 * 4. 삭제 로직 요청 : delete.html
 * 5. 추가로직 : login.html (로그인 후에 다른 로직 수행)
*/
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmpDAO;
import model.domain.EmpDTO;

public class Controller extends HttpServlet{
	/* client가 접속시 contatiner가 자동 실행
	 * 1. 어떤 요청인지 구분
	 * 2. 해당 요청별 처리 로직 명확하게 구분해서 실행 위임
	 * 3. 발생된 모든 경우의 수에 적합한 jsp를 지정해서 view위임
	*/
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		/* 모두 보기 요청
		 * 1. DAO의 getAll()
		 * 2. ArrayList 획득
		 * 3. 데이터 존재 유무 확인
		 * 4. 정상데이터 반환시 - sucessAll.jsp (포워딩=디스패처)
		 *    비정상데이터 반환시 - errorAll.jsp (포워딩으로 페이지 이동시키기)
		*/
		
		if(command.equals("all")) {
			ArrayList<EmpDTO> all;
			
			try {
				all = EmpDAO.getEmpAll();
				request.setAttribute("allData",  all);
				request.getRequestDispatcher("successAll.jsp").forward(request, response);
				
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("errorMsg",  "모든 검색 실패");
				request.getRequestDispatcher("errorAll.jsp").forward(request, response);
				
			}
		} else if (command.equals("delete")) {
			int emp = Integer.parseInt(request.getParameter("empno"));
			
			try {
				if(EmpDAO.deleteEmp(emp) ==  1) {
					HttpSession session  = request.getSession();
					session.setAttribute("name",  "뱅뱅뱅");
					response.sendRedirect("view/successDel.jsp");
					
				} else {
					request.setAttribute("errorMsg",  "정확한 empno데이터 재입력");
					request.getRequestDispatcher("errorAll.jsp").forward(request, response);
				}
			} catch(SQLException e ) {
				e.printStackTrace();
				request.setAttribute("errorMsg", "재시도 ㄱ");
				request.getRequestDispatcher("errorAll.jsp").forward(request, response);
			}
		} else if (command.equals("logout")) {
			logout(request, response);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//이미 생성된 세션 객체 획득해서 무효화 및 삭제
		HttpSession session = request.getSession();
		session.invalidate(); //세션 기능 무효화
		session = null;
		response.sendRedirect("index.html");
	}
}
