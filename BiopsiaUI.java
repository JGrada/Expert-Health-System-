package com.sample.GUI;

import javax.swing.JCheckBox;

import com.sample.Biopsia;
import com.sample.Geral;
import com.sample.Paciente;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;


public class BiopsiaUI extends BorderPane  {
	
	Geral g;
	Label risco;
	Label retorno;
	Label paciente;
	
	TextField textRisco;
	CheckBox isRetorno;
	TextField textPaciente;
	
	Button buttonVoltar;
	Button buttonConfirm;
	Button buttonClear;
	
		
	
	
	public BiopsiaUI(Geral g) {
		super();
		this.g = g;
		geraInterface();
		registerHandlers();
		update();
		clearTextFields();
	}
	
	public void registerHandlers() {
		g.addPropertyChangeListener(Geral.PROP_JANELAS, e->update());
		buttonConfirm.setOnAction(ev->{
			Paciente p = g.handlePaciente(textPaciente.getText());
			if(p != null) {
				
				if(Integer.parseInt(textRisco.getText()) < 0  || Integer.parseInt(textRisco.getText()) > 5) {
				   	VerificacaoValores.display();
				   	
				}
				else {
				g.addListaDeBiopsia(new Biopsia(Integer.parseInt(textRisco.getText()), isRetorno.isSelected(), p));
				System.out.println(g.getListaDeBiopsias().toString());
				ConfirmaBiopsia.display();
				}
				

			}
			else {
				VerificacaoPaciente.display();

			}
		});
		buttonVoltar.setOnAction(ev->{g.setState(currentWindow.INICIO);});
		buttonClear.setOnAction(ev->clearTextFields());
	}

	public void clearTextFields() {
		textRisco.setText("");
		textPaciente.setText("");
		isRetorno.setSelected(false);

	}
	
	
	public void update() {
		if(g.getState() == currentWindow.BIOPSIAGUI) {
			this.setVisible(true);
		}
		else {
			this.setVisible(false);
		}
	}
	
	public void geraInterface()
	{
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    
	    risco = new Label("Insira o nivel de risco");
	    grid.add(risco, 0, 1);
	    
	    retorno = new Label("A biopsia retornou positivo?");
	    grid.add(retorno, 0, 3);
	    
	    paciente = new Label("Insira o nome do paciente que esta associado a esta biopsia");
	    grid.add(paciente, 0, 5);
	    
	    textRisco = new TextField();
	    grid.add(textRisco, 0, 2);
	    
	    isRetorno = new CheckBox("Sim");
	    grid.add(isRetorno, 1, 3);
	    
	    textPaciente = new TextField();
	    grid.add(textPaciente, 0, 7);
	    
	    buttonConfirm = new Button();
	    buttonConfirm.setText("Confirmar biopsia");
	    
	    buttonVoltar = new Button();
	    buttonVoltar.setText("Voltar");
	 
	    
	    buttonClear = new Button();
	    buttonClear.setText("Limpar");
	 
	    
		grid.add(buttonConfirm, 0, 9);
	    grid.add(buttonVoltar, 0, 13);
	    grid.add(buttonClear, 0, 11);
	    


	    
	    this.setPadding(new Insets(20));

        grid.setAlignment(Pos.CENTER);

        this.setCenter(grid);	        	
	}
	
}

