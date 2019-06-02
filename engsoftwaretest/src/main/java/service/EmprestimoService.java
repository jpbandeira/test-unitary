package service;

import model.EmprestimoModel;
import model.EstudanteModel;
import model.LivroModel;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoService {

    private List<EmprestimoModel> listaDeEmprestimos = new ArrayList<EmprestimoModel>();
    private EmprestimoModel emprestimoModel;
    private EstudanteModel estudanteModel = new EstudanteModel();

    private String mensagemDeRetornoSucesso = "Sucesso";
    private String getMensagemDeRetornoFalha = "Falha";

    public String alugarLivro(LivroModel livroModel){
        if (livroModel.isLivroAlugadoOuNao() == true) {
            System.out.println("Livro ja alugado, solicite reserva");
            return  mensagemDeRetornoSucesso;
        } else if(livroModel.isLivroAlugadoOuNao() == false) {
            livroModel.setLivroAlugadoOuNao(true);
            this.listaDeEmprestimos.add(emprestimoModel);
            this.estudanteModel.setLimiteDeEmprestimos(estudanteModel.getLimiteDeEmprestimos()+1);
            return  mensagemDeRetornoSucesso;
        }else if(estudanteModel.getLimiteDeEmprestimos() < 4){
            System.out.println("Limite de emprestimos excedido!");
            return mensagemDeRetornoSucesso;
        }
        return  getMensagemDeRetornoFalha;
    }

    public String reservarLivro(LivroModel livroModel){
        if(livroModel.isLivroReservadoOuNao() == true){
            System.out.println("Livro já reservado, aguarde para ter sua vez");
            return  mensagemDeRetornoSucesso;
        }else if(livroModel.isLivroReservadoOuNao() == false){
            livroModel.setLivroReservadoOuNao(true);
            return  mensagemDeRetornoSucesso;
        }
        return  getMensagemDeRetornoFalha;
    }

    public String aplicarMulta(){
        return mensagemDeRetornoSucesso;
    }

    public void limpa() {
        this.listaDeEmprestimos.clear();
    }
}
