package com.project.test.engsoftwaretest;

import static org.junit.Assert.assertEquals;

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

    private String matricula = "1710027";
	private String nomeEstudante = "Joao Pedro";
	private String cpfEstudante = "05646757339";
	private String rgEstudante = "2007";
	private int idadeEstudante = 20;
	private String email = "joao@pedro.com";

	private String nome = "Senhor do aneis";
	private String autor = "Alguem";
	private int anoDeCriacao = 2018;

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
		this.livroModel = new LivroModel(nome, autor, anoDeCriacao);

		this.estudanteService = new EstudanteService();
		this.estudanteModel = new EstudanteModel(matricula,nomeEstudante, cpfEstudante, rgEstudante, idadeEstudante, email);
	}

	@After
	public void afterTests() {
		this.estudanteService.limpa();
		this.livroService.limpa();
		this.emprestimoService.limpa();
	}

	@Test
    public void verificarMetodoParaAlugarLivro(){
		this.livroService.SalvarLivro(livroModel);
	    assertEquals("Quando chamado o metodo para alugar livro, o mesmo deve retornar Sucesso",
                mensagemDeRetorno, this.emprestimoService.alugarLivro(livroModel));
    }
}