package model;

public class EstudanteModel {

	private int id;

	private String matricula;
	private String nome;
	private String cpf;
	private String rg;
	private int idade;
	private String email;
	private int limiteDeEmprestimos;
	private boolean ativo;

	public EstudanteModel(){}

	public EstudanteModel(String matricula ,String nome, String cpf, String rg, int idade, String email) {
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.idade = idade;
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public int getLimiteDeEmprestimos() {
		return limiteDeEmprestimos;
	}

	public void setLimiteDeEmprestimos(int limiteDeEmprestimos) {
		this.limiteDeEmprestimos = limiteDeEmprestimos;
	}
}
