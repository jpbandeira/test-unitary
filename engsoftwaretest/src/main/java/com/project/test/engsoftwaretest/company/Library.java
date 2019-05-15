package com.project.test.engsoftwaretest.company;

import java.util.ArrayList;
import java.util.List;

import funcionalities.book.Book;
import funcionalities.student.Student;

public class Library {
	
	private List<Student> listaDeAlunos = new ArrayList<Student>();
	private List<Book> listaDeLivros = new ArrayList<Book>();
	
	Book book = new Book();
	
	public String SalvarLivro(Book book) {
		
		listaDeLivros.add(book);
		
		if(listaDeLivros.size() > 0) {
		
			return "Sucesso";
			
		}else {
			
			return "Falha";
			
		}
		
	}
	
	public String EditarLivro(String nome, String autor, int anoDeCriacao) {
		
		if(listaDeLivros.size() > 0) {
			
			for (Book book : listaDeLivros) {
				
				book.setNome(nome);
				book.setAutor(autor);
				book.setAnoDeCriacao(anoDeCriacao);
				
				return "Sucesso";
				
			}
		}
		
		return "Falha";
		
	}
	
	public String InativarLivro() {
		
		return "Sucesso";
		
	}
	

}
