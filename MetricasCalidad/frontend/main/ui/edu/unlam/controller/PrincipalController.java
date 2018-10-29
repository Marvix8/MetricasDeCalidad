package edu.unlam.controller;
import java.net.URL;
import java.util.ResourceBundle;

import edu.unlam.metricas_calidad.Caracteristicas;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class PrincipalController implements Initializable{

	
	// Listado usado para popular combos con valor SI o NO
	ObservableList<String> ListaSiNo = FXCollections.observableArrayList("SI","NO");
	
	// Listado usado para popular el combo fx:id="capacidadSerOperadoCombo"
	ObservableList<String> ListaCapacidadOperado = FXCollections.observableArrayList(
			"Se Consulta a Personal Especializado",
			"Se Requiere Manual de Usuario",
			"Se Opera Sin Asistencia");
	
	@FXML // fx:id="encriptacionDatosCombo"
	private ComboBox<String> encriptacionDatosCombo;
	
	@FXML // fx:id="ayudaCombo"
	private ComboBox<String> ayudaCombo;
	
	@FXML // fx:id="datosProcesadosCombo"
	private ComboBox<String> datosProcesadosCombo;
	
	@FXML // fx:id="capacidadSerOperadoCombo"
	private ComboBox<String> capacidadSerOperadoCombo;
	
	@FXML // fx:id="fallaCriticaCombo"
	private ComboBox<String> fallaCriticaCombo;
	
	@FXML // fx:id="iniciarSesionCombo"
	private ComboBox<String> iniciarSesionCombo;
	
	@FXML // fx:id="manualUsuarioCombo"
	private ComboBox<String> manualUsuarioCombo;
	
	@FXML // fx:id="logCombo"
	private ComboBox<String> logCombo;
	
	@FXML // fx:id="estadoAnteriorCombp"
	private ComboBox<String> estadoAnteriorCombo;
	
	@Override // Este método es llamado por FXMLLOADER cuando la inicialización finalizó
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		assert encriptacionDatosCombo != null : "fx:id=\"encriptacionDatosCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert ayudaCombo != null : "fx:id=\"ayudaCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert datosProcesadosCombo != null : "fx:id=\"encriptacionDatosCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert fallaCriticaCombo != null : "fx:id=\"fallaCriticaCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert iniciarSesionCombo != null : "fx:id=\"iniciarSesionCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert manualUsuarioCombo != null : "fx:id=\"manualUsuarioCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert capacidadSerOperadoCombo != null : "fx:id=\"capacidadSerOperadoCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert logCombo != null : "fx:id=\"logCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert estadoAnteriorCombo != null : "fx:id=\"estadoAnteriorCombo\" was not injected: check your FXML file 'Principal.fxml'.";

		// Populo los combos.
		encriptacionDatosCombo.setItems(ListaSiNo);
		ayudaCombo.setItems(ListaSiNo);
		datosProcesadosCombo.setItems(ListaSiNo);
		fallaCriticaCombo.setItems(ListaSiNo);
		iniciarSesionCombo.setItems(ListaSiNo);
		manualUsuarioCombo.setItems(ListaSiNo);
		logCombo.setItems(ListaSiNo);
		estadoAnteriorCombo.setItems(ListaSiNo);
		capacidadSerOperadoCombo.setItems(ListaCapacidadOperado);
		
		
		// listen for changes to the fruit combo box selection and update the displayed fruit image accordingly.
		encriptacionDatosCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				if(newValue.equals("SI"))
					Caracteristicas.setEncriptacionDatos = true;
			}
	    });
	  }

}
