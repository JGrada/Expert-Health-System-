package com.sample;

import java.util.Calendar;

import com.sample.Biopsia;
import com.sample.Urologia;

public class Paciente {
	private String nome;
	private int idade;
	private int nivelSuspeita = 0;
	Mes m;

	
	public Mes getM() {return m;}
	public void setM(Mes m) {this.m = m;}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public int getIdade() {return idade;}
	public void setIdade(int idade) {this.idade = idade;}
	public int getNivelSuspeita() {return nivelSuspeita;}
	public void setNivelSuspeita(int nivelSuspeita) {this.nivelSuspeita = nivelSuspeita;}
	public Paciente(String nome, int idade, int nivelSuspeita, int dia, int mes, int ano) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.nivelSuspeita = nivelSuspeita;
		this.m = new Mes(new int[] {dia, mes, ano});
	}
	
	
	

}
