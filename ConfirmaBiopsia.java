package com.sample.GUI;

import com.sample.Geral;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmaBiopsia {
static Geral g;
	
	public ConfirmaBiopsia(Geral g) {
		super();
		this.g = g;
	}

	public static void display() {
	
	Stage window = new Stage();
	window.initModality(Modality.APPLICATION_MODAL);
	window.setTitle("Biopsia inserida com sucesso");
	window.setWidth(400);
	window.setHeight(400);
	
	Label label = new Label();
	label.setText("Biopsia inserida com sucesso");
	
	Button closeButton = new Button("Fechar");
	closeButton.setOnAction(ev->window.close());
	
	VBox layout = new VBox();
	layout.getChildren().add(label);
	layout.setAlignment(Pos.CENTER);
	
	Scene scene = new Scene(layout);
	window.setScene(scene);
	window.showAndWait();

	}
}
