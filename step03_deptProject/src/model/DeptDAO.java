/** DB�� access�ϴ� ������ ������ ���� Ŭ����
* 1. ���� : insert into DEPT values(50, '������', 'ȭ��')
* 2. �˻� : 
* 	2-1. �μ���ȣ�� �˻� : select * from DEPT where DEPTNO = ?
* 	2-2. ��ü �˻� : select * from DEPT
* 3. ip : 
*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.DeptDTO;
import util.DBUtil;

public class DeptDAO {
	
	//insert logic  	//jdbc:orcle:thin:@114.207.112.111:1521:B2ENEDU
	public static int insertDept(DeptDTO dept) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			
			//insert���常 ������ ��ü ����
			pstmt = con.prepareStatement("insert into DEPT values(?,?,?)");
			
			//������ ����-> ? ǥ������� ���� ��������
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			//DB�� insert����
			result = pstmt.executeUpdate(); //DML���� ���� �޼ҵ�
			
		} finally {	
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	public static int deleteDept(int deptno) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from DEPT where deptno=?");
			pstmt.setInt(1, deptno);
			result = pstmt.executeUpdate(); 
			
		} finally {	
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	//select *
	/*����->sql���ఴü ���� -> sql���� ����->���������deptDTO��ü ����-> 
	 * �߻� ������ ����Ǽ�
	 * 1. table x : sql���� �߻� exception ó��
	 * 2. table o ������ x : null? �ƹ� �����͵� ���� ArrayList ��ȯ
	*/
	public static ArrayList<DeptDTO> getDeptAll() throws SQLException {
		ArrayList<DeptDTO> data = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		//select = query ������ ��� ��ü
		ResultSet rset = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from DEPT");
			
			//table�� �����Ұ�� ������ �����ȯ, ������ ���� ������ �޼ҵ� ���ؼ� ���� �ʼ�!!!
			rset = pstmt.executeQuery();
			
			//boolean next() : �ش� ��ġ���� ���� ������ ��� true��ȯ, ���ΰ�� false		
			data = new ArrayList<DeptDTO>();
			while(rset.next()) {
				data.add( new DeptDTO( rset.getInt(1), rset.getString(2), rset.getString(3) ) );
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return data;
	}

	//select * from DEPT where DEPTNO=? �� �̾ƺ���
	public static DeptDTO getDeptAll(int deptno) throws SQLException {
		DeptDTO dep = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from DEPT where DEPTNO=?");
			pstmt.setInt(1, deptno);
			rset = pstmt.executeQuery();
			rset.next();
			dep = (new DeptDTO(rset.getInt(1), rset.getString(2), rset.getString(3)));
				
		} finally {
			DBUtil.close(con, pstmt);
		}
		return dep;
	}
	
	
	public static void main(String[] args) {
		DeptDTO data = null;
		try {
			data = DeptDAO.getDeptAll(10);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(data.toString());
	}
	
	
}	
