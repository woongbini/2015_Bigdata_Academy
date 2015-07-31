package com.ensora.testingJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**  mysql과 JDBC 연동해보자!! */
/**  추가로 ORACLE의 emp테이블과 JDBC도 연동해보자*/

public class App {
    public static void main( String[] args ) {
    	
    		//oracle
    		String url2 = "jdbc:oracle:thin:@114.207.112.111:1521:B2ENEDU";
    		String username2 = "EDU_A09";
    		String password2 = "sksmsqkqhdlqslek";
    		String sql2 = "select * from EMP";
    		ResultSet rs2 = null;
    		
    		//mysql
    		String url = "jdbc:mysql://localhost:3306/order_system";
    		String username = "root";
    		String password = "1234";
    		String sql = "select * from customer";
    		ResultSet rs = null;
    		
    		
    		try {
    				Connection connection = DriverManager.getConnection(url, username, password);
    				Connection connection2 = DriverManager.getConnection(url2, username2, password2);
    				
    				Statement stmt = connection.createStatement();
    				Statement stmt2 = connection2.createStatement();
    				
    				rs = stmt.executeQuery(sql);
    				rs2 = stmt2.executeQuery(sql2);
    				
    				RowSetFactory factory = RowSetProvider.newFactory();
    				RowSetFactory factory2 = RowSetProvider.newFactory();
    				CachedRowSet crs = factory.createCachedRowSet();
    				CachedRowSet crs2 = factory2.createCachedRowSet();
    				
    				crs.populate(rs);
    				crs2.populate(rs2);
    				
    				rs.close(); rs2.close();
    				stmt.close(); stmt2.close();
    				while(crs2.next()) {
    					System.out.println(crs2.getInt("empno") + ":" +
    							crs2.getString("ENAME") + ":" +crs2.getString(3) + ":" +crs2.getString(4) );
    				
    				}
    				while(crs.next()) {
    						System.out.println(crs.getInt("customer_id") + ":" +
    							crs.getString(2) + ":" +crs.getString(3) + ":" +crs.getString(4) );
    				
    				}
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    
    }
}
