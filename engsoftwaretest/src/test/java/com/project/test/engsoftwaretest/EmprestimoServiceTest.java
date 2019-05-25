package com.project.test.engsoftwaretest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.EmprestimoModel;
import model.EstudanteModel;
import model.LivroModel;
import service.EmprestimoService;
import service.EstudanteService;
import service.LivroService;

public class EmprestimoServiceTest{

    private EstudanteService estudanteService = null;
    private EstudanteModel estudanteModel = null;
    private LivroService livroService = null;
    private LivroModel livroModel = null;


    private EmprestimoService emprestimoService = null;
    private EmprestimoModel emprestimoModel = null;

    @Before
    public void setUpEmprestimo(){

        emprestimoModel = new EmprestimoModel();
        emprestimoService = new EmprestimoService();

    }

    @Test
    public void processoParaAlugarLivro(){

        this.emprestimoService.alugarLivro();
       // assertEquals("quando chamado o metodo alugarLivro, o mesmo deve retornar true", true, this.emprestimoService.alugarLivro());

    }
}
