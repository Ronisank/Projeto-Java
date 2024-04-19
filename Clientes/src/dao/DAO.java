package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.Conexao;
import model.Cliente;
import model.Usuario;

public class DAO {
	private Connection conexao;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	private static String CADASTRAR_CLIENTE = " INSERT INTO CLIENTE  "
			+ " (NOME, CPFCNPJ, EMAIL, TELEFONE, ENDERECO) " + " VALUES (?, ?, ?, ?, ?) ";

	private static String CONSULTAR_CLIENTE = " SELECT * FROM CLIENTE  " + " WHERE ID = ? ";

	private static String ALTERAR_CLIENTE = " UPDATE CLIENTE  SET "
			+ " NOME = ?, CPFCNPJ = ?, EMAIL = ?, TELEFONE = ?, ENDERECO = ? " + " WHERE ID = ? ";

	private static String EXCLUIR_CLIENTE = " DELETE FROM CLIENTE  " + " WHERE ID = ? ";

	private static String LISTAR_CLIENTES = " SELECT * FROM CLIENTE  " + " WHERE 1=1 ";

	private static String CONSULTAR_USUARIO = " SELECT USUARIO, SENHA  " + " FROM USUARIO " + " WHERE USUARIO = ? "
			+ " AND SENHA = ? ";

	public DAO() {
	}

	public void cadastarCliente(Cliente cliente) {
		Connection connection = Conexao.abrirConexao();

		String query = CADASTRAR_CLIENTE;
		try {
			preparedStatement = connection.prepareStatement(query);

			int i = 1;

			// NOME, CPFCNPJ, EMAIL, TELEFONE, ENDERECO
			//preparedStatement.setString(i++, cliente.getId());
			preparedStatement.setString(i++, cliente.getNome());
			preparedStatement.setString(i++, cliente.getCpfCnpj());
			preparedStatement.setString(i++, cliente.getEmail());
			preparedStatement.setString(i++, cliente.getTelefone());
			preparedStatement.setString(i++, cliente.getEndereco());

			preparedStatement.execute();
			//connection.commit();

			JOptionPane.showMessageDialog(null, "Cliente incluído com sucesso ");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}

	}
	
	public Cliente consultarCliente(int id) throws Exception {
		Connection connection = Conexao.abrirConexao();
		Cliente cliente = null;
		String query = CONSULTAR_CLIENTE;
		try {
			preparedStatement = connection.prepareStatement(query);

			int i = 1;

			// NOME, CPFCNPJ, EMAIL, TELEFONE, ENDERECO
			preparedStatement.setInt(i++, id);

			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				//String id, String nome, String cpfCnpj, String email, String telefone, String endereco
				cliente  = new Cliente(	resultSet.getInt("id"),
										resultSet.getString("nome"),
										resultSet.getString("cpfcnpj"),
										resultSet.getString("email"),
										resultSet.getString("telefone"),
										resultSet.getString("endereco"));
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		if(cliente == null) {
			JOptionPane.showMessageDialog(null, "Não possível localizar o cliente selecionado ", "", JOptionPane.WARNING_MESSAGE);
			throw new Exception("Não possível localizar o cliente selecionado");
		}
		return cliente;

	}

	public void alterarCliente(int id, Cliente cliente) {
		Connection connection = Conexao.abrirConexao();

		String query = ALTERAR_CLIENTE;
		try {
			preparedStatement = connection.prepareStatement(query);

			int i = 1;

			preparedStatement.setString(i++, cliente.getNome());
			preparedStatement.setString(i++, cliente.getCpfCnpj());
			preparedStatement.setString(i++, cliente.getEmail());
			preparedStatement.setString(i++, cliente.getTelefone());
			preparedStatement.setString(i++, cliente.getEndereco());
			preparedStatement.setInt(i++, id);

			preparedStatement.execute();
			//connection.commit();
			
			JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso ");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}

	}
	
	public void excluirCliente(int id) {
		Connection connection = Conexao.abrirConexao();

		String query = EXCLUIR_CLIENTE;
		try {
			preparedStatement = connection.prepareStatement(query);

			int i = 1;

			preparedStatement.setInt(i++, id);

			preparedStatement.execute();
			//connection.commit();
			
			JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso ");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}

	}
	
	public ArrayList<Cliente> listarClientes() throws Exception {
		Connection connection = Conexao.abrirConexao();
		ArrayList<Cliente> clientes = new ArrayList<>();
		String query = LISTAR_CLIENTES;
		try {
			preparedStatement = connection.prepareStatement(query);


			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				//String id, String nome, String cpfCnpj, String email, String telefone, String endereco
				clientes.add( new Cliente(	resultSet.getInt("id"),
										resultSet.getString("nome"),
										resultSet.getString("cpfcnpj"),
										resultSet.getString("email"),
										resultSet.getString("telefone"),
										resultSet.getString("endereco")));
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		if(clientes.size() < 0) {
			JOptionPane.showMessageDialog(null, "Não há clientes cadastrados ", "", JOptionPane.WARNING_MESSAGE);
			throw new Exception("Não há clientes cadastrados ");
		}
		return clientes;

	}
	
	public Usuario consultarUsuario(String nomeUsuario, String senhaCriptografada) throws Exception {
		Connection connection = Conexao.abrirConexao();
		Usuario usuario = null;
		String query = CONSULTAR_USUARIO;
		try {
			preparedStatement = connection.prepareStatement(query);

			int i = 1;

			preparedStatement.setString(i++, nomeUsuario);
			preparedStatement.setString(i++, senhaCriptografada);

			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				//String id, String nome, String cpfCnpj, String email, String telefone, String endereco
				usuario  = new Usuario(	resultSet.getInt("ID"),
										resultSet.getString("USUARIO"),
										resultSet.getString("SENHA"));
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		if(usuario == null) {
			JOptionPane.showMessageDialog(null, "Não possível localizar o usuário selecionado ", "", JOptionPane.WARNING_MESSAGE);
			throw new Exception("Não possível localizar o cliente selecionado");
		}
		return usuario;

	}

	private void fecharConexao() {
		try {	
			if (resultSet!=null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			Conexao.fecharConexao();
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
}

