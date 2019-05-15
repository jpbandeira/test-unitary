package com.project.test.engsoftwaretest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import funcionalities.book.Book;
import funcionalities.lending.Lending;
import funcionalities.student.Student;

public class ManagerClassLendingTest {

	Book bookInstanceClass = null;
	Student studentInstanceClass = null;
	Lending lendingInstanceClass = null;
	
	
	@Before
	public void setUpClass() {
		this.lendingInstanceClass = Mockito.mock(Lending.class);
	}

	
}
