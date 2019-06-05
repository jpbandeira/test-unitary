package model;

public class LivroModel {

	private int id;
	private String nome;
	private String autor;
	private int anoDeCriacao;
	private int quantidadeDeExemplares;
	private boolean ativo;
	private boolean livroAlugado;
	private boolean livroReservado;

	public LivroModel() {}

	public LivroModel(boolean ativo, String nome, String autor, int anoDeCriacao) {
		this.ativo = ativo;
		this.nome = nome;
		this.autor = autor;
		this.anoDeCriacao = anoDeCriacao;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public boolean isLivroReservado() {
		return livroReservado;
	}

	public void setLivroReservado(boolean livroReservado) {
		this.livroReservado = livroReservado;
	}

	public boolean isLivroAlugado() {
		return livroAlugado;
	}

	public void setLivroAlugado(boolean livroAlugado) {
		this.livroAlugado = livroAlugado;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getQuantidadeDeExemplares() {
        return quantidadeDeExemplares;
    }

    public void setQuantidadeDeExemplares(int quantidadeDeExemplares) {
        this.quantidadeDeExemplares = quantidadeDeExemplares;
    }
}
