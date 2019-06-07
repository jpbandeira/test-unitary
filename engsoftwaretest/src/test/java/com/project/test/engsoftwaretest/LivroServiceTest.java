package com.project.test.engsoftwaretest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.LivroModel;
import service.LivroService;

import static org.junit.Assert.*;

public class LivroServiceTest {

	private LivroService livroService = null;
	private LivroModel livro1 = null;
	private LivroModel livro2 = null;

	private String mensagemDeRetorno = "Sucesso";

	private String nome = "Senhor do aneis";
	private String autor = "Alguem";
	private int anoDeCriacao = 2018;
	private int getQuantidadeDeExemplaresASerAtualizado = 5;
	private String tipoDeOperacao = "mais";

	@Before
	public void setup() {
		this.livro1 = new LivroModel(nome, autor, anoDeCriacao);
		this.livro2 = new LivroModel();
		this.livroService = new LivroService();
	}

	@After
	public void after(){
		livroService.limpa();
	}

	@Test
	public void processoParaSalvarLivroNaListaDeLivros() {
		assertEquals("Quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.livroService.SalvarLivro(livro1));
		//assertEquals("Quando Chamado o metodo alugar livro, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.livroService.SalvarLivro(livro2));
		assertEquals("Quando o salvo um livro, tem que ser somado o valor do seu ID de 1 para 2", 1, this.livroService.getListaDeLivros().get(0).getId());
		assertEquals("Quando chamado o metodo salvar, o mesmo deve ser o livro como ativo", true, this.livroService.getListaDeLivros().get(0).isAtivo());
	}

	@Test
	public void processoParaEditarLivroDaListaDeLivros() {
		assertEquals("Quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.livroService.SalvarLivro(livro1));
		assertEquals("Quando chamado o metodo editar, o mesmo tem que retornar sucesso", mensagemDeRetorno,
				this.livroService.EditarLivro( livroService.getListaDeLivros().get(0).getId(),"Senhor", "Pedro", 2018));
		assertEquals("Verificando se o valor do atributo realmente foi editado", "Senhor", livroService.getListaDeLivros().get(0).getNome());
	}

	@Test
	public void processoParaInativarLivroDaListaDeLivros() {
		assertEquals("Quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.livroService.SalvarLivro(livro1));
		String mensagemLivroInativo = this.livroService.inativarLivro(livro1);
		assertEquals("Quando chamado o metodo inativarLivro, o mesmo tem que retornar Sucesso", mensagemDeRetorno,
				mensagemLivroInativo);
		assertEquals("Verificando se o valor final do atributo é false", false, this.livroService.getListaDeLivros().get(0).isAtivo());
	}

	@Test
	public void processoParaAtualizarQuantidadeDeExemplares(){
		assertEquals("Quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.livroService.SalvarLivro(livro1));
		assertEquals("Quando chamado o metodo para atualizar quantidade de exeplares retornar Sucesso",
				"Sucesso", this.livroService.atualizarQuantidadeDeExemplares(this.livro1, getQuantidadeDeExemplaresASerAtualizado, tipoDeOperacao));
		assertEquals("Quando chamado o metodo para atualizar quantidade de exemplares, o mesmo deve ir de 0 para 5",
				5, this.livroService.getListaDeLivros().get(0).getQuantidadeDeExemplares());
	}
}
