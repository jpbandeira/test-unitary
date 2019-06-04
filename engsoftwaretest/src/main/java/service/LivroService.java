package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.LivroModel;

public class LivroService {

	private List<LivroModel> listaDeLivros = new ArrayList<LivroModel>();

	private LivroModel livroModel;

	private int idLivro;
	private int quantidadeDeExemplares = 0;

	private String mensagemDeRetornoSucesso = "Sucesso";
	private String getMensagemDeRetornoFalha = "Falha";

	public String SalvarLivro(int id, String nome, String autor, int anoDeCriacao) {
		this.idLivro++;
		livroModel = new LivroModel(idLivro,false,nome, autor, anoDeCriacao);
		quantidadeDeExemplares++;
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

	public String inativarLivro(String nome, String autor, int anoDeCriacao, boolean inativar) {
		if(nome == this.livroModel.getNome() && autor == livroModel.getAutor() && anoDeCriacao == livroModel.getAnoDeCriacao()) {
			if (listaDeLivros.size() > 0) {
				for (LivroModel livroModel : listaDeLivros) {
					livroModel.setAtivo(inativar);
				}
				return mensagemDeRetornoSucesso;
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
