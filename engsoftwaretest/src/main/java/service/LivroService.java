package service;

import java.util.ArrayList;
import java.util.List;

import model.LivroModel;

public class LivroService {

	private List<LivroModel> listaDeLivros = new ArrayList<LivroModel>();

	private LivroModel livroModel;

	//private int idLivro;
	private int quantidadeDeExemplares = 0;

	private String mensagemDeRetornoSucesso = "Sucesso";
	private String getMensagemDeRetornoFalha = "Falha";

	public String SalvarLivro(int id, String nome, String autor, int anoDeCriacao, int quantidadeDeExemplares) {
		id++;
		this.quantidadeDeExemplares += quantidadeDeExemplares;
		livroModel = new LivroModel(id,false,nome, autor, anoDeCriacao, quantidadeDeExemplares);
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

	public String inativarLivro(int id , boolean inativar) {
			if (listaDeLivros.size() > 0) {
				for (LivroModel livroModel : listaDeLivros) {
				if(id == livroModel.getId()) {
						livroModel.setInativar(inativar);
					}
				}
				return mensagemDeRetornoSucesso;
			}
		return getMensagemDeRetornoFalha;
	}

	public String atualizarQuantidadeDeExemplares(int id, int quantidadeASerAtualizado){
		int quantidadeAtualizado;
		for (LivroModel livroModel : listaDeLivros){
			if (id == livroModel.getId() && quantidadeASerAtualizado <= 0) {
				if (quantidadeASerAtualizado == this.livroModel.getQuantidadeDeExemplares()) {
					return mensagemDeRetornoSucesso;
				} else if (quantidadeASerAtualizado > this.livroModel.getQuantidadeDeExemplares()) {
					this.quantidadeDeExemplares += quantidadeASerAtualizado;
					this.livroModel.setQuantidadeDeExemplares(this.quantidadeDeExemplares);
					return mensagemDeRetornoSucesso;
				} else if (quantidadeASerAtualizado < this.livroModel.getQuantidadeDeExemplares()) {
					this.quantidadeDeExemplares -= quantidadeASerAtualizado;
					this.livroModel.setQuantidadeDeExemplares(this.quantidadeDeExemplares);
					return mensagemDeRetornoSucesso;
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