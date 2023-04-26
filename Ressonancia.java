package com.sample;

import java.util.ArrayList;

public class Ressonancia {
	int PIRADS;
	boolean lesaoFocal;
	Paciente p;
	boolean suspeitasClinicas;
	
	public boolean isSuspeitasClinicas() {return suspeitasClinicas;}
	public void setSuspeitasClinicas(boolean suspeitasClinicas) {this.suspeitasClinicas = suspeitasClinicas;}
	public Paciente getP() {return p;}
	public void setP(Paciente p) {this.p = p;}
	public int getPIRADS() {return PIRADS;}
	public void setPIRADS(int pIRADS) {PIRADS = pIRADS;}
	public boolean isLesaoFocal() {return lesaoFocal;}
	public void setLesaoFocal(boolean lesaoFocal) {this.lesaoFocal = lesaoFocal;}

	public Ressonancia(int pIRADS, boolean lesaoFocal, Paciente p, boolean suspeitasClinicas) {
		super();
		PIRADS = pIRADS;
		this.lesaoFocal = lesaoFocal;
		this.p = p;
		this.suspeitasClinicas = suspeitasClinicas;
	}
	
}


