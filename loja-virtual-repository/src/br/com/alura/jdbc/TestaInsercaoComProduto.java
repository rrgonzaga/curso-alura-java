package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Cômoda", "Cômoda Vertical");
		
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
		
		try(Connection connection = new ConnectionFactory().recuperarConexao(); 
				PreparedStatement pstm = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			
			pstm.setString(1, comoda.getNome());
			pstm.setString(2, comoda.getDescricao());
			
			pstm.execute();
			
			ResultSet rs = pstm.getGeneratedKeys();
			
			while(rs.next()) {				
				comoda.setId(rs.getInt(1));
			}	
			
		};
		
		System.out.println(comoda);	

	}

}
