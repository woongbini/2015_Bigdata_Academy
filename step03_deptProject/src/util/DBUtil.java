/**모든 DAO가 공통적으로 사용되는 코드들로만 구성된 유틸 클래스
 */

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	//driver loading
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//connection 재사용위해 메소드로 만들기
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@114.207.112.111:1521:B2ENEDU","EDU_A09","sksmsqkqhdlqslek");
	}
	
	//close 재사용위해 메소드로 만들기
	public static void close(Connection con, Statement stmt) {
		try {
			if(stmt != null) { //쓰레기로 ㄱㄱ
				stmt.close();
				stmt = null;
			}
			if(con != null) { //성공했을때를 대비하여 null로 초기화
				con.close();
				con = null; 
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	
	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if(stmt != null) { //쓰레기로 ㄱㄱ
				stmt.close();
				stmt = null;
			}
			if(con != null) { //성공했을때를 대비하여 null로 초기화
				con.close();
				con = null; 
			}
			if(rset != null) {
				rset.close();
				rset = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
	}
}
