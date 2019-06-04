package com.project.test.engsoftwaretest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.LivroModel;
import service.LivroService;

import static org.junit.Assert.*;

public class LivroServiceTest {

	LivroService livroService = null;
	LivroModel livroModel = null;
	LivroModel livroModel2 = null;

	String mensagemDeRetorno = "Sucesso";

	private int id = 0;
	private String nome = "Senhor do aneis";
	private String autor = "Alguem";
	private int anoDeCriacao = 2018;
	private int quantidadeDeExemplares = 10;

	@Before
	public void setup() {
		this.livroModel = new LivroModel();
		this.livroService = new LivroService();
	}

	@After
	public void after(){
		livroService.limpa();
	}

	@Test
	public void processoParaSalvarLivroNaListaDeLivros() {
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso e atribuir 1 para o id", mensagemDeRetorno, this.livroService.SalvarLivro(id, nome, autor, anoDeCriacao,quantidadeDeExemplares));
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso e atribuir 2 para o id", mensagemDeRetorno, this.livroService.SalvarLivro(id, nome, autor, anoDeCriacao,quantidadeDeExemplares));
		assertEquals("quando o salvo um livro, tem que ser somado o valor do seu ID", 2, this.livroService.getListaDeLivros().get(id).getId());
	}

	@Test
	public void processoParaEditarLivroDaListaDeLivros() {
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso  e atribuir 1 para o id", mensagemDeRetorno, this.livroService.SalvarLivro(this.id, nome, autor, anoDeCriacao,quantidadeDeExemplares));
		assertEquals(1, this.livroService.getListaDeLivros().get(id).getId());
		assertEquals("quando chamado o metodo editar, o mesmo tem que retornar sucesso", mensagemDeRetorno,
				this.livroService.EditarLivro( 1,"Senhor", "Pedro", 2018));
		assertEquals("verificando se o valor do atributo realmente foi editado", "Senhor", livroService.getListaDeLivros().get(id).getNome() );
	}

	@Test
	public void processoParaInativarLivroDaListaDeLivros() {

		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso  e atribuir 1 para o id", mensagemDeRetorno, this.livroService.SalvarLivro(id, nome, autor, anoDeCriacao,quantidadeDeExemplares));
		String mensagemLivroInativo = this.livroService.inativarLivro(this.id ,true);
		assertEquals("quando chamado o metodo InativarLiveo, o mesmo tem que retornar Sucesso", mensagemDeRetorno,
				mensagemLivroInativo);
		assertEquals("verificando se o valor final do atributo é true", true, this.livroService.getListaDeLivros().get(id).isInativar());

	}

	@Test
	public void processoParaAtualizarQuantidadeDeExemplares(){
		
	}
}
