package com.project.test.engsoftwaretest;

import org.junit.After;
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

	private EmprestimoService emprestimoService;
	private EmprestimoModel emprestimoModel;

	private LivroService livroService;
	private LivroModel livroModel;

	private EstudanteService estudanteService;
	private EstudanteModel estudanteModel;

	@Before
	public void setUp(){
		this.emprestimoService = new EmprestimoService();
		this.emprestimoModel = new EmprestimoModel();

		this.livroService = new LivroService();
		this.livroModel = new LivroModel();

		this.estudanteService = new EstudanteService();
		this.estudanteModel = new EstudanteModel("Joao", "05646757339", "0011", 20, true);

	}

	@After
	public void afterTests() {
		this.estudanteService.limpa();
		this.livroService.limpa();
		this.emprestimoService.limpa();
	}

	@Test
	public void verificarSeUmLivroFoiAlugado() {
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar como mensagaem true", "Sucesso", this.emprestimoService.alugarLivro(livroModel));
	}

	@Test
	public void verificarSeUmLivroJaAlugadoEstaSetadoComTrue(){
		this.emprestimoService.alugarLivro(livroModel);
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve retornar como mensagaem Sucesso", "Sucesso", this.emprestimoService.alugarLivro(livroModel));
		assertEquals("verificar se o atributo de alugadoOuNao esta como true para true", true, this.livroModel.isLivroAlugado());
	}

	@Test
	public void verificarSeOLimiteDeEmprestimoEstaSendoSomado(){
		this.emprestimoService.alugarLivro(livroModel);
		assertEquals("quando chamado o metodo alugar livro, o mesmo deve soma o atrinuto de limite de emprestimo",
				1, this.estudanteModel.getLimiteDeEmprestimos());
	}

	@Test
	public void verificaEntradaDoMetodoReservado(){
		assertEquals("quando chamado, o atributo retornoParaTeste tem que ser true", "Sucesso", this.emprestimoService.reservarLivro(livroModel));
	}

	@Test
	public void verificarSeUmLivroJaReservadoEstaSetadoParaTrue(){
		this.emprestimoService.reservarLivro(livroModel);
		assertEquals("quando chamado, o atributo retornoParaTeste tem que ser true", "Sucesso", this.emprestimoService.reservarLivro(livroModel));
		assertEquals("quando solicitada reserva do livro novamente, o mesmo deve mostrar a mensagem de verificação e retornar true", true, this.livroModel.isLivroReservado());
	}

	@Test
	public void veririficarMetodoParaAplicacaoDeMulta(){
		assertEquals("quando chamado, o mesmo deve retornar como mensagem Sucesso", "Sucesso", this.emprestimoService.aplicarMulta());
	}
}
