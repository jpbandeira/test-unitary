package service;

import java.util.ArrayList;
import java.util.List;

import model.LivroModel;

public class LivroService {

	private List<LivroModel> listaDeLivros = new ArrayList<LivroModel>();

	public String SalvarLivro(LivroModel livroModel) {

		listaDeLivros.add(livroModel);
		livroModel.setQuantidadeDeExemplares(livroModel.getQuantidadeDeExemplares()+1);
		return "Sucesso";

	}

	public String EditarLivro(String nome, String autor, int anoDeCriacao) {

		if (listaDeLivros.size() > 0) {

			for (LivroModel livroModel : listaDeLivros) {

				livroModel.setNome(nome);
				livroModel.setAutor(autor);
				livroModel.setAnoDeCriacao(anoDeCriacao);

			}

			return "Sucesso";

		}

		return "Falha";

	}

	public String inativarOuAtivarLivro(boolean ativoOuInativo) {

		if (listaDeLivros.size() > 0) {

			for (LivroModel livroModel : listaDeLivros) {

				livroModel.setAtivoOuInativo(ativoOuInativo);

			}

			return "Sucesso";

		}

		return "Falha";

	}

}
