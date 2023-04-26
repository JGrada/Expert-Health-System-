package com.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import java.util.*;

public class Administrador {
	
	
	ArrayList<Paciente> listaDeEspera = new ArrayList<Paciente>();

	public String mostraPacientesEspera() {
		ordenaPacientes(listaDeEspera);

		String paciente = toString() + "\n";
	
		return paciente;
	}

	public ArrayList<Paciente> getListaDeEspera() {
		return listaDeEspera;
	}
				

	public void setListaDeEspera(ArrayList<Paciente> listaDeEspera) {this.listaDeEspera = listaDeEspera;}
	


	public void addLista(Paciente p) {
		listaDeEspera.add(p);
	}

	
	public static class CompareDataAno implements Comparator<Paciente>{
		@Override
		public int compare(Paciente p1, Paciente p2) {
				return Integer.compare(p1.getM().getAno(), p2.getM().getAno());
		}
    }
	
	public static class CompareDataMes implements Comparator<Paciente>{
		@Override
		public int compare(Paciente p1, Paciente p2) {
			if(p1.getM().getAno() == p2.getM().getAno())
				return Integer.compare(p1.getM().getMes(), p2.getM().getMes());
			return 0;
		}
	}
	
	public static class CompareDataDia implements Comparator<Paciente>{
		@Override
		public int compare(Paciente p1, Paciente p2) {
			if(p1.getM().getMes() == p2.getM().getMes())
				return Integer.compare(p1.getM().getDia(), p2.getM().getDia());
			return 0;
		}
	}
	
	
	
	public void ordenaPacientes(ArrayList <Paciente> listaEspera) {
			Collections.sort(listaEspera, new CompareDataAno());
			Collections.sort(listaEspera, new CompareDataMes());
			Collections.sort(listaEspera, new CompareDataDia());
			System.out.println(listaEspera + "asdsfgdgfgA");
	}


	@Override
	public String toString() {
		String paciente = "";
		for(Paciente name : listaDeEspera) {
		    paciente += "Nome " + name.getNome() + " Proxima consulta " + name.getM().getData();
		}
		
		return paciente;
	}


	

	


}
