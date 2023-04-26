package com.sample.GUI;

import com.sample.Administrador;
import com.sample.DisparaRegras;
import com.sample.Geral;
import com.sample.Paciente;
import com.sample.Ressonancia;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class DisparaRegrasGUI extends BorderPane {
	
	Geral g;
	Administrador a;

	Label regras;
	
	Button buttonDisparaRegras;
	Button buttonVoltar;
	
	DisparaRegras d;
  

	public DisparaRegrasGUI(Geral g, Administrador a) {
		super();
		this.g = g;
		this.a = a;
		geraInterface();
		registerHandlers();
		update();
		d = new DisparaRegras(g,a);

	}
	
	
	
	
	public void registerHandlers() {
		g.addPropertyChangeListener(Geral.PROP_JANELAS, e->update());
		buttonVoltar.setOnAction(ev->{g.setState(currentWindow.INICIO);});
		buttonDisparaRegras.setOnAction(eve->{
			d.inserePaciente();
			d.insereBiopsia();
			d.insereRessonancia();
			d.disparaRegras();
			regras.setText("");
			for(String r : g.getResultadoRegras()) {
				regras.setText(regras.getText() + r);
			}
			
		});
		

	}
	

	
	public void update() {
		if(g.getState() == currentWindow.DISPARAREGRAS) {
			this.setVisible(true);
		}
		else {
			this.setVisible(false);
		}
	}

	public void geraInterface() {
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    
	    regras = new Label("Clique no botão para disparar as regras");
	    grid.add(regras, 0, 1);
	    
	    buttonDisparaRegras = new Button();
	    buttonDisparaRegras.setText("Disparar regras");
	    
	    buttonVoltar = new Button();
	    buttonVoltar.setText("Voltar");
	    
	    
	    
	    
		grid.add(buttonDisparaRegras, 4, 5);
	    grid.add(buttonVoltar, 4, 6);
	 
	    
	    
	    this.setPadding(new Insets(20));

        grid.setAlignment(Pos.CENTER);

        this.setCenter(grid);	  
	    
	}
}
