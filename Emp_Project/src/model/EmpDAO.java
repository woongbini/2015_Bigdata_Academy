/**DB와 Access하는 로직을 보유한 전담 클래스
 * 1. 저장 :
*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.EmpDTO;
import util.DBUtil;

public class EmpDAO {
	
	//insert logic //jdbc:orcle:thin:@114.207.112.111:1521:B2ENEDU
	
	/* SELECT * 
	 * 접속 -> SQL실행객체 생성 -> sql문장 생성 -> 결과값으로 empDTO객체 생성
	 * 발생 가능한 경우의수
	 * 		1. table X : sql문제 발생 exception 처리
	 * 		2. table O 데이터 X : null? 아무 데이터도 없는 ArrayList 반환
	*/
	public static ArrayList<EmpDTO> getEmpAll() throws SQLException  {
		ArrayList<EmpDTO> data = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from EMP");
			rset = pstmt.executeQuery();
			data = new ArrayList<EmpDTO>();
			while (rset.next()) {
				data.add(new EmpDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getString(5),
						rset.getInt(6),rset.getInt(7),rset.getInt(8) ) );
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;	
	}
	
	//SELECT * from EMP where empno=?
		public static EmpDTO getEmpAll(int empno) throws SQLException {
			EmpDTO emp = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from EMP where EMPNO=?");
				pstmt.setInt(1,  empno);
				rset =pstmt.executeQuery();
				rset.next();
				emp = new EmpDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getString(5),
						rset.getInt(6),rset.getInt(7),rset.getInt(8) );
			} finally {
				DBUtil.close(con, pstmt);
			}
			
			return emp;
		}

	//INSERT 
	public static int insertEmp(EmpDTO emp ) throws SQLException {
		int result =0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
				//insert문장 가능한 객체 생성
			pstmt = con.prepareStatement("insert into EMP values(?,?,?,?,?,?,?,?)");
				//데이터 대입 -> 표기순으로 대입
			pstmt.setInt(1,  emp.getEmpno());
			pstmt.setString(2,  emp.getEname());
			pstmt.setString(3,  emp.getJob());
			pstmt.setInt(4,  emp.getMgr());
			pstmt.setString(5,  emp.getHiredate());
			pstmt.setInt(6,  emp.getSal());
			pstmt.setInt(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());
				//DB에 insert 실행
			result = pstmt.executeUpdate(); //dml문장 실행 메소드
		} finally { 
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	//DELETE
	public static int deleteEmp(int empno) throws SQLException {
		int result =0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt  = con.prepareStatement("delete from EMP where empno=?");
			pstmt.setInt(1,  empno);
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	
}
