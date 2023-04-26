package com.sample.GUI;


import com.sample.Administrador;
import com.sample.Geral;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainGui extends BorderPane{
	
	Geral g = new Geral();
	Administrador a = new Administrador();

	public MainGui() {
		super();
		geraInterface();
		registerHandlers();
	}
	
	public void registerHandlers() {
		g.addPropertyChangeListener(g.PROP_JANELAS, evt->update());
			
		}

	private void update() {
		Stage stage = (Stage) this.getScene().getWindow();
		String tituloJanela = "";
		switch(g.getState()) {
		case INICIO:
			tituloJanela = "Sistema pericial";
			break;
		case PACIENTEGUI:
			tituloJanela = "Insercao de paciente";
			break;
		case BIOPSIAGUI:
			tituloJanela = "Insercao de biopsia";
			break;
		case RESSONANCIAGUI:
			tituloJanela = "Insercao de ressonancia";
			break;
		case GERAL:
			tituloJanela = "Geral";
			break;
		case DISPARAREGRAS:
			tituloJanela = "Tratamento de regras";
			break;
		case LISTADEESPERA:
			tituloJanela = "Lista de clientes em espera para ressonancia";
			break;
		}
		stage.setTitle(tituloJanela);
	}

	
	public void geraInterface() {
        StackPane stackPane = new StackPane(new BiopsiaUI(g), new InicioUI(g), new PacienteUI(g), new RessonanciaUI(g), new ListaDeEspera(g, a), new DisparaRegrasGUI(g,a));
        this.setCenter(stackPane);
        System.out.println(g.getState());
      
	}
	
	

}

	


