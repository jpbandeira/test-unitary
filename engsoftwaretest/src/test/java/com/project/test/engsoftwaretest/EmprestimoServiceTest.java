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

	@Before
	public void setUp(){
		this.emprestimoService = new EmprestimoService();
		this.emprestimoModel = new EmprestimoModel();

		this.livroService = new LivroService();
		this.livroModel = new LivroModel("Senhor dos aneis", "Alguem", 2000);

		this.estudanteService = new EstudanteService();
		this.estudanteModel = new EstudanteModel("1710027", "Joao Pedro", "05646757339", "2007", 20, "joao@gmail.com");
	}

	@After
	public void afterTests() {
		this.estudanteService.limpa();
		this.livroService.limpa();
		this.emprestimoService.limpa();
	}

	@Test
    public void verificarMetodoParaAlugarLivro(){
		this.livroService.salvarLivro(livroModel);
		this.livroService.atualizarQuantidadeDeExemplares(livroModel, 3, "mais");
		this.estudanteService.salvarEstudante(estudanteModel);
	    assertEquals("Quando chamado o metodo para alugar livro, o mesmo deve retornar Sucesso",
                mensagemDeRetorno, this.emprestimoService.alugarLivro(livroModel, estudanteModel));
	    assertEquals("quando alugado um livro, a sua quantidade em estoque deve ser decrementada", 2, livroService.getListaDeLivros().get(0).getQuantidadeDeExemplares());
	    assertEquals("Quando um es estudante alugar um livro, o seu limite de emprestimos deve ser incrementado", 1,this.estudanteService.getListaDeEstudantes().get(0).getLimiteDeEmprestimos());
    }
}