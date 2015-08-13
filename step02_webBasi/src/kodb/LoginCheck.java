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
    	System.out.println("����");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//client�� �����ϴ� ������ ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
						
		/*step01
		//�ȳ��ϼ��� id ��.
		//���� ��ü �ѱ� ���ڵ�
		response.setContentType("text/html;charset=euc-kr");
		
		��� ��ü�� ���� ��ü�� ���� ȹ��
		PrintWriter out = response.getWriter();
		out.print("<font color = 'blue'>");
		out.println("�ȳ��ϼ���");
		out.println(id + "��</font>");
		out.close();
		*/
		
		/*step02 - id/pw���� �� ¦�������� �ڹ� ��ü�� �����ؼ� jsp��� ���Ϸ� ��� ����
		page�̵� API - servlet page�̵� API
		1. ������ = ����ġ
		2. re���̷�Ʈ
		*/
		
		//�̵��Ǵ� jsp���� �ش� ������ Ȱ���� ���� ��û ��ü�� ����
		request.setAttribute("s", new PeopleDTO("����", 23));
		
		//������ �̵�API : �̹� ������ ��û ��ü�� �̵��Ǵ� page�� �����ϴ� api
		request.getRequestDispatcher("view.jsp").forward(request, response);
		
		//2.�����̷�Ʈ
		response.sendRedirect("view2.jsp");
		
				
	}

}
