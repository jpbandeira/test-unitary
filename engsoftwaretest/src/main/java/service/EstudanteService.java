package service;

import java.util.ArrayList;
import java.util.List;

import model.EstudanteModel;

public class EstudanteService {

	private List<EstudanteModel> listaDeEstudantes = new ArrayList<EstudanteModel>();

	private boolean estadoMetodo;

	public boolean getEstadoSalvo() {

		return this.estadoMetodo;

	}

	public void salvarEstudante(EstudanteModel estudanteModel) {

		logicaParaSalvarEstudanteNaLista(estudanteModel);

	}

	public void editarEstudante(String nome, String cpf, String rg, int idade) {

		logicaDeEdicaoDeEstudante(nome, cpf, rg, idade);

	}

	public void inativarOuAtivarEstudante(boolean ativoOuInativo) {

		logicaParaInativarOuAtivarEstudanteDaLista(ativoOuInativo);

	}

	private void logicaDeEdicaoDeEstudante(String nome, String cpf, String rg, int idade) {
		if (this.listaDeEstudantes.size() > 0) {
			for (EstudanteModel estudanteModel : listaDeEstudantes) {
				estudanteModel.setNome(nome);
				estudanteModel.setCpf(cpf);
				estudanteModel.setRg(rg);
				estudanteModel.setIdade(idade);
			}
			estadoMetodo = true;
		} else {
			estadoMetodo = false;
		}
	}

	private void logicaParaSalvarEstudanteNaLista(EstudanteModel estudanteModel) {

		listaDeEstudantes.add(estudanteModel);

		estadoMetodo = true;

	}

	private void logicaParaInativarOuAtivarEstudanteDaLista(boolean ativoOuInativo) {

		if (this.listaDeEstudantes.size() > 0) {

			for (EstudanteModel estudanteModel : listaDeEstudantes) {

				estudanteModel.setAitvoOuInativo(ativoOuInativo);

			}

			estadoMetodo = true;

		} else {

			estadoMetodo = false;

		}

	}

}
