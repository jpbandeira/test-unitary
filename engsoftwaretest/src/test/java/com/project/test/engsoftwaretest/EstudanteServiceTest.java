/*
package com.project.test.engsoftwaretest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.EstudanteModel;
import service.EstudanteService;

public class EstudanteServiceTest {

	EstudanteModel estudanteModel;
	EstudanteService estudanteService;

	private String nomeEstudante = "Joao Pedro";
	private String cpfEstudante = "05646757339";
	private String rgEstudante = "2007";
	private int idadeEstudante = 20;
	private String mensagemesperada = "Sucesso";

	@Before
	public void setUpEstudante() {
		this.estudanteModel = new EstudanteModel(nomeEstudante, cpfEstudante, rgEstudante, idadeEstudante);
		this.estudanteService = new EstudanteService();
	}

	@After
	public void after(){
		estudanteService.limpa();
	}

	@Test
	public void processoParaSalvarEstudanteDaListaDeEstudantes() {
		assertEquals("se chamado o metodo salvarEstudante, o mesmo tem que retornar Sucesso",
				mensagemesperada, this.estudanteService.salvarEstudante(estudanteModel));
		assertEquals("Quando chamado o metodo para salvar estudante, o mesmo deve incrementar o id", 1, estudanteService.getListaDeEstudantes().get(idEstudante).getId());
	}

	@Test
	public void processoParaEditarAlunoDaListaDeEstudantes() {
		assertEquals("se chamado o metodo salvarEstudante, o mesmo tem que retornar Sucesso", mensagemesperada, this.estudanteService.salvarEstudante(estudanteModel));
		assertEquals("se chamado o metodo editarEstudante, o mesmo tem que retornar Sucesso",
				mensagemesperada, this.estudanteService.editarEstudante(estudanteService.getListaDeEstudantes().get(idEstudante).getId(), "Lucas", "05646757338", "2008", 22));
		assertEquals("Lucas" ,this.estudanteService.getListaDeEstudantes().get(idEstudante).getNome());
		assertEquals("05646757338", this.estudanteModel.getCpf());
		assertEquals("2008" ,this.estudanteModel.getRg());
		assertEquals(22, this.estudanteModel.getIdade());
	}

	@Test
	public void processoParainativarEstudantesDaListaDeEstudantes() {
		this.estudanteService.salvarEstudante(estudanteModel);
		assertEquals("se chamado o metodo inativarOuAtivar, o mesmo tem que retornar Sucesso",mensagemesperada,
				this.estudanteService.inativarEstudante(estudanteModel));
		assertEquals("Quando inativado ou ativado o estudante, o valor final do atributo deve ser ", false,
				this.estudanteModel.isAtivo());
	}

}
*/
