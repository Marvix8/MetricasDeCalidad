package edu.unlam.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ErrorMessageController {

	final static String mensajeErrorIconImage = "/images/mensajeError.png";
	
	public static Alert mensajeError() {
		Alert mensajeError = new Alert(AlertType.ERROR, 
										"Debe completar todos los campos resaltados en rojo para calcular el resultado.",
										ButtonType.OK);
		
		mensajeError.setTitle("Métricas de Calidad");
		mensajeError.setHeaderText("No se han completado todos los campos requeridos");
		
		Stage stage = (Stage) mensajeError.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(mensajeErrorIconImage));
		
		return mensajeError;
	}
	
	
	
}
