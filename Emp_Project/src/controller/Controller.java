/** ó�� ����
 * 1. ��� emp ���� ��û : all.html
 * 2. Ư�� emp ���� ��û : empno.html
 * 3. �߰� ������� ��û : insert.html
 * 4. ���� ���� ��û : delete.html
 * 5. �߰����� : login.html (�α��� �Ŀ� �ٸ� ���� ����)
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
	/* client�� ���ӽ� contatiner�� �ڵ� ����
	 * 1. � ��û���� ����
	 * 2. �ش� ��û�� ó�� ���� ��Ȯ�ϰ� �����ؼ� ���� ����
	 * 3. �߻��� ��� ����� ���� ������ jsp�� �����ؼ� view����
	*/
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		/* ��� ���� ��û
		 * 1. DAO�� getAll()
		 * 2. ArrayList ȹ��
		 * 3. ������ ���� ���� Ȯ��
		 * 4. �������� ��ȯ�� - sucessAll.jsp (������=����ó)
		 *    ���������� ��ȯ�� - errorAll.jsp (���������� ������ �̵���Ű��)
		*/
		
		if(command.equals("all")) {
			ArrayList<EmpDTO> all;
			
			try {
				all = EmpDAO.getEmpAll();
				request.setAttribute("allData",  all);
				request.getRequestDispatcher("successAll.jsp").forward(request, response);
				
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("errorMsg",  "��� �˻� ����");
				request.getRequestDispatcher("errorAll.jsp").forward(request, response);
				
			}
		} else if (command.equals("delete")) {
			int emp = Integer.parseInt(request.getParameter("empno"));
			
			try {
				if(EmpDAO.deleteEmp(emp) ==  1) {
					HttpSession session  = request.getSession();
					session.setAttribute("name",  "����");
					response.sendRedirect("view/successDel.jsp");
					
				} else {
					request.setAttribute("errorMsg",  "��Ȯ�� empno������ ���Է�");
					request.getRequestDispatcher("errorAll.jsp").forward(request, response);
				}
			} catch(SQLException e ) {
				e.printStackTrace();
				request.setAttribute("errorMsg", "��õ� ��");
				request.getRequestDispatcher("errorAll.jsp").forward(request, response);
			}
		} else if (command.equals("logout")) {
			logout(request, response);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//�̹� ������ ���� ��ü ȹ���ؼ� ��ȿȭ �� ����
		HttpSession session = request.getSession();
		session.invalidate(); //���� ��� ��ȿȭ
		session = null;
		response.sendRedirect("index.html");
	}
}
