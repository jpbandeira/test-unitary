package com.project.test.engsoftwaretest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.LivroModel;
import service.LivroService;

public class LivroServiceTest {

	LivroService livroService = null;
	LivroModel livroModel = null;

	String mensagemLivroNovoNaBase = "Sucesso";

	@Before
	public void setup() {

		this.livroModel = new LivroModel("Senhor dos Aneis", "Alguem1", 2018);
		this.livroService = new LivroService();

	}


	@Test
	public void processoParaSalvarLivroNaListaDeLivros() {

		this.livroService.SalvarLivro(livroModel);
		assertEquals("se o livro ja existir na base de dados, a mensagem de retorno tem que ser, Suceso",
				mensagemLivroNovoNaBase, livroService.SalvarLivro(livroModel));
		assertEquals("verificando se o valor final do atributo é 1", livroModel.getId(), 1);

	}

	@Test
	public void processoParaEditarLivroDaListaDeLivros() {

		this.livroService.SalvarLivro(livroModel);
		String mensagemLivroEditado = this.livroService.EditarLivro("Joao", "Pedro", 2018);
		assertEquals("quando chamado o metodo editar, o mesmo tem que retornar sucesso", mensagemLivroNovoNaBase,
				mensagemLivroEditado);

		assertEquals("verificando se o valor do atributo nome esta igual ao passado no parametro do meto editar",
				livroModel.getNome(), "Joao");

	}

	@Test
	public void processoParaInativarLivroDaListaDeLivros() {

		this.livroService.SalvarLivro(livroModel);
		String mensagemLivroInativo = this.livroService.inativarOuAtivarLivro(true);
		assertEquals("quando chamado o metodo InativarLiveo, o mesmo tem que retornar Sucesso", mensagemLivroNovoNaBase,
				mensagemLivroInativo);
		assertEquals("verificando se o valor final do atributo é true", livroModel.isAtivoOuInativo(), true);

	}

}
