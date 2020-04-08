package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DizionarioDAO {
	
	public boolean isCorrect(String anagramma) {
		
		String sql = "SELECT * FROM parola WHERE nome=?";
		boolean trovato = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, anagramma);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				trovato = true;
			}
			
			conn.close();
			
		}catch(SQLException e){
			throw new RuntimeException("Errore DB", e);
		}
		
		return trovato;
	}
	
}
