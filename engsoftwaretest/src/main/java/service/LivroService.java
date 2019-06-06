package service;

import java.util.ArrayList;
import java.util.List;

import model.LivroModel;

public class LivroService {

	private List<LivroModel> listaDeLivros = new ArrayList<LivroModel>();

	private int quantidadeDeExemplares;
	private Integer id;
	private String tipoDeAtualizacao;
	private String mensagemDeRetornoSucesso = "Sucesso";
	private String getMensagemDeRetornoFalha = "Falha";

	public String SalvarLivro(LivroModel livroModel) {
		livroModel.setAtivo(true);
		this.id = listaDeLivros.isEmpty() ? 1 : listaDeLivros.get(listaDeLivros.size() - 1).getId() + 1;
		livroModel.setId(id);
		listaDeLivros.add(livroModel);
		return mensagemDeRetornoSucesso;
	}

	public String EditarLivro(int id ,String nome, String autor, int anoDeCriacao) {
			if (listaDeLivros.size() > 0) {
				for (LivroModel livroModel : listaDeLivros) {
					if(id == livroModel.getId()){
						livroModel.setNome(nome);
						livroModel.setAutor(autor);
						livroModel.setAnoDeCriacao(anoDeCriacao);
						return mensagemDeRetornoSucesso;
					}
				}
			}
		return getMensagemDeRetornoFalha;
	}

	public String inativarLivro(LivroModel livro) {
			if (listaDeLivros.size() > 0) {
				for (LivroModel livroModel : listaDeLivros) {
					if(livro.isAtivo() == false) {
						livro.setAtivo(true);
					}else if(livro.isAtivo() == true){
						livro.setAtivo(false);
					}
				}
				return mensagemDeRetornoSucesso;
			}
		return getMensagemDeRetornoFalha;
	}

	public String atualizarQuantidadeDeExemplares(LivroModel livro ,int quantidadeASerAtualizado, String tipoDeAtualizacao){
		int quantidadeFinal;
		for (LivroModel livroModel : listaDeLivros) {
			if (id == livro.getId()) {
				if (quantidadeASerAtualizado > 0) {
					if (tipoDeAtualizacao.equals("mais")) {
						quantidadeFinal = livro.getQuantidadeDeExemplares() + quantidadeASerAtualizado;
						livro.setQuantidadeDeExemplares(quantidadeFinal);
						return mensagemDeRetornoSucesso;
					} else if (tipoDeAtualizacao.equals("menos")) {
						quantidadeFinal = livro.getQuantidadeDeExemplares() - quantidadeASerAtualizado;
						livro.setQuantidadeDeExemplares(quantidadeFinal);
						return mensagemDeRetornoSucesso;
					} else {
						quantidadeFinal = livro.getQuantidadeDeExemplares() * 0;
						livro.setQuantidadeDeExemplares(quantidadeFinal);
						return mensagemDeRetornoSucesso;
					}
				}
			}
		}
		return getMensagemDeRetornoFalha;
	}

	public List<LivroModel> getListaDeLivros() {
		return listaDeLivros;
	}

	public void limpa() {
		this.listaDeLivros.clear();
	}
}