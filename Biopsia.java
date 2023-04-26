package com.sample;

public class Biopsia {
	int risco; 
	boolean retorno;
	Paciente p;


	public Paciente getP() {return p;}
	public void setP(Paciente p) {this.p = p;}
	public int getRisco() {return risco;}
	public void setRisco(int risco) {this.risco = risco;}
	public boolean isRetorno() {return retorno;}
	public void setRetorno(boolean retorno) {this.retorno = retorno;}
	public Biopsia(int risco, boolean retorno, Paciente p) {
		super();
		this.risco = risco;
		this.retorno = retorno;
		this.p = p;
	}

	
}
