package edu.unlam.controller;
import java.net.URL;
import java.util.ResourceBundle;

import edu.unlam.metricas_calidad.Calificacion;
import edu.unlam.metricas_calidad.CaracteristicaException;
import edu.unlam.metricas_calidad.Caracteristicas;
import edu.unlam.metricas_calidad.ProcesarCaracteristicas;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrincipalController implements Initializable{

	/*
	 * Principal's ComboBox
	 */
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
	
	@FXML // fx:id="estadoAnteriorCombo"
	private ComboBox<String> estadoAnteriorCombo;
	
	/*
	 * Principal's TextField 
	 */
	@FXML // fx:id="complejidadCiclomaticaTextField"
	private TextField complejidadCiclomaticaTextField;
	
	@FXML // fx:id="comportamientoFrenteTiempoTextField"
	private TextField comportamientoFrenteTiempoTextField;

	@FXML // fx:id="exactitudResultadosTextField"
	private TextField exactitudResultadosTextField;
	
	@FXML // fx:id="intalacionTextField"
	private TextField intalacionTextField;
	
	@FXML // fx:id="multiSOTextField"
	private TextField multiSOTextField;
	
	@FXML // fx:id="porcentajeComentariosTextField"
	private TextField porcentajeComentariosTextField;
	
	@FXML // fx:id="utilizacionRecursosTextField"
	private TextField utilizacionRecursosTextField;
	
	/*
	 * Principal's Button 
	 */
	@FXML // fx:id="procesarButton"
	private Button procesarButton;
	
	@FXML // fx:id="limpiarButton"
	private Button limpiarButton;
	
	/*
	 * Principal's Label 
	 */	
	@FXML // fx:id="usabilidadResultFLabel"
	private Label usabilidadResultFLabel;
	
	@FXML // fx:id="resultLabel"
	private Label resultLabel;
	
	@FXML // fx:id="portabilidadResultLabel"
	private Label portabilidadResultLabel;
	
	@FXML // fx:id="mantenibilidadResultLabel"
	private Label mantenibilidadResultLabel;
	
	@FXML // fx:id="funcionalidadResultLabel"
	private Label funcionalidadResultLabel;
	
	@FXML // fx:id="fiabilidadResultLabel"
	private Label fiabilidadResultLabel;
	
	@FXML // fx:id="fiabilidadResultLabel2"
	private Label fiabilidadResultLabel2;
	
	@FXML // fx:id="eficienciaResultLabel"
	private Label eficienciaResultLabel;
	
	// Objeto Característica
	Caracteristicas caracteristicas;
	
	// PseudoClass usada para marcar con rojo lo que está mal ingresado.
	final private PseudoClass errorClass = PseudoClass.getPseudoClass("error");
	
	
	// PseudoClass usadas para setear color de resultLabel según el obtenido.
	final private PseudoClass buenoClass = PseudoClass.getPseudoClass("bueno");
	final private PseudoClass regularClass = PseudoClass.getPseudoClass("regular");
	final private PseudoClass maloClass = PseudoClass.getPseudoClass("malo");

	// Array con todos los ComboBoxes
	final private ComboBox[] allComboBoxes = {	encriptacionDatosCombo,
												ayudaCombo,
												datosProcesadosCombo,
												capacidadSerOperadoCombo,
												fallaCriticaCombo,
												iniciarSesionCombo,
												manualUsuarioCombo,
												logCombo,
												estadoAnteriorCombo };
	
	// Array con todos los TextFields
	final private TextField[] allTextFields = { complejidadCiclomaticaTextField,
												comportamientoFrenteTiempoTextField,
												exactitudResultadosTextField,
												intalacionTextField,
												multiSOTextField,
												porcentajeComentariosTextField,
												utilizacionRecursosTextField };
	
	// Array con todos los Labels
	final private Label[] allLabels = {	resultLabel, 
										funcionalidadResultLabel, 
										eficienciaResultLabel, 
										fiabilidadResultLabel, 
										fiabilidadResultLabel2, 
										mantenibilidadResultLabel, 
										usabilidadResultFLabel, 
										portabilidadResultLabel };
	
	// Listado usado para popular combos con valor SI o NO
	ObservableList<String> ListaSiNo = FXCollections.observableArrayList("SI","NO");
	
	// Listado usado para popular el combo fx:id="capacidadSerOperadoCombo"
	ObservableList<String> ListaCapacidadOperado = FXCollections.observableArrayList(
			"Se Consulta a Personal Especializado",
			"Se Requiere Manual de Usuario",
			"Se Opera Sin Asistencia");
	
	/*
	 * El método es llamado por FXMLLOADER cuando la inicialización finalizó.
	 */
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		// Valido que todos los componentes se encuentren en mi archivo FXML.
		validarComponentes();
		// Populo los combos.
		popularCombos();
		
		caracteristicas = new Caracteristicas();
		
		encriptacionDatosCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				if (encriptacionDatosCombo.getValue().equals("SI")) {
					caracteristicas.setEncriptacionDatos(true);
				} else if (encriptacionDatosCombo.getValue().equals("NO")) {
					caracteristicas.setEncriptacionDatos(false);
				}
			}
	    });
		
		ayudaCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				if (ayudaCombo.getValue().equals("SI")) {
					caracteristicas.setAyduaContextual(true);;
				} else if (ayudaCombo.getValue().equals("NO")) {
					caracteristicas.setAyduaContextual(false);
				}
			}
	    });
		
		datosProcesadosCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				if (datosProcesadosCombo.getValue().equals("SI")) {
					caracteristicas.setProteccionDatosProcesados(true);;
				} else if (datosProcesadosCombo.getValue().equals("NO")) {
					caracteristicas.setProteccionDatosProcesados(false);
				}
			}
	    });
		
		fallaCriticaCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				if (fallaCriticaCombo.getValue().equals("SI")) {
					caracteristicas.setReanudarActividadAnteFalla(true);;
				} else if (fallaCriticaCombo.getValue().equals("NO")) {
					caracteristicas.setReanudarActividadAnteFalla(false);
				}
			}
	    });
		
		iniciarSesionCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				if (iniciarSesionCombo.getValue().equals("SI")) {
					caracteristicas.setInicioSesionUsuarios(true);;
				} else if (iniciarSesionCombo.getValue().equals("NO")) {
					caracteristicas.setInicioSesionUsuarios(false);
				}
			}
	    });
		
		manualUsuarioCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				if (manualUsuarioCombo.getValue().equals("SI")) {
					caracteristicas.setManualUsuarioIncorporado(true);;
				} else if (manualUsuarioCombo.getValue().equals("NO")) {
					caracteristicas.setManualUsuarioIncorporado(false);
				}
			}
	    });
		
		logCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				if (logCombo.getValue().equals("SI")) {
					caracteristicas.setLogActividades(true);;
				} else if (logCombo.getValue().equals("NO")) {
					caracteristicas.setLogActividades(false);
				}
			}
	    });
		
		estadoAnteriorCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				if (estadoAnteriorCombo.getValue().equals("SI")) {
					caracteristicas.setReanudarEnEstadoAnterior(true);;
				} else if (encriptacionDatosCombo.getValue().equals("NO")) {
					caracteristicas.setReanudarEnEstadoAnterior(false);
				}
			}
	    });
		
		capacidadSerOperadoCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override 
			public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				if (capacidadSerOperadoCombo.getValue().equals("Se Consulta a Personal Especializado")) {
					caracteristicas.setCapacidadDeSerOperado(Calificacion.MALO);
				} else if (capacidadSerOperadoCombo.getValue().equals("Se Requiere Manual de Usuario")) {
					caracteristicas.setCapacidadDeSerOperado(Calificacion.REGULAR);
				} else if (capacidadSerOperadoCombo.getValue().equals("Se Opera Sin Asistencia")) {
					caracteristicas.setCapacidadDeSerOperado(Calificacion.BUENO);
				}
			}
	    });
		
		complejidadCiclomaticaTextField.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		    	try {
		    		utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, false);
					caracteristicas.setComplejidadCiclomatica(Double.parseDouble(newValue));
				} catch (NumberFormatException | CaracteristicaException e) {
					utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, true);
					e.printStackTrace();
				} 
		    }
		});
		
		comportamientoFrenteTiempoTextField.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		    	try {
		    		utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, false);
					caracteristicas.setTiempoSinInformarEstado(Double.parseDouble(newValue));
				} catch (NumberFormatException | CaracteristicaException e) {
					utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, true);
					e.printStackTrace();
				} 
		    }
		});
		
		exactitudResultadosTextField.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		    	try {
		    		utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, false);
					caracteristicas.setOrdenError(Double.parseDouble(newValue));
				} catch (NumberFormatException e) {
					utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, true);
					e.printStackTrace();
				} 
		    }
		});
		
		intalacionTextField.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		    	try {
		    		utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, false);
					caracteristicas.setCantPasosInstalacion(Double.parseDouble(newValue));
				} catch (NumberFormatException | CaracteristicaException e) {
					utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, true);
					e.printStackTrace();
				} 
		    }
		});
		
		multiSOTextField.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		    	try {
		    		utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, false);
					caracteristicas.setCantSOCompatibles(Double.parseDouble(newValue));
				} catch (NumberFormatException | CaracteristicaException e) {
					utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, true);
					e.printStackTrace();
				} 
		    }
		});
		
		porcentajeComentariosTextField.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		    	try {
		    		utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, false);
					caracteristicas.setPorcentajeComentariosPorMetodo(Double.parseDouble(newValue));
				} catch (NumberFormatException | CaracteristicaException e) {
					utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, true);
					e.printStackTrace();
				} 
		    }
		});
		
		utilizacionRecursosTextField.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		    	try {
		    		utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, false);
					caracteristicas.setUsoProcesador(Double.parseDouble(newValue));
				} catch (NumberFormatException | CaracteristicaException e) {
					utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, true);
					e.printStackTrace();
				} 
		    }
		});
		
		procesarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
        		ProcesarCaracteristicas.calcularCalidad(caracteristicas);
        		
        		String resultado = caracteristicas.getResultadoFinal().toString();
        		String funcionalidad = caracteristicas.getFuncionalidad().toString();
        		if(camposCargados()) {
        			mostrarResultado(resultado, resultLabel);
        			mostrarResultado(funcionalidad, funcionalidadResultLabel);
            		
        		}
            }
            
            
        });
		
		limpiarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	caracteristicas = new Caracteristicas();
            	reiniciarValorCampos();
            }
        });
		
	}

	/**
	 * Método utilizado para popular los ComboBox.
	 */
	private void popularCombos() {
		encriptacionDatosCombo.setItems(ListaSiNo);
		ayudaCombo.setItems(ListaSiNo);
		datosProcesadosCombo.setItems(ListaSiNo);
		fallaCriticaCombo.setItems(ListaSiNo);
		iniciarSesionCombo.setItems(ListaSiNo);
		manualUsuarioCombo.setItems(ListaSiNo);
		logCombo.setItems(ListaSiNo);
		estadoAnteriorCombo.setItems(ListaSiNo);
		capacidadSerOperadoCombo.setItems(ListaCapacidadOperado);
	}

	/*
	 * Método utilizado para limpiar los campos.
	 */
	@SuppressWarnings("unchecked")
	private void reiniciarValorCampos() {		
		for (ComboBox<String> comboBox : allComboBoxes) {
			comboBox.setValue("Seleccione un Valor");
			comboBox.pseudoClassStateChanged(errorClass, false);
    	};
		
		for (TextField textField : allTextFields) {
			textField.setText("Seleccione un Valor");
			textField.pseudoClassStateChanged(errorClass, false);
    	};
    	    	
    	for (Label label : allLabels) {
    		label.setText("");
    		label.pseudoClassStateChanged(buenoClass, false);
    		label.pseudoClassStateChanged(regularClass, false);
    		label.pseudoClassStateChanged(maloClass, false);	
    	}
		
	}
	
	/*
	 * Método utilizado para validar si todos los campos fueron completados.
	 */
	private boolean camposCargados() {
		
		
		
		return true;
	}
	
	/*
	 * Muestra el resultado obtenido de la caracteristica enviada en el Label enviado.
	 */
	private void mostrarResultado(String resultado, Label label) {
		label.pseudoClassStateChanged(buenoClass, false);
		label.pseudoClassStateChanged(regularClass, false);
		label.pseudoClassStateChanged(maloClass, false);
		
		label.setText(resultado);
		if (resultado.equals("BUENO")) {
			label.pseudoClassStateChanged(buenoClass, true);
		} else if (resultado.equals("REGULAR")) {
			label.pseudoClassStateChanged(regularClass, true);
		} else if (resultado.equals("MALO")) {
			label.pseudoClassStateChanged(maloClass, true);
		}
	}
	
	/**
	 * Método que valida que todos los componentes se encuentren en el FXML.
	 */
	private void validarComponentes() {
		assert encriptacionDatosCombo != null : "fx:id=\"encriptacionDatosCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert ayudaCombo != null : "fx:id=\"ayudaCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert datosProcesadosCombo != null : "fx:id=\"encriptacionDatosCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert fallaCriticaCombo != null : "fx:id=\"fallaCriticaCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert iniciarSesionCombo != null : "fx:id=\"iniciarSesionCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert manualUsuarioCombo != null : "fx:id=\"manualUsuarioCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert capacidadSerOperadoCombo != null : "fx:id=\"capacidadSerOperadoCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert logCombo != null : "fx:id=\"logCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert estadoAnteriorCombo != null : "fx:id=\"estadoAnteriorCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert complejidadCiclomaticaTextField != null : "fx:id=\"complejidadCiclomaticaTextField\" was not injected: check your FXML file 'Principal.fxml'.";
		assert comportamientoFrenteTiempoTextField != null : "fx:id=\"comportamientoFrenteTiempoTextField\" was not injected: check your FXML file 'Principal.fxml'.";
		assert exactitudResultadosTextField != null : "fx:id=\"exactitudResultadosTextField\" was not injected: check your FXML file 'Principal.fxml'.";
		assert intalacionTextField != null : "fx:id=\"intalacionTextField\" was not injected: check your FXML file 'Principal.fxml'.";
		assert multiSOTextField != null : "fx:id=\"multiSOTextField\" was not injected: check your FXML file 'Principal.fxml'.";
		assert porcentajeComentariosTextField != null : "fx:id=\"porcentajeComentariosTextField\" was not injected: check your FXML file 'Principal.fxml'.";
		assert utilizacionRecursosTextField != null : "fx:id=\"utilizacionRecursosTextField\" was not injected: check your FXML file 'Principal.fxml'.";
		assert procesarButton != null : "fx:id=\"procesarButton\" was not injected: check your FXML file 'Principal.fxml'.";
		assert limpiarButton != null : "fx:id=\"limpiarButton\" was not injected: check your FXML file 'Principal.fxml'.";
		assert usabilidadResultFLabel != null : "fx:id=\"usabilidadResultFLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert portabilidadResultLabel != null : "fx:id=\"portabilidadResultLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert mantenibilidadResultLabel != null : "fx:id=\"mantenibilidadResultLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert funcionalidadResultLabel != null : "fx:id=\"funcionalidadResultLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert fiabilidadResultLabel != null : "fx:id=\"fiabilidadResultLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert fiabilidadResultLabel2 != null : "fx:id=\"fiabilidadResultLabel2\" was not injected: check your FXML file 'Principal.fxml'.";
		assert eficienciaResultLabel != null : "fx:id=\"eficienciaResultLabel\" was not injected: check your FXML file 'Principal.fxml'.";
	}

}
