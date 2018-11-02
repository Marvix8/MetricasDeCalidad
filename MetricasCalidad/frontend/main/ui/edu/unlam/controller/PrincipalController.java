package edu.unlam.controller;


import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Tooltip;

public class PrincipalController implements Initializable{

	/*
	 * Principal's ComboBox
	 */
	@FXML // fx:id="encriptacionDatosCombo"
	private ComboBox<String> encriptacionDatosCombo;
	
	@FXML // fx:id="ayudaCombo"
	private ComboBox<String> ayudaCombo;
	
	@FXML // fx:id="exactitudResultadosCombo"
	private ComboBox<String> exactitudResultadosCombo;
	
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
	@FXML // fx:id="adaptabilidadResultLabel"
	private Label adaptabilidadResultLabel;
	
	@FXML // fx:id="resultLabel"
	private Label resultLabel;
	
	@FXML // fx:id="utilizacionRecursosResultLabel"
	private Label utilizacionRecursosResultLabel;
	
	@FXML // fx:id="toleranciaFallosResultLabel"
	private Label toleranciaFallosResultLabel;
	
	@FXML // fx:id="seguridadAccesoResultLabel"
	private Label seguridadAccesoResultLabel;
	
	@FXML // fx:id="instalabilidadResultLabel"
	private Label instalabilidadResultLabel;
	
	@FXML // fx:id="exactitudResultadosResultLabel"
	private Label exactitudResultadosResultLabel;
	
	@FXML // fx:id="comportamienteFrenteTiempoResultLabel"
	private Label comportamienteFrenteTiempoResultLabel;
	
	@FXML // fx:id="capacidadSerOperadoResultLabel"
	private Label capacidadSerOperadoResultLabel;
	
	@FXML // fx:id="capacidadSerEntendidoResultLabel"
	private Label capacidadSerEntendidoResultLabel;
	
	@FXML // fx:id="capacidadRecuperacionErroresResultLabel"
	private Label capacidadRecuperacionErroresResultLabel;
	
	@FXML // fx:id="capacidadCodigoSerCambiadoResultLabel"
	private Label capacidadCodigoSerCambiadoResultLabel;
	
	@FXML // fx:id="capacidadCodigoSerAnalizadoResultLabel"
	private Label capacidadCodigoSerAnalizadoResultLabel;
	
	/*
	 * Principal's tooltips 
	 */
    @FXML // fx:id="exactitudResultadosToolTip"
    private Tooltip exactitudResultadosToolTip;
    
    @FXML // fx:id="utilizacionRecursosToolTip"
    private Tooltip utilizacionRecursosToolTip;
    
    @FXML // fx:id="comportamientoFrenteTiempoToolTip"
    private Tooltip comportamientoFrenteTiempoToolTip;
    
    @FXML // fx:id="capacidadSerOperadoToolTip"
    private Tooltip capacidadSerOperadoToolTip;
    
    @FXML // fx:id="multiSOToolTip"
    private Tooltip multiSOToolTip;
    
    @FXML // fx:id="resultadoToolTip"
    private Tooltip resultadoToolTip;

	// PseudoClass usada para marcar con rojo lo que está mal ingresado.
	final private PseudoClass errorClass = PseudoClass.getPseudoClass("error");
	
	
	// PseudoClass usadas para setear color de resultLabel según el obtenido.
	final private PseudoClass buenoClass = PseudoClass.getPseudoClass("bueno");
	final private PseudoClass regularClass = PseudoClass.getPseudoClass("regular");
	final private PseudoClass maloClass = PseudoClass.getPseudoClass("malo");

	// Array con todos los ComboBoxes
	@SuppressWarnings("rawtypes")
	private ArrayList<ComboBox> allComboBoxes;
	
	// Array con todos los TextFields
	private ArrayList<TextField> allTextFields;
	
	// Array con todos los Labels
	private ArrayList <Label> allLabels;
	
	// Listado usado para popular combos con valor SI o NO
	ObservableList<String> ListaSiNo = FXCollections.observableArrayList("SI","NO");
	
	// Listado usado para popular el combo fx:id="capacidadSerOperadoCombo"
	ObservableList<String> ListaCapacidadOperado = FXCollections.observableArrayList(
			"Se Consulta a Personal Especializado",
			"Se Requiere Manual de Usuario",
			"Se Opera Sin Asistencia");
	
