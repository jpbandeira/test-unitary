package service;

import model.LivroModel;

public class EmprestimoService {

    private boolean retornoParaTeste;

	public boolean isRetornoParaTeste() {
		return retornoParaTeste;
	}

	public void setRetornoParaTeste(boolean retornoParaTeste) {
		this.retornoParaTeste = retornoParaTeste;
	}

	public void alugarLivro(LivroModel livroModel){
    	this.processoParaAlugarUmLivroNaBiblioteca(livroModel);
	}

    private void processoParaAlugarUmLivroNaBiblioteca(LivroModel livroModel) {
		if (livroModel.isLivroAlugadoOuNao() == true) {
			System.out.println("Livro ja alugado, solicite reserva");
			this.retornoParaTeste = true;
		} else {
			livroModel.setLivroAlugadoOuNao(true);
		}
		this.retornoParaTeste = false;
	}


}
