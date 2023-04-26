package com.sample;

import org.kie.api.KieServices;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DisparaRegras {
	

	Geral g;
	Administrador a;
	
    KieServices ks;
    KieContainer kContainer;
	KieSession kSession;
	

	public DisparaRegras(Geral g, Administrador a) {
		super();
		this.g = g;
		this.a = a;
		imprime();
	    ks = KieServices.Factory.get();
	    kContainer = ks.getKieClasspathContainer();
		kSession = kContainer.newKieSession("ksession-rules");
		
		kSession.insert(g);
		kSession.insert(a);

		inserePaciente();
		insereBiopsia();
		insereRessonancia();
		disparaRegras();

	}
	
	public void imprime() {
		System.out.println("aqui");

	}
	
	public void inserePaciente() {
		for(Paciente p : g.listaDePacientes) {
			kSession.insert(p);
		}

	}
	
	public void insereBiopsia() {
		for(Biopsia b : g.listaDeBiopsias) {
			kSession.insert(b);
		}

	}
	
	public void insereRessonancia() {
		for(Ressonancia r : g.listaDeRessonancias) {
			kSession.insert(r);
		}
	}
		
	public void disparaRegras() {
		kSession.fireAllRules();
	}

	
}
