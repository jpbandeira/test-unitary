package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmprestimoModel{

	public EmprestimoModel(){
	}
	
	private float descontoParaMulta;
	private int limeteDeEmprestimos;
	private boolean livroAtrasadoOuNao;
	private boolean livroReservadoOuNao;

	private SimpleDateFormat  formatoDaDataDeEmprestomo = new SimpleDateFormat("dd/MM/yyyy");;
	private Date dataDeEmprestimo;

	public float getDescontoParaMulta() {
		return descontoParaMulta;
	}

	public void setDescontoParaMulta(float descontoParaMulta) {
		this.descontoParaMulta = descontoParaMulta;
	}

	public int getLimeteDeEmprestimos() {
		return limeteDeEmprestimos;
	}

	public void setLimeteDeEmprestimos(int limeteDeEmprestimos) {
		this.limeteDeEmprestimos = limeteDeEmprestimos;
	}

	public boolean isLivroAtrasadoOuNao() {
		return livroAtrasadoOuNao;
	}

	public void setLivroAtrasadoOuNao(boolean livroAtrasadoOuNao) {
		this.livroAtrasadoOuNao = livroAtrasadoOuNao;
	}

	public boolean isLivroReservadoOuNao() {
		return livroReservadoOuNao;
	}

	public void setLivroReservadoOuNao(boolean livroReservadoOuNao) {
		this.livroReservadoOuNao = livroReservadoOuNao;
	}

	public Date getDataDeEmprestimo() {
		return dataDeEmprestimo;
	}

	public void setDataDeEmprestimo(Date dataDeEmprestimo) throws ParseException {
		this.dataDeEmprestimo = formatoDaDataDeEmprestomo.parse("25/05/2019");;
	}


}
