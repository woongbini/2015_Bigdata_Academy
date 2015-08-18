package main;

import java.sql.SQLException;
import java.util.ArrayList;

import model.EmpDAO;
import model.domain.EmpDTO;

public class Main {

	public static void main(String[] args) {
		ArrayList<EmpDTO> data = null;
		
		try {
			data = EmpDAO.getEmpAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(int i=0 ; i<data.size() ;i++) {
			System.out.println(data.get(i));
		}
	}

}
