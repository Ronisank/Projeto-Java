package model;

public class Cliente {
	protected int id;
	protected String nome;
	protected String cpfCnpj;
	protected String email;
	protected String telefone;
	protected String endereco;
	
	public Cliente() {
	}
	
	
	public Cliente(String nome, String cpfCnpj, String email, String telefone, String endereco) {
		super();
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}


	public Cliente(Integer id, String nome, String cpfCnpj, String email, String telefone, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	

	
	public Integer getId() {
		return id;
	}



	public void setString(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCpfCnpj() {
		return cpfCnpj;
	}



	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
