package service;

import java.util.ArrayList;
import java.util.List;

import model.EstudanteModel;

public class EstudanteService {

	private static List<EstudanteModel> listaDeEstudantes = new ArrayList<EstudanteModel>();

	private int id;

	private String mensagemDeRetornoSucesso = "Sucesso";
	private String mensagemDeRetornoFalha = "Falha";

	public String salvarEstudante(EstudanteModel estudanteModel) {
		estudanteModel.setAtivo(true);
		this.id = listaDeEstudantes.isEmpty() ? 1 : listaDeEstudantes.get(listaDeEstudantes.size() - 1).getId() + 1;
		estudanteModel.setId(id);
		listaDeEstudantes.add(estudanteModel);
		return mensagemDeRetornoSucesso;
	}

	public String EditarLivro(int id,String matricula ,String nome, String cpf, String rg, int idade, String email) {
		if (listaDeEstudantes.size() > 0) {
			for (EstudanteModel estudanteModel : listaDeEstudantes) {
				if(id == estudanteModel.getId()){
					estudanteModel.setMatricula(matricula);
					estudanteModel.setNome(nome);
					estudanteModel.setCpf(cpf);
					estudanteModel.setRg(rg);
					estudanteModel.setIdade(idade);
					estudanteModel.setEmail(email);
					return mensagemDeRetornoSucesso;
				}
			}
		}
		return mensagemDeRetornoFalha;
	}

	public String inativarLivro(EstudanteModel estudante) {
		if (listaDeEstudantes.size() > 0) {
			for (EstudanteModel livroModel : listaDeEstudantes) {
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
