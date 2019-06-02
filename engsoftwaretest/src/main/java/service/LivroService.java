package service;

import java.util.ArrayList;
import java.util.List;

import model.LivroModel;

public class LivroService {

	private List<LivroModel> listaDeLivros = new ArrayList<LivroModel>();

	private String mensagemDeRetornoSucesso = "Sucesso";
	private String getMensagemDeRetornoFalha = "Falha";

	public String SalvarLivro(LivroModel livroModel) {
		listaDeLivros.add(livroModel);
		livroModel.setQuantidadeDeExemplares(livroModel.getQuantidadeDeExemplares()+1);
		return mensagemDeRetornoSucesso;
	}

	public String EditarLivro(String nome, String autor, int anoDeCriacao) {
		if (listaDeLivros.size() > 0) {
			for (LivroModel livroModel : listaDeLivros) {
				livroModel.setNome(nome);
				livroModel.setAutor(autor);
				livroModel.setAnoDeCriacao(anoDeCriacao);
			}
			return mensagemDeRetornoSucesso;
		}
		return getMensagemDeRetornoFalha;
	}

	public String inativarOuAtivarLivro(boolean ativoOuInativo) {
		if (listaDeLivros.size() > 0) {
			for (LivroModel livroModel : listaDeLivros) {
				livroModel.setAtivoOuInativo(ativoOuInativo);
			}
			return mensagemDeRetornoSucesso;
		}
		return getMensagemDeRetornoFalha;
	}


	public void limpa() {
		this.listaDeLivros.clear();
	}
}
