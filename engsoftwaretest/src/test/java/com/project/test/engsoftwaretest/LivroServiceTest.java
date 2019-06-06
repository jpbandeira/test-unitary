package com.project.test.engsoftwaretest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.LivroModel;
import service.LivroService;

import static org.junit.Assert.*;

public class LivroServiceTest {

	LivroService livroService = null;
	LivroModel livro1 = null;
	LivroModel livro2 = null;

	String mensagemDeRetorno = "Sucesso";

	private String nome = "Senhor do aneis";
	private String autor = "Alguem";
	private int anoDeCriacao = 2018;
	private int getQuantidadeDeExemplaresASerAtualizado = 5;
	private String tipoDeOperacao = "mais";

	@Before
	public void setup() {
		this.livro1 = new LivroModel();
		this.livro2 = new LivroModel();
		this.livroService = new LivroService();
	}

	@After
	public void after(){
		livroService.limpa();
	}

	@Test
	public void processoParaSalvarLivroNaListaDeLivros() {
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.livroService.SalvarLivro(livro1));
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.livroService.SalvarLivro(livro2));
		assertEquals("quando o salvo um livro, tem que ser somado o valor do seu ID", 2, this.livro2.getId());
	}

	@Test
	public void processoParaEditarLivroDaListaDeLivros() {
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.livroService.SalvarLivro(livro1));
		assertEquals("quando chamado o metodo editar, o mesmo tem que retornar sucesso", mensagemDeRetorno,
				this.livroService.EditarLivro( livroService.getListaDeLivros().get(0).getId(),"Senhor", "Pedro", 2018));
		assertEquals("verificando se o valor do atributo realmente foi editado", "Senhor", livroService.getListaDeLivros().get(0).getNome() );
	}

	@Test
	public void processoParaInativarLivroDaListaDeLivros() {

		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.livroService.SalvarLivro(livro1));
		String mensagemLivroInativo = this.livroService.inativarLivro(livro1);
		assertEquals("quando chamado o metodo InativarLiveo, o mesmo tem que retornar Sucesso", mensagemDeRetorno,
				mensagemLivroInativo);
		assertEquals("verificando se o valor final do atributo é true", false, this.livroService.getListaDeLivros().get(0).isAtivo());

	}

	@Test
	public void processoParaAtualizarQuantidadeDeExemplares(){
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.livroService.SalvarLivro(livro1));
		assertEquals("quando chamado o metodo para atualizar quantidade de exeplares, o mesmo deve checar o tipo de operação e atuzalizar a quantidade dependendo do tipo necessario",
				"Sucesso", this.livroService.atualizarQuantidadeDeExemplares(this.livro1, getQuantidadeDeExemplaresASerAtualizado, tipoDeOperacao));
		assertEquals("quando chamado o metodo para atualizar quantidade de exemplares, o mesmo deve ir de 10 para 15",
				5, this.livroService.getListaDeLivros().get(0).getQuantidadeDeExemplares());
	}
}
