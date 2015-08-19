package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Local;

import model.RegiDAO;
import model.domain.RegiDTO;

public class Controller extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getParameter("command");
		if (command.equals("register")) {
			// db에 등록 저장
			System.out.println("정보저장 실행");
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.KOREA);	
			
			try {
				java.util.Date insert_date = fmt.parse("2015-08-20 12:00:00");
				java.sql.Date sqlDate = new Date(insert_date.getTime());
				
				RegiDTO insert_regi = new RegiDTO(2, 
						request.getParameter("title"), 
						request.getParameter("city"),
						sqlDate, 
						Integer.parseInt(request.getParameter("number")), 
						request.getParameter("age"),
						request.getParameter("gender"), 
						"야구", 
						"bosomi56", 
						(float) 127.1052208, 
						(float) 37.3595122,
						request.getParameter("detail"));

				try {
					RegiDAO.insertRegi(insert_regi);
					request.setAttribute("insertData", insert_regi);
					request.getRequestDispatcher("result.jsp").forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

		} else if (command.equals("get_location")) {
			System.out.println("정보조회 실행");
			// db에서 조회
			ArrayList<RegiDTO> regi;
			try {
				regi = RegiDAO.getRegiAll();
				request.setAttribute("regiData", regi);
				request.getRequestDispatcher("location_list.jsp").forward(request, response);
				System.out.println("정보조회 실행완료");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
	
}
