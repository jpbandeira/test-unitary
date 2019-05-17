package com.project.test.engsoftwaretest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.EstudanteModel;
import service.EstudanteService;

public class EstudanteServiceTest {

	EstudanteModel estudanteModel = null;
	EstudanteService estudanteService = null;

	private String nomeEstudante = "Lucas";
	private String cpfEstudante = "05646757338";
	private String rgEstudante = "2008";
	private int idadeEstudante = 22;

	@Before
	public void setUpEstudante() {

		this.estudanteModel = new EstudanteModel("Joao Pedro", "05646757339", "2007", 20, true);
		this.estudanteService = new EstudanteService();

	}

	@Test
	public void processoParaSalvarEstudanteDaListaDeEstudantes() {

		this.estudanteService.salvarEstudante(estudanteModel);
		assertEquals("se chamado o metodo salvarEstudante, o mesmo tem que retornar o booleano true",
				this.estudanteService.getEstadoSalvo(), true);

	}

	@Test
	public void processoParaEditarAlunoDaListaDeEstudantes() {

		this.estudanteService.salvarEstudante(estudanteModel);
		this.estudanteService.editarEstudante(nomeEstudante, cpfEstudante, rgEstudante, idadeEstudante);

		assertEquals(this.estudanteModel.getNome(), "Lucas");
		assertEquals(this.estudanteModel.getCpf(), "05646757338");
		assertEquals(this.estudanteModel.getRg(), "2008");
		assertEquals(this.estudanteModel.getIdade(), 22);

		assertEquals("se chamado o metodo editarEstudante, o mesmo tem que retornar o booleano true",
				this.estudanteService.getEstadoSalvo(), true);

	}

	@Test
	public void processoParaInativarOuAtivarEstudantesDaListaDeEstudantes() {

		this.estudanteService.salvarEstudante(estudanteModel);
		assertEquals("se chamado o metodo inativarOuAtivar, o mesmo tem que retornar o booleano true",
				this.estudanteService.getEstadoSalvo(), true);

		assertEquals("quando inativado ou ativado o estudante, o valor final do atributo deve ser ", true,
				this.estudanteModel.isAitvoOuInativo());

	}

}
