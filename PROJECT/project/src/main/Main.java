package main;

import java.sql.SQLException;
import java.util.ArrayList;

import model.RegiDAO;
import model.domain.RegiDTO;

public class Main {

	public static void main(String[] args) {
			ArrayList<RegiDTO> data = null;
			
			try {
				data = RegiDAO.getRegiAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			for(int i=0 ; i<data.size() ;i++) {
				System.out.println(data.get(i));
			}
	}

}
