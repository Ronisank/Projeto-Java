package dao;
import java.sql.Connection;
import controller.Conexao;

public class BD {
	private static Connection connection = null;
	
	public static void main(String[] args) {
		try {
		setConnection(Conexao.abrirConexao());
		System.out.println("Base criada com sucesso");
		Conexao.fecharConexao();
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		BD.connection = connection;
	}
}