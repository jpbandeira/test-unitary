package service;

import java.util.ArrayList;
import java.util.List;

import model.LivroModel;

public class LivroService {

	private List<LivroModel> listaDeLivros = new ArrayList<LivroModel>();

	private LivroModel livroModel;

	private int idLivro;
	private static int quantidadeDeExemplares = 0;

	private String mensagemDeRetornoSucesso = "Sucesso";
	private String getMensagemDeRetornoFalha = "Falha";

	public String SalvarLivro(int id, String nome, String autor, int anoDeCriacao) {
	 	this.idLivro = id++;
		this.quantidadeDeExemplares++;
		livroModel = new LivroModel(idLivro,false,nome, autor, anoDeCriacao);
		livroModel.setQuantidadeDeExemplares(quantidadeDeExemplares);
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

	public String atualizarQuantidadeDeExemplares(int id, int quantidadeASerAtualizado, String tipoDeAtualizacao){
		int quantidadeFinal;
		for (LivroModel livroModel : listaDeLivros){
			if (id == livroModel.getId() && quantidadeASerAtualizado > 0) {
				if(tipoDeAtualizacao.equals("mais")){
					quantidadeFinal = this.livroModel.getQuantidadeDeExemplares() + quantidadeASerAtualizado;
					this.livroModel.setQuantidadeDeExemplares(quantidadeFinal);
					return mensagemDeRetornoSucesso;
				}else if(tipoDeAtualizacao.equals("menos")){
					quantidadeFinal = this.livroModel.getQuantidadeDeExemplares() - quantidadeASerAtualizado;
					this.livroModel.setQuantidadeDeExemplares(quantidadeFinal);
					return mensagemDeRetornoSucesso;
				}else {
					quantidadeFinal = this.livroModel.getQuantidadeDeExemplares() * 0;
					this.livroModel.setQuantidadeDeExemplares(quantidadeFinal);
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