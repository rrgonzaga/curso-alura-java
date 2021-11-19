import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		/* Definindo o commit de cada transação de forma não automática. 
		 * Para o nosso sistema ter o controle da transação e não o driver do JDBC.
		*/ 
		connection.setAutoCommit(false);
		
		PreparedStatement stm = null;
		
		try {
			stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)",
					Statement.RETURN_GENERATED_KEYS);
			adicionarVariavel("TECLADO BLUETOOTH LOGITECH", "TECLADO BLUETOOTH LOGITECH 2.5", stm);
			adicionarVariavel("Smart TV TCL ", "Smart TV TCL 40 polegadas Full HD", stm);
			
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			System.out.println("ROLLBACK EXECUTADO");
		//O finally poderia ser substituido pelo try-with-resources.Assim não precisaria fechar o prepareStatement e nem a connection explicitamente
		} finally {
			if(stm != null && !stm.isClosed()) 
				stm.close();
			
			if(!connection.isClosed()) 
				connection.close();							
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
//		if(nome.toLowerCase().startsWith("smart")) {
//			throw new RuntimeException("Não foi possível adicionar o produto");
//		}
		
		stm.execute();
		
		ResultSet rs = stm.getGeneratedKeys();
		
		while(rs.next()) {
			Integer id = rs.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
	}
}
