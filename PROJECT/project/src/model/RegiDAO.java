//submit눌렀을때 db로 입력 정보 저장 시키는 로직
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.RegiDTO;
import util.DBUtil;

public class RegiDAO {

	// submit->저장
	public static int insertRegi(RegiDTO regi) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// db연결
		int result = 0;
		try {
			con = DBUtil.getConnection();
			System.out.println("db연결 성공");
			
			// insert 문장만 실행가능한 객체 생성
			pstmt = con.prepareStatement("insert into dept values(?,?,?,?,?,?,?)");

			// 데이터 대입 - ? 표기순으로 값 대입
			pstmt.setString(2, regi.getTitle());
			pstmt.setString(3, regi.getRegion());
			pstmt.setDate(4, regi.getDate());
			pstmt.setTime(5, regi.getTime());
			pstmt.setString(7,regi.getGender());
		
			pstmt.setString(7, regi.getDetail());

			// DB에 insert 실행
			result = pstmt.executeUpdate();// DML문장 실행 메소드
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;

	}
/*	create table regi_table(
			1.board_number  			number,
			title 							varchar2(50),
			region 						varchar2(30),
			date_time				 	timestamp,
			number_of_person  	number,
			age 							varchar2(10),
			gender 						varchar2(10),
			location_x  				number(12,9),
			location_y  				number(12,9),
			detail  						varchar2(100)
			);*/
	public static ArrayList<RegiDTO> getRegiAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// select = query문장의 객체 결과
		ResultSet rset = null;
		ArrayList<RegiDTO> data = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from regi_table");
			// table 존재할 경우 무조건 정상반환, 데이터 존재 유무는 매소드 통해서 검증 필수
			rset = pstmt.executeQuery();

			/* boolean next() : 해당 위치상의 행이 존재할 경우 true반환, 없을 경우 false */
			data = new ArrayList<RegiDTO>(); // 실제 쓰일 때 바로 위에 객체 생성해주기
			while (rset.next()) {
				data.add(new RegiDTO( rset.getInt(1),rset.getString(2), rset.getString(3),rset.getInt(5), rset.getString(6),rset.getString(7),
						rset.getFloat(8), rset.getFloat(9),rset.getString(10)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}

}
