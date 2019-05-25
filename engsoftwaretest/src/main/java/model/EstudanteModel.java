package model;

public class EstudanteModel {
	
	private int id;
	
	private String nome;
	private String cpf;
	private String rg;
	private int idade;
	private String email;
	
	private boolean aitvoOuInativo;
	
	public EstudanteModel(String nome, String cpf, String rg, int idade, boolean aitvoOuInativo) {
		this.id++;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.idade = idade;
		this.aitvoOuInativo = aitvoOuInativo;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public boolean isAitvoOuInativo() {
		return aitvoOuInativo;
	}

	public void setAitvoOuInativo(boolean aitvoOuInativo) {
		this.aitvoOuInativo = aitvoOuInativo;
	}
	
	
	

}