	// Listado usado para popular el combo fx:id="exactitudResultadosComboBox"
		ObservableList<String> ListaExactitudResultados = FXCollections.observableArrayList(
			"<= 10^(-8)",
			"< 10^(-8) && > 10^(-7)",
			"<= 10^(-7)");

		/*
		 * Flags que indican si se completó el campo.
		 */
		private boolean encriptacionDatosflag;
		private boolean ayudaflag;
		private boolean exactitudResultadosflag;
		private boolean datosProcesadosflag;
		private boolean capacidadSerOperadoflag;
		private boolean fallaCriticaflag;
		private boolean iniciarSesionflag;
		private boolean manualUsuarioflag;
		private boolean logflag;
		private boolean estadoAnteriorflag;
		private boolean complejidadCiclomaticaflag;
		private boolean comportamientoFrenteTiempoflag;
		private boolean intalacionflag;
		private boolean multiSOflag;
		private boolean porcentajeComentariosflag;
		private boolean utilizacionRecursosflag;		
		
		
	/*
	 *  Objeto Característica
	 */
	Caracteristicas caracteristicas;
		
	/*
	 * El método es llamado por FXMLLOADER cuando la inicialización finalizó.
	 */
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		// Valido que todos los componentes se encuentren en mi archivo FXML.
		validarComponentes();
		// Populo los combos.
		popularCombos();
		
		// Inicializar arrays de componentes
		textFieldList();
		labelList();
		comboBoxList();
		
		// Inicializó los valores.
		inicializarValores();
		
		caracteristicas = new Caracteristicas();
		
		encriptacionDatosCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				encriptacionDatosCombo.pseudoClassStateChanged(errorClass, false);
				if (encriptacionDatosCombo.getValue().equals("SI")) {
					encriptacionDatosflag = true;
					caracteristicas.setEncriptacionDatos(true);
				} else if (encriptacionDatosCombo.getValue().equals("NO")) {
					caracteristicas.setEncriptacionDatos(false);
					encriptacionDatosflag = true;
				}
			}
	    });
		
		ayudaCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				ayudaCombo.pseudoClassStateChanged(errorClass, false);
				if (ayudaCombo.getValue().equals("SI")) {
					ayudaflag = true;
					caracteristicas.setAyudaContextual(true);
				} else if (ayudaCombo.getValue().equals("NO")) {
					ayudaflag = true;
					caracteristicas.setAyudaContextual(false);
				}
			}
	    });
		
		datosProcesadosCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				datosProcesadosCombo.pseudoClassStateChanged(errorClass, false);
				if (datosProcesadosCombo.getValue().equals("SI")) {
					datosProcesadosflag = true;
					caracteristicas.setProteccionDatosProcesados(true);;
				} else if (datosProcesadosCombo.getValue().equals("NO")) {
					datosProcesadosflag = true;
					caracteristicas.setProteccionDatosProcesados(false);
				}
			}
	    });
		
		fallaCriticaCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				fallaCriticaCombo.pseudoClassStateChanged(errorClass, false);
				if (fallaCriticaCombo.getValue().equals("SI")) {
					fallaCriticaflag = true;
					caracteristicas.setReanudarActividadAnteFalla(true);;
				} else if (fallaCriticaCombo.getValue().equals("NO")) {
					fallaCriticaflag = true;
					caracteristicas.setReanudarActividadAnteFalla(false);
				}
			}
	    });
		
		iniciarSesionCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				iniciarSesionCombo.pseudoClassStateChanged(errorClass, false);
				if (iniciarSesionCombo.getValue().equals("SI")) {
					iniciarSesionflag = true;
					caracteristicas.setInicioSesionUsuarios(true);;
				} else if (iniciarSesionCombo.getValue().equals("NO")) {
					iniciarSesionflag = true;
					caracteristicas.setInicioSesionUsuarios(false);
				}
			}
	    });
		
		manualUsuarioCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				manualUsuarioCombo.pseudoClassStateChanged(errorClass, false);
				if (manualUsuarioCombo.getValue().equals("SI")) {
					manualUsuarioflag = true;
					caracteristicas.setManualUsuarioIncorporado(true);;
				} else if (manualUsuarioCombo.getValue().equals("NO")) {
					manualUsuarioflag = true;
					caracteristicas.setManualUsuarioIncorporado(false);
				}
			}
	    });
		
		logCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				logCombo.pseudoClassStateChanged(errorClass, false);
				if (logCombo.getValue().equals("SI")) {
					logflag = true;
					caracteristicas.setLogActividades(true);;
				} else if (logCombo.getValue().equals("NO")) {
					logflag = true;
					caracteristicas.setLogActividades(false);
				}
			}
	    });
		
		estadoAnteriorCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				estadoAnteriorCombo.pseudoClassStateChanged(errorClass, false);
				if (estadoAnteriorCombo.getValue().equals("SI")) {
					estadoAnteriorflag = true;
					caracteristicas.setReanudarEnEstadoAnterior(true);;
				} else if (estadoAnteriorCombo.getValue().equals("NO")) {
					estadoAnteriorflag = true;
					caracteristicas.setReanudarEnEstadoAnterior(false);
				}
			}
	    });
		
		capacidadSerOperadoCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override 
			public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
				capacidadSerOperadoCombo.pseudoClassStateChanged(errorClass, false);
				if (capacidadSerOperadoCombo.getValue().equals("Se Consulta a Personal Especializado")) {
					capacidadSerOperadoflag = true;
					caracteristicas.setCapacidadDeSerOperado(Calificacion.MALO);
				} else if (capacidadSerOperadoCombo.getValue().equals("Se Requiere Manual de Usuario")) {
					capacidadSerOperadoflag = true;
					caracteristicas.setCapacidadDeSerOperado(Calificacion.REGULAR);
				} else if (capacidadSerOperadoCombo.getValue().equals("Se Opera Sin Asistencia")) {
					capacidadSerOperadoflag = true;
					caracteristicas.setCapacidadDeSerOperado(Calificacion.BUENO);
				}
			}
	    });
		
		exactitudResultadosCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		    	exactitudResultadosCombo.pseudoClassStateChanged(errorClass, false);
		    	if (exactitudResultadosCombo.getValue().equals("<= 10^(-8)")) {
		    		exactitudResultadosflag = true;
					caracteristicas.setExactitudResultados(Calificacion.MALO);
				} else if (exactitudResultadosCombo.getValue().equals("< 10^(-8) && > 10^(-7)")) {
					exactitudResultadosflag = true;
					caracteristicas.setExactitudResultados(Calificacion.REGULAR);
				} else if (exactitudResultadosCombo.getValue().equals("<= 10^(-7)")) {
					exactitudResultadosflag = true;
					caracteristicas.setExactitudResultados(Calificacion.BUENO);
				}
		    }
		});
		
		complejidadCiclomaticaTextField.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		    	try {
		    		complejidadCiclomaticaTextField.pseudoClassStateChanged(errorClass, false);
					caracteristicas.setComplejidadCiclomatica(Double.parseDouble(newValue));
					complejidadCiclomaticaflag = true;
				} catch (NumberFormatException | CaracteristicaException e) {
					complejidadCiclomaticaflag = false;
					complejidadCiclomaticaTextField.pseudoClassStateChanged(errorClass, true);
				} 
		    }
		});
		
		comportamientoFrenteTiempoTextField.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		    	try {
		    		comportamientoFrenteTiempoTextField.pseudoClassStateChanged(errorClass, false);
					caracteristicas.setTiempoSinInformarEstado(Double.parseDouble(newValue));
					comportamientoFrenteTiempoflag = true;
				} catch (NumberFormatException | CaracteristicaException e) {
					comportamientoFrenteTiempoflag = false;
					comportamientoFrenteTiempoTextField.pseudoClassStateChanged(errorClass, true);
				} 
		    }
		});
		
		intalacionTextField.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		    	try {
		    		intalacionTextField.pseudoClassStateChanged(errorClass, false);
					caracteristicas.setCantPasosInstalacion(Double.parseDouble(newValue));
					intalacionflag = true;
				} catch (NumberFormatException | CaracteristicaException e) {
					intalacionflag = false;
					intalacionTextField.pseudoClassStateChanged(errorClass, true);
				} 
		    }
		});
		
		multiSOTextField.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		    	try {
		    		multiSOTextField.pseudoClassStateChanged(errorClass, false);
					caracteristicas.setCantSOCompatibles(Double.parseDouble(newValue));
					multiSOflag = true;
				} catch (NumberFormatException | CaracteristicaException e) {
					multiSOflag = false;
					multiSOTextField.pseudoClassStateChanged(errorClass, true);
				} 
		    }
		});
		
		porcentajeComentariosTextField.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		    	try {
		    		porcentajeComentariosTextField.pseudoClassStateChanged(errorClass, false);
					caracteristicas.setPorcentajeComentariosPorMetodo(Double.parseDouble(newValue));
					porcentajeComentariosflag = true;
				} catch (NumberFormatException | CaracteristicaException e) {
					porcentajeComentariosflag = false;
					porcentajeComentariosTextField.pseudoClassStateChanged(errorClass, true);
				} 
		    }
		});
		
		utilizacionRecursosTextField.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		    	try {
		    		utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, false);
					caracteristicas.setUsoProcesador(Double.parseDouble(newValue));
					utilizacionRecursosflag = true;
				} catch (NumberFormatException | CaracteristicaException e) {
					utilizacionRecursosflag = false;
					utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, true);
				} 
		    }
		});
		
		procesarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
        		if(camposCargados()) {
        			ProcesarCaracteristicas.calcularCalidad(caracteristicas);
        			
        			// Muestro resultados
        			mostrarResultado(caracteristicas.getSeguridadAcceso().toString(), seguridadAccesoResultLabel);
        			mostrarResultado(caracteristicas.getExactitudResultados().toString(), exactitudResultadosResultLabel);
        			mostrarResultado(caracteristicas.getUtilizacionRecursos().toString(), utilizacionRecursosResultLabel);
        			mostrarResultado(caracteristicas.getComportamientoFrenteTiempo().toString(), comportamienteFrenteTiempoResultLabel);
        			mostrarResultado(caracteristicas.getToleranciaFallos().toString(), toleranciaFallosResultLabel);
        			mostrarResultado(caracteristicas.getCapacidadRecuperacionErrores().toString(), capacidadRecuperacionErroresResultLabel);
        			mostrarResultado(caracteristicas.getCapacidadDeSerAnalizado().toString(), capacidadCodigoSerAnalizadoResultLabel);
        			mostrarResultado(caracteristicas.getCapacidadDeSerCambiado().toString(), capacidadCodigoSerCambiadoResultLabel);
        			mostrarResultado(caracteristicas.getCapacidadDeSerEntendido().toString(), capacidadSerEntendidoResultLabel);
        			mostrarResultado(caracteristicas.getCapacidadDeSerOperado().toString(), capacidadSerOperadoResultLabel);
        			mostrarResultado(caracteristicas.getAdaptabilidad().toString(), adaptabilidadResultLabel);
        			mostrarResultado(caracteristicas.getInstalabilidad().toString(), instalabilidadResultLabel);
        			mostrarResultado(caracteristicas.getResultadoFinal().toString(), resultLabel);
            		
        			// Muestro mensaje indicando resultado general.
        			ResultMessageController.mensajeResultado(caracteristicas.getResultadoFinal().toString()).showAndWait();
        			
        		} else {
        			// Muestro mensaje indicando que no se completaron todos los campos.
        			ErrorMessageController.mensajeError().showAndWait();
        		}
            }
            
            
        });
		
		limpiarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	inicializarValores();
            	caracteristicas = new Caracteristicas();
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
		exactitudResultadosCombo.setItems(ListaExactitudResultados);
	}

	/*
	 * Método utilizado para limpiar los campos.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void inicializarValores() {
		encriptacionDatosflag = false;
		ayudaflag = false;
		exactitudResultadosflag = false;
		datosProcesadosflag = false;
		capacidadSerOperadoflag = false;
		fallaCriticaflag = false;
		iniciarSesionflag = false;
		manualUsuarioflag = false;
		logflag = false;
		estadoAnteriorflag = false;
		complejidadCiclomaticaflag = false;
		comportamientoFrenteTiempoflag = false;
		intalacionflag = false;
		multiSOflag = false;
		porcentajeComentariosflag = false;
		utilizacionRecursosflag = false;	
		
		for (TextField textField : allTextFields) {
			textField.setText("");
			textField.pseudoClassStateChanged(errorClass, false);
    	};
		
		for (ComboBox comboBox : allComboBoxes) {
			comboBox.setValue("Seleccione un Valor");
			comboBox.pseudoClassStateChanged(errorClass, false);
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
		boolean todosCompletos = true;
		
		if (encriptacionDatosflag == true) ; else {
			encriptacionDatosCombo.pseudoClassStateChanged(errorClass, true);
			todosCompletos = false;
		}
		if (ayudaflag == true) ; else {
			ayudaCombo.pseudoClassStateChanged(errorClass, true);
			todosCompletos = false;
		}
		if (exactitudResultadosflag == true) ; else {
			exactitudResultadosCombo.pseudoClassStateChanged(errorClass, true);
			todosCompletos = false;
		}
		if (datosProcesadosflag == true) ; else {
			datosProcesadosCombo.pseudoClassStateChanged(errorClass, true);
			todosCompletos = false;
		}
		if (capacidadSerOperadoflag == true) ; else {
			capacidadSerOperadoCombo.pseudoClassStateChanged(errorClass, true);
			todosCompletos = false;
		}
		if (fallaCriticaflag == true) ; else {
			fallaCriticaCombo.pseudoClassStateChanged(errorClass, true);
			todosCompletos = false;
		}
		if (iniciarSesionflag == true) ; else {
			iniciarSesionCombo.pseudoClassStateChanged(errorClass, true);
			todosCompletos = false;
		}
		if (manualUsuarioflag == true) ; else {
			manualUsuarioCombo.pseudoClassStateChanged(errorClass, true);
			todosCompletos = false;
		}
		if (logflag == true) ; else {
			logCombo.pseudoClassStateChanged(errorClass, true);
			todosCompletos = false;
		}
		if (estadoAnteriorflag == true) ; else {
			estadoAnteriorCombo.pseudoClassStateChanged(errorClass, true);
			todosCompletos = false;
		}
		if (complejidadCiclomaticaflag == true) ; else {
			complejidadCiclomaticaTextField.pseudoClassStateChanged(errorClass, true);
			todosCompletos = false;
		}
		if (comportamientoFrenteTiempoflag == true) ; else {
			comportamientoFrenteTiempoTextField.pseudoClassStateChanged(errorClass, true);
			todosCompletos = false;
		}
		if (intalacionflag == true) ; else {
			intalacionTextField.pseudoClassStateChanged(errorClass, true);
			todosCompletos = false;
		}
		if (multiSOflag == true) ; else {
			multiSOTextField.pseudoClassStateChanged(errorClass, true);
			todosCompletos = false;
		}
		if (porcentajeComentariosflag == true) ; else {
			porcentajeComentariosTextField.pseudoClassStateChanged(errorClass, true);
			todosCompletos = false;
		}
		if (utilizacionRecursosflag == true) ; else {
			utilizacionRecursosTextField.pseudoClassStateChanged(errorClass, true);
			todosCompletos = false;
		}
		
		return todosCompletos;
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
		assert exactitudResultadosCombo != null : "fx:id=\"exactitudResultadosComboBox\" was not injected: check your FXML file 'Principal.fxml'.";
		assert datosProcesadosCombo != null : "fx:id=\"encriptacionDatosCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert fallaCriticaCombo != null : "fx:id=\"fallaCriticaCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert iniciarSesionCombo != null : "fx:id=\"iniciarSesionCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert manualUsuarioCombo != null : "fx:id=\"manualUsuarioCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert capacidadSerOperadoCombo != null : "fx:id=\"capacidadSerOperadoCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert logCombo != null : "fx:id=\"logCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert estadoAnteriorCombo != null : "fx:id=\"estadoAnteriorCombo\" was not injected: check your FXML file 'Principal.fxml'.";
		assert complejidadCiclomaticaTextField != null : "fx:id=\"complejidadCiclomaticaTextField\" was not injected: check your FXML file 'Principal.fxml'.";
		assert comportamientoFrenteTiempoTextField != null : "fx:id=\"comportamientoFrenteTiempoTextField\" was not injected: check your FXML file 'Principal.fxml'.";
		assert intalacionTextField != null : "fx:id=\"intalacionTextField\" was not injected: check your FXML file 'Principal.fxml'.";
		assert multiSOTextField != null : "fx:id=\"multiSOTextField\" was not injected: check your FXML file 'Principal.fxml'.";
		assert porcentajeComentariosTextField != null : "fx:id=\"porcentajeComentariosTextField\" was not injected: check your FXML file 'Principal.fxml'.";
		assert utilizacionRecursosTextField != null : "fx:id=\"utilizacionRecursosTextField\" was not injected: check your FXML file 'Principal.fxml'.";
		assert procesarButton != null : "fx:id=\"procesarButton\" was not injected: check your FXML file 'Principal.fxml'.";
		assert limpiarButton != null : "fx:id=\"limpiarButton\" was not injected: check your FXML file 'Principal.fxml'.";
		assert adaptabilidadResultLabel != null : "fx:id=\"usabilidadResultFLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert utilizacionRecursosResultLabel != null : "fx:id=\"portabilidadResultLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert toleranciaFallosResultLabel != null : "fx:id=\"mantenibilidadResultLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert seguridadAccesoResultLabel != null : "fx:id=\"funcionalidadResultLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert instalabilidadResultLabel != null : "fx:id=\"fiabilidadResultLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert exactitudResultadosResultLabel != null : "fx:id=\"fiabilidadResultLabel2\" was not injected: check your FXML file 'Principal.fxml'.";
		assert comportamienteFrenteTiempoResultLabel != null : "fx:id=\"eficienciaResultLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert capacidadSerOperadoResultLabel != null : "fx:id=\"capacidadSerOperadoResultLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert capacidadSerEntendidoResultLabel != null : "fx:id=\"capacidadSerEntendidoResultLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert capacidadRecuperacionErroresResultLabel != null : "fx:id=\"capacidadRecuperacionErroresResultLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert capacidadCodigoSerAnalizadoResultLabel != null : "fx:id=\"capacidadCodigoSerAnalizadoResultLabel\" was not injected: check your FXML file 'Principal.fxml'.";
		assert exactitudResultadosToolTip != null : "fx:id=\"exactitudResultadosToolTip\" was not injected: check your FXML file 'Principal.fxml'.";
		assert utilizacionRecursosToolTip != null : "fx:id=\"utilizacionRecursosToolTip\" was not injected: check your FXML file 'Principal.fxml'.";
		assert comportamientoFrenteTiempoToolTip != null : "fx:id=\"comportamientoFrenteTiempoToolTip\" was not injected: check your FXML file 'Principal.fxml'.";
		assert capacidadSerOperadoToolTip != null : "fx:id=\"capacidadSerOperadoToolTip\" was not injected: check your FXML file 'Principal.fxml'.";
		assert multiSOToolTip != null : "fx:id=\"multiSOToolTip\" was not injected: check your FXML file 'Principal.fxml'.";
		assert resultadoToolTip != null : "fx:id=\"resultadoToolTip\" was not injected: check your FXML file 'Principal.fxml'.";

	}
	
	private void textFieldList() {
		allTextFields = new ArrayList<TextField>();
		allTextFields.add(complejidadCiclomaticaTextField);
		allTextFields.add(comportamientoFrenteTiempoTextField);
		allTextFields.add(intalacionTextField);
		allTextFields.add(multiSOTextField);
		allTextFields.add(porcentajeComentariosTextField);
		allTextFields.add(utilizacionRecursosTextField);
		
	}
	
	@SuppressWarnings("rawtypes")
	private void comboBoxList() {
		allComboBoxes = new ArrayList<ComboBox>();
		allComboBoxes.add(encriptacionDatosCombo);
		allComboBoxes.add(ayudaCombo);
		allComboBoxes.add(exactitudResultadosCombo);
		allComboBoxes.add(datosProcesadosCombo);
		allComboBoxes.add(capacidadSerOperadoCombo);
		allComboBoxes.add(fallaCriticaCombo);
		allComboBoxes.add(iniciarSesionCombo);
		allComboBoxes.add(manualUsuarioCombo);
		allComboBoxes.add(logCombo);
		allComboBoxes.add(estadoAnteriorCombo);
	}
	
	private void labelList() {
		allLabels = new ArrayList<Label>();
		allLabels.add(resultLabel);
		allLabels.add(seguridadAccesoResultLabel);
		allLabels.add(comportamienteFrenteTiempoResultLabel);
		allLabels.add(instalabilidadResultLabel);
		allLabels.add(exactitudResultadosResultLabel);
		allLabels.add(toleranciaFallosResultLabel);
		allLabels.add(adaptabilidadResultLabel);
		allLabels.add(utilizacionRecursosResultLabel);
		allLabels.add(capacidadSerOperadoResultLabel);
		allLabels.add(capacidadSerEntendidoResultLabel);
		allLabels.add(capacidadRecuperacionErroresResultLabel);
		allLabels.add(capacidadCodigoSerCambiadoResultLabel);
		allLabels.add(capacidadCodigoSerAnalizadoResultLabel);
	}
	
}
