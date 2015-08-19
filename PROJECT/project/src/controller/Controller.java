package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RegiDAO;
import model.domain.RegiDTO;
public class Controller extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command.equals("register")){
			try {
				ArrayList<RegiDTO> regi = RegiDAO.getRegiAll();				
				request.setAttribute("regiData", regi);
				request.getRequestDispatcher("result.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("errorMsg", "모든 검색 실패");
				request.getRequestDispatcher("errorAll.jsp").forward(request, response);
			}
			
			
		}
	}
}
