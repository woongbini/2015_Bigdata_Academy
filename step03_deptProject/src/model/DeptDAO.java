/** DB와 access하는 로직을 보유한 전담 클래스
* 1. 저장 : insert into DEPT values(50, '교육부', '화전')
* 2. 검색 : 
* 	2-1. 부서번호로 검색 : select * from DEPT where DEPTNO = ?
* 	2-2. 전체 검색 : select * from DEPT
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
			
			//insert문장만 가능한 객체 생성
			pstmt = con.prepareStatement("insert into DEPT values(?,?,?)");
			
			//데이터 대입-> ? 표기순으로 값을 대입하자
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			//DB에 insert실행
			result = pstmt.executeUpdate(); //DML문장 실행 메소드
			
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
	/*접속->sql실행객체 생성 -> sql문장 생성->결과값으로deptDTO객체 생성-> 
	 * 발생 가능한 경우의수
	 * 1. table x : sql문제 발생 exception 처리
	 * 2. table o 데이터 x : null? 아무 데이터도 없는 ArrayList 반환
	*/
	public static ArrayList<DeptDTO> getDeptAll() throws SQLException {
		ArrayList<DeptDTO> data = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		//select = query 문장의 결과 객체
		ResultSet rset = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from DEPT");
			
			//table이 존재할경우 무조건 정상반환, 데이터 존재 유무는 메소드 통해서 검증 필수!!!
			rset = pstmt.executeQuery();
			
			//boolean next() : 해당 위치상의 행이 존재할 경우 true반환, 무인경우 false		
			data = new ArrayList<DeptDTO>();
			while(rset.next()) {
				data.add( new DeptDTO( rset.getInt(1), rset.getString(2), rset.getString(3) ) );
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return data;
	}

	//select * from DEPT where DEPTNO=? 를 뽑아보자
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
