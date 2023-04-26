package com.sample.GUI;

import java.util.ArrayList;
import java.util.Collections;

import com.sample.Administrador;
import com.sample.Geral;
import com.sample.Paciente;
import com.sample.Ressonancia;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class ListaDeEspera extends BorderPane  {
		Geral g;
		Administrador a;
		
		Label pacientes;
		
		Button buttonConfirm;
		Button buttonVoltar;
		Button buttonLimpar;
		TextField textPaciente;


	
		ArrayList<String> lista = new ArrayList<String>();
		public ListaDeEspera(Geral g, Administrador a) {
			super();
			this.g = g;
			this.a = a;
			geraInterface();
			registerHandlers();
			update();
			clearTextFields();

		}
		
		
		public void registerHandlers() {
			g.addPropertyChangeListener(Geral.PROP_JANELAS, e->update());
			
			buttonConfirm.setOnAction(eve->{
			
					pacientes.setText("Pacientes que estão registados: " + "    " + a.mostraPacientesEspera() + "    " ); 
				
				
			});
			
			buttonVoltar.setOnAction(ev->{g.setState(currentWindow.INICIO);});
			buttonLimpar.setOnAction(ev->clearTextFields());

		}
		
		public void clearTextFields() {
			pacientes.setText("Lista de clientes");

		}
		
		
		public void update() {
			if(g.getState() == currentWindow.LISTADEESPERA) {
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
		    

		pacientes = new Label();
		grid.add(pacientes, 0, 0);
		    
		buttonConfirm = new Button();
	    buttonConfirm.setText("Ver pacientes");
	    
	    buttonVoltar = new Button();
	    buttonVoltar.setText("Voltar");
	    

	    buttonLimpar = new Button();
	    buttonLimpar.setText("Limpar");


		grid.add(buttonConfirm, 6, 1);
	    grid.add(buttonVoltar, 6, 2);
	    grid.add(buttonLimpar, 6, 3);

	    
	    this.setPadding(new Insets(20));

        grid.setAlignment(Pos.CENTER);

        this.setCenter(grid);	  
	    
        
		}
}