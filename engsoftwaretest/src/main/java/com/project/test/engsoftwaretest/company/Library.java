package com.project.test.engsoftwaretest.company;

import java.util.ArrayList;
import java.util.List;

import funcionalities.book.Book;
import funcionalities.student.Student;

public class Library {
	
	private List<Student> listaDeAlunos = new ArrayList<Student>();
	private List<Book> listaDeLivros = new ArrayList<Book>();
	
	Book book = new Book();
	
	public String salvarLivro(Book book) {
		
		listaDeLivros.add(book);
		
		if(listaDeLivros.size() > 0) {
		
			return "Sucesso";
			
		}else {
			
			return "Falha";
			
		}
		
	}
	
	public void Editar(int posicao, String nome, String autor, int anoDeCriacao) {
		
		if(listaDeLivros.size() > 0) {
			
			Book livroDaPosicao = listaDeLivros.get(posicao);
			livroDaPosicao.setNome(nome);
			livroDaPosicao.setAutor(autor);
			livroDaPosicao.setAnoDeCriacao(anoDeCriacao);
		
		}
		
	}

	public List<Book> getListaDeLivros() {
		return listaDeLivros;
	}

	public void setListaDeLivros(List<Book> listaDeLivros) {
		this.listaDeLivros = listaDeLivros;
	}
	
	

}
