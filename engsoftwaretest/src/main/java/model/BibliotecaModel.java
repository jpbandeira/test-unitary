package model;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaModel {
	
	private List<EstudanteModel> listaDeAlunos = new ArrayList<EstudanteModel>();
	private List<LivroModel> listaDeLivros = new ArrayList<LivroModel>();
	
	public List<EstudanteModel> getListaDeAlunos() {
		return listaDeAlunos;
	}
	public void setListaDeAlunos(List<EstudanteModel> listaDeAlunos) {
		this.listaDeAlunos = listaDeAlunos;
	}
	public List<LivroModel> getListaDeLivros() {
		return listaDeLivros;
	}
	public void setListaDeLivros(List<LivroModel> listaDeLivros) {
		this.listaDeLivros = listaDeLivros;
	}
	
	
}
