package com.sample.GUI;

import com.sample.Geral;
import com.sample.Paciente;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class PacienteUI extends BorderPane{
	
	Geral g;
	Label nomePaciente;
	Label idade;
	Label nivelSuspeita;
	Label dataUltimaConsulta;
	Label dataDia;
	Label dataMes;
	Label dataAno;
	TextField textNome;
	TextField textIdade;
	TextField textSuspeita;
	TextField textDia;
	TextField textMes;
	TextField textAno;

	Button buttonConfirm;
	Button buttonVoltar;
	Button buttonClear;

	public PacienteUI(Geral g) {
		super();
		this.g = g;
		geraInterface();
		registerHandlers();
		update();
	}


	public void registerHandlers() {
		g.addPropertyChangeListener(Geral.PROP_JANELAS, e->update());
		buttonVoltar.setOnAction(ev->{g.setState(currentWindow.INICIO);});
		
		buttonConfirm.setOnAction(ev->{
			if(Integer.parseInt(textDia.getText()) <= 31 && Integer.parseInt(textDia.getText()) >= 1 && 
					Integer.parseInt(textMes.getText()) >= 1 && Integer.parseInt(textMes.getText()) <= 12 
					&& Integer.parseInt(textAno.getText()) >= 2022){
				g.addListaDePacientes(new Paciente(textNome.getText(), Integer.parseInt(textIdade.getText()), Integer.parseInt(textSuspeita.getText()), Integer.parseInt(textDia.getText()), Integer.parseInt(textMes.getText()), Integer.parseInt(textAno.getText())));
				System.out.println(g.getListaDePacientes().toString());
				System.out.println(textNome.getText());
				ConfirmaPaciente.display();
			}
			else {
				VerificacaoData.display();
			}
			
		});
		
		buttonClear.setOnAction(ev->clearTextFields());
		}

		public void clearTextFields() {
			textNome.setText("");
			textIdade.setText("");
			textSuspeita.setText("");
			textDia.setText("");
			textMes.setText("");
			textAno.setText("");

		}
	


	public void update() {
		if(g.getState() == currentWindow.PACIENTEGUI) {
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
	    
	    nomePaciente = new Label("Insira o nome do paciente");
	    grid.add(nomePaciente, 0, 0);
	    
	    idade = new Label("Insira a idade do paciente");
	    grid.add(idade, 0, 2);
	    
	    nivelSuspeita = new Label("Insira o nivel de suspeita do paciente");
	    grid.add(nivelSuspeita, 0, 4);
	    
	    dataUltimaConsulta = new Label("Insira a data da ultima consulta");
	    grid.add(dataUltimaConsulta, 0, 6);
	    
	    dataDia = new Label("Dia");
	    grid.add(dataDia, 0, 8);
	    
	    dataMes = new Label("Mes");
	    grid.add(dataMes, 0, 10);
	    
	    dataAno = new Label("Ano");
	    grid.add(dataAno, 0, 12);
	
	    
	    textNome = new TextField();
	    grid.add(textNome, 0, 1);
	    
	    textIdade = new TextField();
	    grid.add(textIdade, 0, 3);
	    
	    textSuspeita = new TextField();
	    grid.add(textSuspeita, 0, 5);
	    
	    textDia = new TextField();
	    grid.add(textDia, 0, 9);
	    
	    textMes = new TextField();
	    grid.add(textMes, 0, 11);
	    
	    textAno = new TextField();
	    grid.add(textAno, 0, 13);
	    

	    buttonConfirm = new Button();
	    buttonConfirm.setText("Confirmar paciente");

	    
	    buttonVoltar = new Button();
	    buttonVoltar.setText("Voltar");

	    
	    buttonClear = new Button();
	    buttonClear.setText("Limpar");
	    
	    grid.add(buttonConfirm, 4, 11);
	    grid.add(buttonVoltar, 4, 13);
	    grid.add(buttonClear, 4, 12);

	    
	    this.setCenter(grid);

	}



}
