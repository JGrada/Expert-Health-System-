package com.sample.GUI;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;

import com.sample.Geral;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class InicioUI extends BorderPane {
	
	Geral g;
	Button buttonPaciente;
	Button buttonRessonancia; 
	Button buttonBiopsia;
	Button disparaRegras;
	Button checkListaEspera;
	GridPane grid;
	
	public InicioUI(Geral g) {
		super();
		this.g = g;
		geraInterface();
		registerHandlers();
		update();
	}
	
	public void registerHandlers() {
		g.addPropertyChangeListener(Geral.PROP_JANELAS, e->update());
		buttonPaciente.setOnAction(ev->g.setState(currentWindow.PACIENTEGUI));
		buttonRessonancia.setOnAction(ev->g.setState(currentWindow.RESSONANCIAGUI));
		buttonBiopsia.setOnAction(ev->g.setState(currentWindow.BIOPSIAGUI));
		disparaRegras.setOnAction(ev->g.setState(currentWindow.DISPARAREGRAS));
		checkListaEspera.setOnAction(ev->g.setState(currentWindow.LISTADEESPERA));

	}

	
	public void update() {
		if(g.getState() == currentWindow.INICIO) {
			this.setVisible(true);
		}
		else {
			this.setVisible(false);
		}
	}

	public void geraInterface()
	{
		
		
	grid = new GridPane();
	grid.setAlignment(Pos.CENTER);
	grid.setHgap(10);
	grid.setVgap(10);
	    
	    
	buttonPaciente = new Button();
	buttonPaciente.setText("Inserir paciente");

    
	buttonRessonancia = new Button();
	buttonRessonancia.setText("Inserir ressonancia");

    
	buttonBiopsia = new Button();
	buttonBiopsia.setText("Inserir biopsia");

	
	disparaRegras = new Button();
	disparaRegras.setText("Dispara regras");
	
	checkListaEspera = new Button();
	checkListaEspera.setText("Ver lista de espera");

	grid.add(buttonPaciente, 0, 1);
    grid.add(buttonRessonancia, 0, 3);
    grid.add(buttonBiopsia, 0, 5);
    grid.add(disparaRegras, 0, 7);
    grid.add(checkListaEspera, 0, 9);
    
    this.setCenter(grid);


	}
}