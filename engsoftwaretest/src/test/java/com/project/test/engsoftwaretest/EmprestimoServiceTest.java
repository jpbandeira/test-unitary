package com.project.test.engsoftwaretest;

import org.junit.Before;
import org.junit.Test;
import model.EmprestimoModel;
import model.EstudanteModel;
import model.LivroModel;
import service.EmprestimoService;
import service.EstudanteService;
import service.LivroService;

import static org.junit.Assert.assertEquals;

public class EmprestimoServiceTest {
	
	private EmprestimoService emprestimoService = null;
	private EmprestimoModel emprestimoModel = null;

	private LivroService livroService = null;
	private LivroModel livroModel = null;

	private EstudanteService estudanteService = null;
	private EstudanteModel estudanteModel = null;

	
	@Before
	public void setUp(){
		this.emprestimoService = new EmprestimoService();

		this.livroService = new LivroService();
		this.livroModel = new LivroModel();

		this.estudanteService = new EstudanteService();

		this.livroModel.setLivroAlugadoOuNao(false);
	}
	
	@Test
	public void verificarSeUmLivroFoiAlugado() {
		
		this.emprestimoService.alugarLivro(livroModel);
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve setar true para o atributo livroAlugadoOuNao", true, this.livroModel.isLivroAlugadoOuNao());
		
	}

}
