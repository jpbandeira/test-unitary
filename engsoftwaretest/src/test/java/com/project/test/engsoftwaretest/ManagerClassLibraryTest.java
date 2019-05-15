package com.project.test.engsoftwaretest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import model.BibliotecaModel;
import model.EstudanteModel;
import model.LivroModel;

public class ManagerClassLibraryTest {
	
	LivroModel bookInstanceClass = null;
	EstudanteModel studentInstanceClass = null;
	BibliotecaModel libraryInstanceClass = null;
	
	@Before
	public void setup() {
		
		this.bookInstanceClass = Mockito.mock(LivroModel.class);
		this.libraryInstanceClass = new BibliotecaModel();
		
	}
	
	@Test
	public void processoParaSalvarLivroNaListaDeLivros() {
		
		this.libraryInstanceClass.SalvarLivro(1);
		assertEquals("quando chamado o metodo salvar, tem que retornar a mensagem sucesso", "Livro ja salvo na base de dados",libraryInstanceClass.SalvarLivro(bookInstanceClass.getId()));
		
	}

	/*@Test
	public void processoParaEditarLivroDaListaDeLivros() {
		
		String mensagemLivroEditado = this.libraryInstanceClass.EditarLivro("Joao", "Pedro", 2018);
		assertEquals("quando chamado o metodo editar, o mesmo tem que retornar sucesso", mensagemEsperada, mensagemLivroEditado);

		
//		assertEquals("verificando se o valor do atributo nome esta igual ao passado no parametro do meto editar" ,bookInstanceClass.getNome(), "Joao");
		
	}
	
	@Test
	public void processoParaInativarLivroDaListaDeLivros() {
		
		String mensagemLivroInativo = this.libraryInstanceClass.InativarLivro();
		assertEquals("quando chamado o metodo InativarLiveo, o mesmo tem que retornar Sucesso", mensagemEsperada, mensagemLivroInativo);
		
	}*/
}
