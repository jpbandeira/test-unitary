package com.project.test.engsoftwaretest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.LivroModel;
import service.LivroService;

public class LivroServiceTest {

	LivroService livroService = null;
	LivroModel livroModel = null;
	LivroModel livroModel2 = null;

	String mensagemDeRetorno = "Sucesso";

	private int id = 0;
	private String nome = "Senhor do aneis";
	private String autor = "Alguem";
	private int anoDeCriacao = 2018;

	@Before
	public void setup() {
		this.livroModel = new LivroModel();
		this.livroService = new LivroService();
	}


	@Test
	public void processoParaSalvarLivroNaListaDeLivros() {
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso e atribuir 1 para o id", mensagemDeRetorno, this.livroService.SalvarLivro(id, nome, autor, anoDeCriacao));
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso e atribuir 2 para o id", mensagemDeRetorno, this.livroService.SalvarLivro(id, nome, autor, anoDeCriacao));
		assertEquals("quando o salvo um livro, tem que ser somado o valor do seu ID", 2, this.livroService.getListaDeLivros().get(id).getId());
	}

	@Test
	public void processoParaEditarLivroDaListaDeLivros() {
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar Sucesso  e atribuir 1 para o id", mensagemDeRetorno, this.livroService.SalvarLivro(id, nome, autor, anoDeCriacao));
		assertEquals("quando chamado o metodo editar, o mesmo tem que retornar sucesso", mensagemDeRetorno,
				this.livroService.EditarLivro( 1,"Joao", "Pedro", 2018));
		assertEquals("verificando se o valor do atributo realmente foi editado", livroService.getListaDeLivros().get(id).getNome(), "Joao");
	}
/*
	@Test
	public void processoParaInativarLivroDaListaDeLivros() {

		this.livroService.SalvarLivro(livroModel);
		String mensagemLivroInativo = this.livroService.inativarOuAtivarLivro(true);
		assertEquals("quando chamado o metodo InativarLiveo, o mesmo tem que retornar Sucesso", mensagemDeRetorno,
				mensagemLivroInativo);
		assertEquals("verificando se o valor final do atributo é true", livroModel.isAtivo(), true);

	}*/
}
