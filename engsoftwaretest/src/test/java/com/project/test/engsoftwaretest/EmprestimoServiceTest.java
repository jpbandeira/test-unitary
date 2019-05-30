package com.project.test.engsoftwaretest;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.EmprestimoModel;
import model.LivroModel;
import service.EmprestimoService;

public class EmprestimoServiceTest {
	
	private EmprestimoService emprestimoService;
	private EmprestimoModel emprestimoModel;
	
	private LivroModel livroModel;
	
	@Before
	public void setUp(){
		
		this.emprestimoService = new EmprestimoService();
		this.livroModel = new LivroModel();
	}
	
	@Test
	public void verificarSeUmLivroFoiAlugado() {
		
		this.emprestimoService.alugarLivro(livroModel);
		assertEquals("verificando se o metodo retornar true", this.emprestimoService.alugarLivro(livroModel), true);
		
	}

}
