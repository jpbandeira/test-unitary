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

	private int id = 1;
	private String nome = "Senhor do aneis";
	private String autor = "Alguem";
	private int anoDeCriacao = 2018;
	private int getQuantidadeDeExemplaresASerAtualizado = 5;
	private String tipoDeOperacao = "mais";

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
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.livroService.SalvarLivro(livroModel));
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.livroService.SalvarLivro(livroModel));
		assertEquals("quando o salvo um livro, tem que ser somado o valor do seu ID", 2, this.livroService.getListaDeLivros().get(id).getId());
	}

	@Test
	public void processoParaEditarLivroDaListaDeLivros() {
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.livroService.SalvarLivro(livroModel));
		assertEquals(1, this.livroService.getListaDeLivros().get(id).getId());
		assertEquals("quando chamado o metodo editar, o mesmo tem que retornar sucesso", mensagemDeRetorno,
				this.livroService.EditarLivro( 1,"Senhor", "Pedro", 2018));
		assertEquals("verificando se o valor do atributo realmente foi editado", "Senhor", livroService.getListaDeLivros().get(id).getNome() );
	}

	@Test
	public void processoParaInativarLivroDaListaDeLivros() {

		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.livroService.SalvarLivro(livroModel));
		String mensagemLivroInativo = this.livroService.inativarLivro(this.id ,true);
		assertEquals("quando chamado o metodo InativarLiveo, o mesmo tem que retornar Sucesso", mensagemDeRetorno,
				mensagemLivroInativo);
		assertEquals("verificando se o valor final do atributo é true", true, this.livroService.getListaDeLivros().get(id).isAtivo());

	}

	@Test
	public void processoParaAtualizarQuantidadeDeExemplares(){
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.livroService.SalvarLivro(livroModel));
		assertEquals("quando chamado o metodo para atualizar quantidade de exeplares, o mesmo deve checar o tipo de operação e atuzalizar a quantidade dependendo do tipo necessario",
				"Sucesso", this.livroService.atualizarQuantidadeDeExemplares(id, getQuantidadeDeExemplaresASerAtualizado, tipoDeOperacao));
		assertEquals("quando chamado o metodo para atualizar quantidade de exemplares, o mesmo deve ir de 10 para 15",
				6, this.livroService.getListaDeLivros().get(id).getQuantidadeDeExemplares());
	}
}
