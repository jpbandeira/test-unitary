package com.project.test.engsoftwaretest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import model.EmprestimoModel;
import model.EstudanteModel;
import model.LivroModel;

public class ManagerClassLendingTest {

	LivroModel bookInstanceClass = null;
	EstudanteModel studentInstanceClass = null;
	EmprestimoModel lendingInstanceClass = null;
	
	
	@Before
	public void setUpClass() {
		this.lendingInstanceClass = Mockito.mock(EmprestimoModel.class);
	}

	
}
