package com.sample.GUI;

import com.sample.Biopsia;
import com.sample.Geral;
import com.sample.Paciente;
import com.sample.Ressonancia;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class RessonanciaUI extends BorderPane  {
	
	
	Geral g;
	Ressonancia r;
	
	Label nivelDePIRADS;
	Label lesaoFocal;
	Label paciente;
	Label suspeitasClinicas;
	
	TextField textNivelPIRADS;
	CheckBox isLesaoFocal;
	TextField textPaciente;
	CheckBox isSuspeitasClinicas;
	
	Button buttonConfirm;
	Button buttonVoltar;
	Button buttonClear;

	
	public RessonanciaUI(Geral g) {
		super();
		this.g = g;
		geraInterface();
		registerHandlers();
		update();
	}
		
	public void registerHandlers() {
		g.addPropertyChangeListener(Geral.PROP_JANELAS, e->update());
		buttonConfirm.setOnAction(eve->{
			Paciente p;
			p = g.handlePaciente(textPaciente.getText());
			if(p != null) {
				if(Integer.parseInt(textNivelPIRADS.getText()) < 0  || Integer.parseInt(textNivelPIRADS.getText()) > 5) {
					VerificacaoValores.display();
				}
			
				else {
					
					
					g.addListaDeRessonancia(new Ressonancia(Integer.parseInt(textNivelPIRADS.getText()), (isLesaoFocal.isSelected()), p, isSuspeitasClinicas.isSelected()));
					ConfirmaRessonancia.display();

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
		textNivelPIRADS.setText("");
		textPaciente.setText("");
		isLesaoFocal.setSelected(false);
		isSuspeitasClinicas.setSelected(false);

	}


	
	public void update() {
		if(g.getState() == currentWindow.RESSONANCIAGUI) {
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
	    
	    nivelDePIRADS = new Label("Insira o nivel de PIRADS");
	    grid.add(nivelDePIRADS, 0, 1);
	    
	    Label lesaoFocal = new Label("O paciente tem lesao focal?");
	    grid.add(lesaoFocal, 0, 3);
	    
	    Label paciente = new Label("Insira o nome do paciente que est� associado a esta ressonancia");
	    grid.add(paciente, 0, 5);
	    
	    Label suspeitasClinicas = new Label("O paciente tem suspeitas clinicas");
	    grid.add(suspeitasClinicas, 0, 9);
	    
	    textNivelPIRADS = new TextField();
	    grid.add(textNivelPIRADS , 0, 2);
	    
	    isLesaoFocal = new CheckBox();
	    grid.add(isLesaoFocal , 1, 3);
	    
	    textPaciente = new TextField();
	    grid.add(textPaciente , 0, 7);
	    
	    isSuspeitasClinicas = new CheckBox();
	    grid.add(isSuspeitasClinicas , 1, 9);
	    

	    buttonConfirm = new Button();
	    buttonConfirm.setText("Confirmar ressonancia");
	    
	    buttonVoltar = new Button();
	    buttonVoltar.setText("Voltar");
	    
	    buttonClear = new Button();
	    buttonClear.setText("Limpar");

	    
		grid.add(buttonConfirm, 0, 11);
	    grid.add(buttonVoltar, 0, 15);
	    grid.add(buttonClear, 0, 13);

	    this.setPadding(new Insets(20));

        grid.setAlignment(Pos.CENTER);

        this.setCenter(grid);	  
	    
	}
	
}