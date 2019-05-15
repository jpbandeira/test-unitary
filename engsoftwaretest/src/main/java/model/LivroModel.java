package model;

public class LivroModel {
	
	private int id;
	
	private String nome;
	private String autor;
	private int anoDeCriacao;
	
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAnoDeCriacao() {
		return anoDeCriacao;
	}
	public void setAnoDeCriacao(int anoDeCriacao) {
		this.anoDeCriacao = anoDeCriacao;
	}
	
	

}
