package edu.unlam.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ResultMessageController {

	final static String buenoIconImage = "/images/bueno.png";
	final static String maloIconImage = "/images/malo.png";
	final static String regularIconImage = "/images/regular.png";
	
	public static Alert mensajeResultado(String resultado) {
		Alert mensajeResultado = new Alert(AlertType.INFORMATION, 
										"Su Software obtuvo la siguiente calificación general: " + resultado,
										ButtonType.OK);
		
		mensajeResultado.setTitle("Métricas de Calidad");
		mensajeResultado.setHeaderText("Resultado General Métricas");
		
		Stage stage = (Stage) mensajeResultado.getDialogPane().getScene().getWindow();
		
		if(resultado.equals("BUENO")) {
			stage.getIcons().add(new Image(buenoIconImage));
		} else if(resultado.equals("MALO")) {
			stage.getIcons().add(new Image(maloIconImage));
		} else {
			stage.getIcons().add(new Image(regularIconImage));
		}
		
		return mensajeResultado;
	}
	
}
