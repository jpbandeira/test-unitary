package com.project.test.engsoftwaretest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import model.EmprestimoModel;
import model.EstudanteModel;
import model.LivroModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.EmprestimoService;
import service.EstudanteService;
import service.LivroService;

public class EmprestimoServiceTest {
    private String mensagemDeRetorno = "Sucesso";

	private EmprestimoService emprestimoService;
	private EmprestimoModel emprestimoModel;

	private LivroService livroService;
	private LivroModel livroModel;

	private EstudanteService estudanteService;
	private EstudanteModel estudanteModel;
	private EstudanteModel estudanteModel2;

	@Before
	public void setUp(){
		this.emprestimoService = new EmprestimoService();
		this.emprestimoModel = new EmprestimoModel();

		this.livroService = new LivroService();
		this.livroModel = new LivroModel("Senhor dos aneis", "Alguem", 2000);

		this.estudanteService = new EstudanteService();
		this.estudanteModel = new EstudanteModel("1710027", "Joao Pedro", "05646757339", "2007", 20, "joao@gmail.com");
		this.estudanteModel2 = new EstudanteModel("1710028", "Pedro", "05646757338", "2008", 21, "pedro@gmail.com");
	}

	@After
	public void afterTests() {
		this.estudanteService.limpa();
		this.livroService.limpa();
		this.emprestimoService.limpa();
	}

	@Test
    public void verificarRetornoMetodoParaAlugarLivro(){
		this.livroService.salvarLivro(livroModel);
		this.livroService.atualizarQuantidadeDeExemplares(livroModel, 4, "mais");
		this.estudanteService.salvarEstudante(estudanteModel);
	    assertEquals("Quando chamado o metodo para alugar livro, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.emprestimoService.alugarLivro(livroModel, estudanteModel));
    }

    @Test
	public void verificarLimiteDeEmprestimo(){
		this.livroService.salvarLivro(livroModel);
		this.livroService.atualizarQuantidadeDeExemplares(livroModel, 10, "mais");
		this.estudanteService.salvarEstudante(estudanteModel);
		this.estudanteService.salvarEstudante(estudanteModel2);

		this.emprestimoService.alugarLivro(livroModel, estudanteModel);
		this.emprestimoService.alugarLivro(livroModel, estudanteModel);
		this.emprestimoService.alugarLivro(livroModel, estudanteModel);

		this.emprestimoService.alugarLivro(livroModel, estudanteModel2);
		this.emprestimoService.alugarLivro(livroModel, estudanteModel2);
		this.emprestimoService.alugarLivro(livroModel, estudanteModel2);
		this.emprestimoService.alugarLivro(livroModel, estudanteModel2);

		assertEquals("Quando um es estudante1 alugar um livro, o seu limite de emprestimos deve ser incrementado", 3,this.estudanteService.getListaDeEstudantes().get(estudanteModel.getId() - 1).getLimiteDeEmprestimos());
		assertEquals("Quando um es estudante2 alugar um livro, o seu limite de emprestimos deve ser incrementado", 3,this.estudanteService.getListaDeEstudantes().get(estudanteModel2.getId() - 1).getLimiteDeEmprestimos());
	}

	@Test
	public void verificarRetornoDoMetodoReserva(){
		this.livroService.salvarLivro(livroModel);
		this.livroService.atualizarQuantidadeDeExemplares(livroModel, 0, "mais");
		this.estudanteService.salvarEstudante(estudanteModel);
		this.estudanteService.salvarEstudante(estudanteModel2);
		this.emprestimoService.reservarLivro(livroModel, estudanteModel);
		assertEquals("qunado chamado, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.emprestimoService.reservarLivro(livroModel, estudanteModel2));
		assertEquals("quando reservado um livro, o atributo livroResercado tem que ter como valor true", true, livroService.getListaDeLivros().get(livroModel.getId() - 1).isLivroReservado());
	}

}