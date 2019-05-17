package service;

import model.BibliotecaModel;
import model.LivroModel;

public class BibliotecaService {
	

	LivroModel livroModel = new LivroModel();
	BibliotecaModel bibliotecaModel = new BibliotecaModel();
	
	
	public String SalvarLivro(int id) {
		
		if(livroModel.getId() == id) {
			
			return "Livro ja salvo na base de dados";
			
		}else if(livroModel.getId() != id) {
		
			bibliotecaModel.getListaDeLivros.add(livroModel);
			
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
