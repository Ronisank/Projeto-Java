package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
	private static final String URL = "jdbc:postgresql://localhost:5432/bdclientes"; //incica o caminho do banco de dados
	private static final String USER = "postgres"; // aqui vai o nome usuario que vc quer acessar
	private static final String PASS = "admin"; // aqui a senha do seu banco
	private static Connection conexao;

	 public static Connection abrirConexao() {
	        Connection conexao = null;
	        try {
	            conexao = DriverManager.getConnection(URL, USER, PASS);
	            System.out.println("Conectado ao banco de dados com sucesso!");
	        } catch (SQLException e) {
	            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
	        }
	        return conexao;
	    }
	
	 public static void fecharConexao() {
	        if (conexao != null) {
	            try {
	                conexao.close();
	                System.out.println("Conexão fechada com sucesso!");
	            } catch (SQLException e) {
	                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
	            }
	        }
}
	 }
