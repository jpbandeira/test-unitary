package service;

import java.util.ArrayList;
import java.util.List;

import model.EstudanteModel;

public class EstudanteService {

	private List<EstudanteModel> listaDeEstudantes = new ArrayList<EstudanteModel>();

	private static int idEstudante;

	private String mensagemDeRetornoSucesso = "Sucesso";
	private String mensagemDeRetornoFalha = "Falha";

	public String salvarEstudante(EstudanteModel estudanteModel) {
		idEstudante++;
		estudanteModel.setAtivo(true);
		estudanteModel.setId(this.idEstudante);
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

	public String inativarEstudante(EstudanteModel estudante) {
		if (listaDeEstudantes.size() > 0) {
			for (EstudanteModel estudanteModel  : listaDeEstudantes) {
				if(estudante.isAtivo() == false) {
					estudante.setAtivo(true);
				}else if(estudante.isAtivo() == true){
					estudante.setAtivo(false);
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
