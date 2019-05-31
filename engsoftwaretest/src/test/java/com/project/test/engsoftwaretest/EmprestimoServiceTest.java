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
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar como mensagaem true", true, this.emprestimoService.isRetornoParaTeste());
	}

	@Test
	public void verificarSeUmLivroJaAlugadoEstaSetadoComTrue(){
		this.emprestimoService.alugarLivro(livroModel);
		this.emprestimoService.alugarLivro(livroModel);
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar como mensagaem true", true, this.emprestimoService.isRetornoParaTeste());
		assertEquals("verificar se o metodo tem que setar o atributo de alugadoOuNao para true", true, this.livroModel.isLivroAlugadoOuNao());
	}

	@Test
	public void verificaEntradaDoMetodoReservado(){
		this.emprestimoService.reservarLivro(livroModel);
		assertEquals("quando chamado, o atributo retornoParaTeste tem que ser true", true, this.emprestimoService.isRetornoParaTeste());
	}

	@Test
	public void verificarSeUmLivroJaReservadoEstaSetadoParaTrue(){
		this.emprestimoService.reservarLivro(livroModel);
		this.emprestimoService.reservarLivro(livroModel);
		assertEquals("quando chamado, o atributo retornoParaTeste tem que ser true", true, this.emprestimoService.isRetornoParaTeste());
		assertEquals("quando solicitada reserva do livro novamente, o mesmo deve mostrar a mensagem de verificação e retornar true", true, this.livroModel.isLivroReservadoOuNao());
	}

}
