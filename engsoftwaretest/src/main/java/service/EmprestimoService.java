package service;

import model.EmprestimoModel;
import model.EstudanteModel;
import model.LivroModel;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoService {

    private static List<EmprestimoModel> listaDeEmprestimos = new ArrayList<>();

    private LivroService livroService  = new LivroService();
    private EstudanteService estudanteService = new EstudanteService();
    private EmprestimoModel emprestimoModel;
    private String mensagemDeRetornoSucesso = "Sucesso";
    private String getMensagemDeRetornoFalha = "Falha";

    public String alugarLivro(LivroModel livroModel, EstudanteModel estudanteModel){
        if(livroService.getListaDeLivros().get(livroModel.getId() - 1).isAtivo() == true) {
            if (livroService.getListaDeLivros().get(livroModel.getId() - 1).getQuantidadeDeExemplares()  < 1) {
                System.out.println("**Livro sem quantidade em estoque** Quantidade: " + livroModel.getQuantidadeDeExemplares());
                System.out.println("Solicite reserva!!");
            }
            else if (livroService.getListaDeLivros().get(livroModel.getId() - 1).getQuantidadeDeExemplares() > 0) {
                if(estudanteService.getListaDeEstudantes().get(estudanteModel.getId() - 1).getLimiteDeEmprestimos() < 3) {
                    livroService.getListaDeLivros().get(livroModel.getId() - 1).setQuantidadeDeExemplares(livroModel.getQuantidadeDeExemplares() - 1);
                    estudanteService.getListaDeEstudantes().get(estudanteModel.getId() - 1).setLimiteDeEmprestimos(estudanteModel.getLimiteDeEmprestimos() + 1);
                    listaDeEmprestimos.add(emprestimoModel);
                } else if(estudanteService.getListaDeEstudantes().get(estudanteModel.getId() - 1).getLimiteDeEmprestimos() == 3) {
                    System.out.println("Limite de emprestimos excedido para:");
                    System.out.println(estudanteModel.toString());
                    System.out.println("Devolva um de seus livros para pedir novo emprestimo!!");
                    System.out.println();
                    }
            }
            return mensagemDeRetornoSucesso;
        }
        return  getMensagemDeRetornoFalha;
    }

    public String reservarLivro(LivroModel livroModel, EstudanteModel estudanteModel) {
        if (livroService.getListaDeLivros().get(livroModel.getId() - 1).isAtivo() == true) {
            if (livroService.getListaDeLivros().get(livroModel.getId() - 1).getQuantidadeDeExemplares() < 1) {
                if (livroService.getListaDeLivros().get(livroModel.getId() - 1).isLivroReservado() == false) {
                    livroService.getListaDeLivros().get(livroModel.getId() - 1).setLivroReservado(true);
                    System.out.println("Livro reservado para:");
                    System.out.println(estudanteModel.toString());
                    return mensagemDeRetornoSucesso;
                } else if (livroService.getListaDeLivros().get(livroModel.getId() - 1).isLivroReservado() == true) {
                    System.out.println("Livro já reservado!!");
                    return mensagemDeRetornoSucesso;
                }
            }
        }
            return getMensagemDeRetornoFalha;
        }

    public void limpa() {
        this.listaDeEmprestimos.clear();
    }
}
