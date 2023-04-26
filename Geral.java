package com.sample;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import com.sample.GUI.currentWindow;

public class Geral {
	ArrayList<Paciente> listaDePacientes = new ArrayList<Paciente>();
	ArrayList<Ressonancia> listaDeRessonancias = new ArrayList<Ressonancia>();
	ArrayList<Biopsia> listaDeBiopsias = new ArrayList<Biopsia>();	
	ArrayList<String> resultadoRegras = new ArrayList<String>();
	


	PropertyChangeSupport sup = new PropertyChangeSupport(this);
	currentWindow state = currentWindow.INICIO;
	public static final String PROP_JANELAS = "_JANELAS_";
	
	public ArrayList<String> getResultadoRegras() {return resultadoRegras;}
	public void clearArray() {
		resultadoRegras.clear();
	}
	public void addResultadoRegras(String resultado) {
		resultadoRegras.add(resultado + "\n");
	}
	
	public void addPropertyChangeListener(String property, PropertyChangeListener listener){
        sup.addPropertyChangeListener(property, listener);
    }
	
	public ArrayList<Paciente> getListaDePacientes() {return listaDePacientes;}
	public void addListaDePacientes(Paciente p) {listaDePacientes.add(p);} 
	public ArrayList<Ressonancia> getListaDeRessonancias() {return listaDeRessonancias;}
	public void addListaDeRessonancia(Ressonancia r) {listaDeRessonancias.add(r);}
	public ArrayList<Biopsia> getListaDeBiopsias() {return listaDeBiopsias;}
	public void addListaDeBiopsia(Biopsia b) {listaDeBiopsias.add(b);}
	public currentWindow getState() {return state;}
	
	public void setState(currentWindow state) {
		this.state = state;
		sup.firePropertyChange(PROP_JANELAS, null, null);
	}
	
	public Paciente handlePaciente(String nome) {
		for(Paciente p : listaDePacientes) {
			System.out.println(p.getNome() + " getNome");
			System.out.println(nome + " nome");
			if(p.getNome().equals(nome)) {
				
				return p;
			}
		}
		return null;
	}
	
	
	
	
	

}
