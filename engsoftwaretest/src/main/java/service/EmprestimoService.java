package service;

import model.EmprestimoModel;
import model.EstudanteModel;
import model.LivroModel;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoService {

    private static List<EmprestimoModel> listaDeEmprestimos = new ArrayList<EmprestimoModel>();

    private LivroService livroService  = new LivroService();
    private EstudanteService estudanteService = new EstudanteService();
    private EmprestimoModel emprestimoModel;
    private String mensagemDeRetornoSucesso = "Sucesso";
    private String getMensagemDeRetornoFalha = "Falha";

    public String alugarLivro(LivroModel livroModel, EstudanteModel estudanteModel){
        if(livroService.getListaDeLivros().get(livroService.getListaDeLivros().size() - 1).isAtivo() == true) {
            if (livroService.getListaDeLivros().get(livroService.getListaDeLivros().size() - 1).getQuantidadeDeExemplares() == 0) {
                System.out.println("**Livro sem quantidade em estoque**");
                System.out.println("Solicite reserva!!");
            }
            else if (livroService.getListaDeLivros().get(livroService.getListaDeLivros().size() - 1).getQuantidadeDeExemplares() > 0) {
                if(estudanteService.getListaDeEstudantes().get(estudanteService.getListaDeEstudantes().size() - 1).getLimiteDeEmprestimos() == 3) {
                    System.out.println("Limite de emprestimos excedido");
                } else if(estudanteService.getListaDeEstudantes().get(estudanteService.getListaDeEstudantes().size() - 1).getLimiteDeEmprestimos() < 3){
                    livroService.getListaDeLivros().get(livroService.getListaDeLivros().size() - 1).setQuantidadeDeExemplares(livroModel.getQuantidadeDeExemplares() - 1);
                    estudanteService.getListaDeEstudantes().get(estudanteService.getListaDeEstudantes().size() - 1).setLimiteDeEmprestimos(estudanteModel.getLimiteDeEmprestimos() + 1);
                    listaDeEmprestimos.add(emprestimoModel);
                }
            }
            return mensagemDeRetornoSucesso;
        }/*else if(estudanteModel.getLimiteDeEmprestimos() < 4){
            System.out.println("Limite de emprestimos excedido!");
            return mensagemDeRetornoSucesso;
        }*/
        return  getMensagemDeRetornoFalha;
    }

    /*public String reservarLivro(LivroModel livroModel){
        if(livroModel.isLivroReservado() == true){
            System.out.println("Livro já reservado, aguarde para ter sua vez");
            return  mensagemDeRetornoSucesso;
        }else if(livroModel.isLivroReservado() == false){
            livroModel.setLivroReservado(true);
            return  mensagemDeRetornoSucesso;
        }
        return  getMensagemDeRetornoFalha;
    }
*/
    public String aplicarMulta(){
        return mensagemDeRetornoSucesso;
    }



    public void limpa() {
        this.listaDeEmprestimos.clear();
    }
}
