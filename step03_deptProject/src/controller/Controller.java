/** ó�� ����
* 1. ��� �μ� ���� ��û : all.html
* 2. Ư�� �μ� ���� ��û : deptno.html
* 3. �߰� ������� ��û : insert.html
* 4. ���� ���� ��û : delete.html
* 
* 5. �߰����� : login.html (�α��� �Ŀ��� �ٸ� ���� ����)
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
	
	//client�� ���ӽ� container�� �ڵ� ����
	/* 1. � ��û���� ����
	 * 2. �ش� ��û�� ó�� ���� ��Ȯ�ϰ� �����ؼ� �Ǥ��� ����
	 * 3. �߻��� ��� ����� ���� ������jsp�� �����ؼ� view���פ�
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String command = request.getParameter("command");
		
	/*	��� ���� ��û
		1. DAO�� getAll() �MǮ
		2. ArrayList ȹ��
		3. ������ ���� ���� Ȯ��
		4. ���� ������ ��ȯ�� - successAll.jsp
				- ������(dispatcher)
		   ������ ������ ��ȯ�� - errorAll.jsp
				- ������� page�̵�
			*/
		
		if(command.equals("all")) {
				ArrayList<DeptDTO> all;
				try {
					all = DeptDAO.getDeptAll();
					request.setAttribute("allData", all);
					request.getRequestDispatcher("successAll.jsp").forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("errorMsg", "��� �˻� ����");
					request.getRequestDispatcher("errorAll.jsp").forward(request, response);
				}
		
		} else if (command.equals("delete")) {
				int dept = Integer.parseInt(request.getParameter("deptno"));
				try {
					if(DeptDAO.deleteDept(dept) == 1) {
						/*id�� �����̷�Ʈ�� �̵��ÿ��� ��� �����ϰ� ������ ���� = ���� ����
						 * 1. ���� - ���������� ���� �޸� Ȱ��
						 * 2. ��Ű - ������������ client PC�� ����(��Ű ���� �Ǵ� ������ ���� �޸�)
						 * */
						 
						//[1]getSession() : ���� ��ü ����(������ ����, ������ ����)
						//[2]jspƯ¡ : httpsession�� API�� session�̶�� �̸������� ��� ����
						HttpSession session = request.getSession();
						session.setAttribute("name",  "������");
						
						response.sendRedirect("view/successDel.jsp"); //��û��ü ���� ����
						
					} else {
						request.setAttribute("errorMsg", "��Ȯ�� deptno ������ ���Է��ϼ���");
						request.getRequestDispatcher("errorAll.jsp").forward(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("errorMsg", "��õ� �� �� ");
					request.getRequestDispatcher("errorAll.jsp").forward(request, response);
				}
				
		} else if(command.equals("logout")) {
			logout(request, response);
			
		}
		
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//�̹� ������ ���� ��ü ȹ���ؼ� ��ȿȭ �� ����...
		HttpSession session = request.getSession();
		session.invalidate(); //���� ��� ��ȿȭ
		session = null;
		response.sendRedirect("index.html");
	}

}
