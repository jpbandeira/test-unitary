package model;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaModel {
	
	private List<EstudanteModel> listaDeAlunos = new ArrayList<EstudanteModel>();
	private List<LivroModel> listaDeLivros = new ArrayList<LivroModel>();
	
	LivroModel livroModel = new LivroModel();
	
	public String SalvarLivro(int id) {
		
		if(livroModel.getId() == id) {
			
			return "Livro ja salvo na base de dados";
			
		}else if(livroModel.getId() != id) {
		
			listaDeLivros.add(livroModel);
			return "Sucesso";
			
		}else {
		
			return "Falha";
			
		}
		
	}
	
	public String EditarLivro(String nome, String autor, int anoDeCriacao) {
		
		if(listaDeLivros.size() > 0) {
			
			for (LivroModel livroModel : listaDeLivros) {
				
				livroModel.setNome(nome);
				livroModel.setAutor(autor);
				livroModel.setAnoDeCriacao(anoDeCriacao);
				
				return "Sucesso";
				
			}
		}
		
		return "Falha";
		
	}
	
	public String InativarLivro() {
		
		return "Sucesso";
		
	}	

}
