package com.project.test.engsoftwaretest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.EstudanteModel;
import service.EstudanteService;

public class EstudanteServiceTest {

    private String mensagemDeRetorno = "Sucesso";
	EstudanteModel estudanteModel;
	EstudanteService estudanteService;

	@Before
	public void setUpEstudante() {
		this.estudanteModel = new EstudanteModel("1710027","Joao Pedro", "05646757339", "2007", 20, "joaopedro@gmail.com");
		this.estudanteService = new EstudanteService();
	}

	@After
	public void after(){
		estudanteService.limpa();
	}

	@Test
	public void processoParaSalvarEstudanteDaListaDeEstudantes() {
		assertEquals("se chamado o metodo salvarEstudante, o mesmo tem que retornar Sucesso",
                mensagemDeRetorno, this.estudanteService.salvarEstudante(estudanteModel));
		assertEquals("Quando chamado o metodo para salvar estudante, o mesmo deve incrementar o id", 1, estudanteService.getListaDeEstudantes().get(estudanteModel.getId() - 1).getId());
	}

    @Test
    public void processoParaEditarLivroDaListaDeLivros() {
        this.estudanteService.salvarEstudante(estudanteModel);
        assertEquals("Quando chamado o metodo editar, o mesmo tem que retornar sucesso", mensagemDeRetorno,
                this.estudanteService.EditarEstudante(estudanteService.getListaDeEstudantes().get(estudanteModel.getId() - 1).getId(), "1710027","Pedro", "05646757339", "2007", 20, "pedro@gmail.com"));
        assertEquals("quando editado, o valor deve ser alterado no atributo do estudante", "Pedro", estudanteService.getListaDeEstudantes().get(estudanteModel.getId() - 1).getNome());
    }

    @Test
    public void processoParaInativarLivroDaListaDeLivros() {
        assertEquals("Quando chamado o metodo salvar estudante, o mesmo deve retornar Sucesso", mensagemDeRetorno, this.estudanteService.salvarEstudante(estudanteModel));
        assertEquals("Quando chamado o metodo inativarLivro, o mesmo tem que retornar Sucesso", mensagemDeRetorno,
                this.estudanteService.inativarEstudante(estudanteModel));
        assertEquals("Verificando se o valor final do atributo é false", false, this.estudanteService.getListaDeEstudantes().get(estudanteModel.getId() - 1).isAtivo());
    }

}
