package service;

import model.LivroModel;

public class EmprestimoService {

    private boolean retornoParaTeste;
    
    public void alugarLivro(LivroModel livroModel){

    	processoParaAlugarUmLivroNaBiblioteca(livroModel);
    	
  		
	}
    
    
    private void processoParaAlugarUmLivroNaBiblioteca(LivroModel livroModel) {
		
		
    	if(livroModel.isLivroAlugadoOuNao() == true) {
        		
        		retornoParaTeste = true;
        		
        	}else {
        		
        		livroModel.setLivroAlugadoOuNao(true);
        		
        	}
        	
    	retornoParaTeste = false;
            

        }


}
