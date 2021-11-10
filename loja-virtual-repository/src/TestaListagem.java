import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {	
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();		
		Connection connection = connectionFactory.recuperarConexao();		
		
		PreparedStatement stm = connection.prepareStatement("SELECT id, nome, descricao FROM PRODUTO");
		stm.execute();
		
		ResultSet rs = stm.getResultSet();
		
		while(rs.next()) {
			Integer id = rs.getInt("id");
			String nome = rs.getString("nome");
			String descricao = rs.getString("descricao");
			
			System.out.println("id: " + id + ", nome: " + nome + ", descricao: " + descricao);
		}		
		
		System.out.println("Fechando conexão!");
		connection.close();
	}

}
