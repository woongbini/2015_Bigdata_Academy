/** 처리 로직
* 1. 모든 부서 정보 요청 : all.html
* 2. 특정 부서 정보 요청 : deptno.html
* 3. 추가 저장로직 요청 : insert.html
* 4. 삭제 로직 요청 : delete.html
* 
* 5. 추가로직 : login.html (로그인 후에나 다른 로직 수행)
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

import model.DeptDAO;
import model.domain.DeptDTO;


public class Controller extends HttpServlet {
	
	//client가 접속시 container가 자동 실행
	/* 1. 어떤 요청인지 구분
	 * 2. 해당 요청별 처리 로직 명확하게 구분해서 실ㅇ행 위임
	 * 3. 발생된 모든 경우의 수에 적합한jsp를 지정해서 view위잉ㅁ
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String command = request.getParameter("command");
		
	/*	모두 보기 요청
		1. DAO의 getAll() 홏풀
		2. ArrayList 획득
		3. 데이터 존재 유무 확인
		4. 정상 데이터 반환시 - successAll.jsp
				- 포워드(dispatcher)
		   비정상 데이터 반환시 - errorAll.jsp
				- 포워드로 page이동
			*/
		
		if(command.equals("all")) {
				ArrayList<DeptDTO> all;
				try {
					all = DeptDAO.getDeptAll();
					request.setAttribute("allData", all);
					request.getRequestDispatcher("successAll.jsp").forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("errorMsg", "모든 검색 실패");
					request.getRequestDispatcher("errorAll.jsp").forward(request, response);
				}
		
		} else if (command.equals("delete")) {
				int dept = Integer.parseInt(request.getParameter("deptno"));
				try {
					if(DeptDAO.deleteDept(dept) == 1) {
						/*id를 리다이렉트로 이동시에도 사용 가능하게 데이터 유지 = 상태 유기
						 * 1. 세션 - 상태유지값 서버 메모리 활용
						 * 2. 쿠키 - 상태유지값을 client PC에 저장(쿠키 파일 또는 브라우저 실행 메모리)
						 * */
						 
						//[1]getSession() : 세션 객체 생성(없으면 생성, 있으면 재사용)
						//[2]jsp특징 : httpsession이 API를 session이라는 이름만으로 사용 가능
						HttpSession session = request.getSession();
						session.setAttribute("name",  "나여자");
						
						response.sendRedirect("view/successDel.jsp"); //요청객체 새로 생성
						
					} else {
						request.setAttribute("errorMsg", "정확한 deptno 데이터 재입력하세요");
						request.getRequestDispatcher("errorAll.jsp").forward(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("errorMsg", "재시도 ㄱ ㄱ ");
					request.getRequestDispatcher("errorAll.jsp").forward(request, response);
				}
				
		} else if(command.equals("logout")) {
			logout(request, response);
			
		}
		
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//이미 생성된 세션 객체 획득해서 무효화 및 삭제...
		HttpSession session = request.getSession();
		session.invalidate(); //세션 기능 무효화
		session = null;
		response.sendRedirect("index.html");
	}

}
