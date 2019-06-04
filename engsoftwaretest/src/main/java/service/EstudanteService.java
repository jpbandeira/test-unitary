package service;

import java.util.ArrayList;
import java.util.List;

import model.EstudanteModel;

public class EstudanteService {

	private List<EstudanteModel> listaDeEstudantes = new ArrayList<EstudanteModel>();

	private int idEstudante;

	private String mensagemDeRetornoSucesso = "Sucesso";
	private String mensagemDeRetornoFalha = "Falha";

	public String salvarEstudante(int id,String nome, String cpf, String rg, int idade, boolean aitvoOuInativo) {
		this.idEstudante = id++;
		EstudanteModel estudanteModel = new EstudanteModel(this.idEstudante, nome, cpf, rg, idade, aitvoOuInativo);
		listaDeEstudantes.add(estudanteModel);
		return mensagemDeRetornoSucesso;

	}

	public String editarEstudante(int id,String nome, String cpf, String rg, int idade) {
		if (this.listaDeEstudantes.size() > 0) {
			for (EstudanteModel estudanteModel : listaDeEstudantes) {
				if (id == estudanteModel.getId()) {
					estudanteModel.setNome(nome);
					estudanteModel.setCpf(cpf);
					estudanteModel.setRg(rg);
					estudanteModel.setIdade(idade);
				}
			}
			return mensagemDeRetornoSucesso;
		}
			return mensagemDeRetornoFalha;
	}

	public String inativarLivro(int id , boolean inativar) {
		if (listaDeEstudantes.size() > 0) {
			for (EstudanteModel estudanteModel : listaDeEstudantes) {
				if(id == estudanteModel.getId()) {
					estudanteModel.setAitvoOuInativo(inativar);
				}
			}
			return mensagemDeRetornoSucesso;
		}
		return mensagemDeRetornoFalha;
	}

	public List<EstudanteModel> getListaDeEstudantes() {
		return listaDeEstudantes;
	}

	public void limpa() {
		this.listaDeEstudantes.clear();
	}
}
