package service;

import java.util.ArrayList;
import java.util.List;

import model.EstudanteModel;

public class EstudanteService {

	private List<EstudanteModel> listaDeEstudantes = new ArrayList<EstudanteModel>();

	private String mensagemDeRetornoSucesso = "Sucesso";
	private String mensagemDeRetornoFalha = "Falha";

	public String salvarEstudante(EstudanteModel estudanteModel) {

		listaDeEstudantes.add(estudanteModel);
		return mensagemDeRetornoSucesso;

	}

	public String editarEstudante(String nome, String cpf, String rg, int idade) {
		if (this.listaDeEstudantes.size() > 0) {
			for (EstudanteModel estudanteModel : listaDeEstudantes) {
				estudanteModel.setNome(nome);
				estudanteModel.setCpf(cpf);
				estudanteModel.setRg(rg);
				estudanteModel.setIdade(idade);
			}
			return mensagemDeRetornoSucesso;
		} else {
			return mensagemDeRetornoFalha;
		}
	}

	public String inativarEstudante(boolean inativar) {

		if (this.listaDeEstudantes.size() > 0) {
			for (EstudanteModel estudanteModel : listaDeEstudantes) {
				estudanteModel.setAitvoOuInativo(inativar);
			}
			return mensagemDeRetornoSucesso;
		} else {
			return mensagemDeRetornoFalha;
		}

	}

	public List<EstudanteModel> getListaDeEstudantes() {
		return listaDeEstudantes;
	}

	public void limpa() {
		this.listaDeEstudantes.clear();
	}
}
