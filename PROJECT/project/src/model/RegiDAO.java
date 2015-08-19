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
			pstmt = con.prepareStatement("insert into regi_table values(?,?,?,?,?,?,?,?,?,?,?,?)");

			// ������ ���� - ? ǥ������� �� ����
			pstmt.setInt(1, regi.getBoard_number());
			pstmt.setString(2, regi.getTitle());
			pstmt.setString(3, regi.getRegion());
			pstmt.setDate(4, regi.getDate());
			pstmt.setInt(5, regi.getNumber_of_person());
			pstmt.setString(6, regi.getAge());
			pstmt.setString(7,regi.getGender());
			pstmt.setString(8,regi.getSport());
			pstmt.setString(9,regi.getUser_id());
			pstmt.setFloat(10, regi.getLocation_x());
			pstmt.setFloat(11, regi.getLocation_y());
			pstmt.setString(12, regi.getDetail());

			// DB�� insert ����
			result = pstmt.executeUpdate();// DML���� ���� �޼ҵ�
			System.out.println("db���强��");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
/*	public class RegiDTO {
	private int board_number;
	private String title;
	private String region;
	private Date date;
	private int number_of_person;
	private String age;
	private String gender;
	private String sport;
	private String user_id;
	private float location_x;
	private float location_y;
	private String detail;
*/
	public static ArrayList<RegiDTO> getRegiAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// select = query������ ��ü ���
		ResultSet rset = null;
		ArrayList<RegiDTO> data = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from regi_table ");
			// table ������ ��� ������ �����ȯ, ������ ���� ������ �żҵ� ���ؼ� ���� �ʼ�
			rset = pstmt.executeQuery();

			/* boolean next() : �ش� ��ġ���� ���� ������ ��� true��ȯ, ���� ��� false */
			data = new ArrayList<RegiDTO>(); // ���� ���� �� �ٷ� ���� ��ü �������ֱ�
			while (rset.next()) {
				data.add(new RegiDTO(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getDate(4),rset.getInt(5),rset.getString(6),
						rset.getString(7),rset.getString(8),rset.getString(9),rset.getFloat(10),rset.getFloat(11),rset.getString(12)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}
	public static void main(String[] args){
		try {
			System.out.println(getRegiAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
