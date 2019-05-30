package model;

import java.util.concurrent.atomic.AtomicInteger;

public class LivroModel {

	private int id = 0;

	private String nome;
	private String autor;
	private int anoDeCriacao;

	private boolean ativoOuInativo;
	
	private boolean livroAlugadoOuNao;

	public LivroModel() {}

	public LivroModel(String nome, String autor, int anoDeCriacao) {
		
		this.id++;
		this.nome = nome;
		this.autor = autor;
		this.anoDeCriacao = anoDeCriacao;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public boolean isLivroAlugadoOuNao() {
		return livroAlugadoOuNao;
	}

	public void setLivroAlugadoOuNao(boolean livroAlugadoOuNao) {
		this.livroAlugadoOuNao = livroAlugadoOuNao;
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

	public boolean isAtivoOuInativo() {
		return ativoOuInativo;
	}

	public void setAtivoOuInativo(boolean ativoOuInativo) {
		this.ativoOuInativo = ativoOuInativo;
	}
	

}
