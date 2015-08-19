//submit�������� db�� �Է� ���� ���� ��Ű�� ����
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.RegiDTO;
import util.DBUtil;

public class RegiDAO {

	// submit->����
	public static int insertRegi(RegiDTO regi) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// db����
		int result = 0;
		try {
			con = DBUtil.getConnection();
			System.out.println("db���� ����");
			
			// insert ���常 ���డ���� ��ü ����
			pstmt = con.prepareStatement("insert into dept values(?,?,?,?,?,?,?)");

			// ������ ���� - ? ǥ������� �� ����
			pstmt.setString(2, regi.getTitle());
			pstmt.setString(3, regi.getRegion());
			pstmt.setDate(4, regi.getDate());
			pstmt.setTime(5, regi.getTime());
			pstmt.setString(7,regi.getGender());
		
			pstmt.setString(7, regi.getDetail());

			// DB�� insert ����
			result = pstmt.executeUpdate();// DML���� ���� �޼ҵ�
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
		// select = query������ ��ü ���
		ResultSet rset = null;
		ArrayList<RegiDTO> data = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from regi_table");
			// table ������ ��� ������ �����ȯ, ������ ���� ������ �żҵ� ���ؼ� ���� �ʼ�
			rset = pstmt.executeQuery();

			/* boolean next() : �ش� ��ġ���� ���� ������ ��� true��ȯ, ���� ��� false */
			data = new ArrayList<RegiDTO>(); // ���� ���� �� �ٷ� ���� ��ü �������ֱ�
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
