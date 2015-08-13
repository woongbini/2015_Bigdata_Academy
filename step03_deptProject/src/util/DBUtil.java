/**��� DAO�� ���������� ���Ǵ� �ڵ��θ� ������ ��ƿ Ŭ����
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
	
	//connection �������� �޼ҵ�� �����
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@114.207.112.111:1521:B2ENEDU","EDU_A09","sksmsqkqhdlqslek");
	}
	
	//close �������� �޼ҵ�� �����
	public static void close(Connection con, Statement stmt) {
		try {
			if(stmt != null) { //������� ����
				stmt.close();
				stmt = null;
			}
			if(con != null) { //������������ ����Ͽ� null�� �ʱ�ȭ
				con.close();
				con = null; 
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	
	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if(stmt != null) { //������� ����
				stmt.close();
				stmt = null;
			}
			if(con != null) { //������������ ����Ͽ� null�� �ʱ�ȭ
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
