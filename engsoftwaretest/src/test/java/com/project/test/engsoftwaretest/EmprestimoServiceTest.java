package com.project.test.engsoftwaretest;

import model.EmprestimoModel;
import model.EstudanteModel;
import model.LivroModel;
import org.junit.After;
import org.junit.Before;
import service.EmprestimoService;
import service.EstudanteService;
import service.LivroService;

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
		this.estudanteModel = new EstudanteModel();
	}

	@After
	public void afterTests() {
		this.estudanteService.limpa();
		this.livroService.limpa();
		this.emprestimoService.limpa();
	}

}