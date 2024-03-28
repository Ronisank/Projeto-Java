import java.sql.Connection;
import java.sql.SQLException;
import dao.Conexao;

public class Principal {

	public static void main(String[] args) {
		try {
			Connection con = Conexao.criarConexao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
}
