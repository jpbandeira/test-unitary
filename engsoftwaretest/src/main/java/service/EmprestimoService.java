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
        if (livroModel.isLivroAlugadoOuNao() == true) {
            System.out.println("Livro ja alugado, solicite reserva");
            retornoParaTeste = true;
        } else if(livroModel.isLivroAlugadoOuNao() == false) {
            livroModel.setLivroAlugadoOuNao(true);
            retornoParaTeste = true;
        }else{
            this.retornoParaTeste = false;
        }
	}

	public void reservarLivro(LivroModel livroModel){
	    if(livroModel.isLivroReservadoOuNao() == true){
            System.out.println("Livro já reservado, aguarde para ter sua vez");
            retornoParaTeste = true;
        }else if(livroModel.isLivroReservadoOuNao() == false){
	        livroModel.setLivroReservadoOuNao(true);
	        retornoParaTeste = true;
        }else{
	        retornoParaTeste = false;
        }
    }
}
