package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	static final String URL = "jdbc:postgresql://localhost:5432/bancologinjava"; //incica o caminho do banco de dados
	static final String USER = "postgres"; // aqui vai o nome usuario que vc quer acessar
	static final String PASS = "admin"; // aqui a senha do seu banco
	static Connection con;

	public static Connection criarConexao() throws ClassNotFoundException, SQLException{
	Class.forName("org.postgresql.Driver");
	Connection conecta = DriverManager.getConnection(URL, USER, PASS);
	con = conecta;
	if (conecta != null){
	//System.out.print("Conexão efetuada com sucesso...");
	return conecta;
	}
	return null;
	}
	
	public int executaSQL (String sql) {
		try {
			Statement stm = con.createStatement();
			int res = stm.executeUpdate(sql);
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
