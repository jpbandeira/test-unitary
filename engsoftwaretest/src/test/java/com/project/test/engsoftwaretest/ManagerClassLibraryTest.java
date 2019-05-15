package com.project.test.engsoftwaretest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.project.test.engsoftwaretest.company.Library;

import funcionalities.book.Book;
import funcionalities.student.Student;

public class ManagerClassLibraryTest {
	
	Book bookInstanceClass = null;
	Student studentInstanceClass = null;
	Library libraryInstanceClass = null;
	private String mensagemEsperada = "Sucesso";
	
	@Before
	public void setup() {
		
		this.bookInstanceClass = Mockito.mock(Book.class);
		this.libraryInstanceClass = new Library();
		
		libraryInstanceClass.SalvarLivro(bookInstanceClass);
		
		
	}
	
	@Test
	public void processoParaSalvarLivroNaListaDeLivros() {
		
		assertEquals("quando chamado o metodo salvar, o mesmo tem que retornar a mensagem sucesso", mensagemEsperada,libraryInstanceClass.SalvarLivro(bookInstanceClass));
		
	}

	@Test
	public void processoParaEditarLivroDaListaDeLivros() {
		
		String mensagemLivroEditado = this.libraryInstanceClass.EditarLivro("Joao", "Pedro", 2018);
		assertEquals("quando chamado o metodo editar, o mesmo tem que retornar sucesso", mensagemEsperada, mensagemLivroEditado);
//		assertEquals("verificando se o valor do atributo nome esta igual ao passado no parametro do meto editar" ,bookInstanceClass.getNome(), "Joao");
		
	}
	
	@Test
	public void processoParaInativarLivroDaListaDeLivros() {
		
		String mensagemLivroInativo = this.libraryInstanceClass.InativarLivro();
		assertEquals("quando chamado o metodo InativarLiveo, o mesmo tem que retornar Sucesso", mensagemEsperada, mensagemLivroInativo);
		
	}
}
