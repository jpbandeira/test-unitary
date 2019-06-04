package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmprestimoModel{

	private float descontoParaMulta;
	private boolean livroAtrasado;

	public float getDescontoParaMulta() {
		return descontoParaMulta;
	}

	public void setDescontoParaMulta(float descontoParaMulta) {
		this.descontoParaMulta = descontoParaMulta;
	}

	public boolean isLivroAtrasadoOuNao() {
		return livroAtrasado;
	}

	public void setLivroAtrasadoOuNao(boolean livroAtrasado) {
		this.livroAtrasado = livroAtrasado;
	}
}
