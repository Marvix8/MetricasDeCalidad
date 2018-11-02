package edu.unlam.metricas_calidad;

public class ProcesarCaracteristicas {
	
	public static final double LIMITE_INF_ORDEN_ERROR = 0.0000001;
	public static final double LIMITE_SUP_ORDEN_ERROR = 0.001;
	public static final double LIMITE_INF_USO_PROCESADOR = 10;
	public static final double LIMITE_SUP_USO_PROCESADOR = 30;
	public static final double LIMITE_INF_TIEMPO_SIN_INFORMAR_ESTADO = 2;
	public static final double LIMITE_SUP_TIEMPO_SIN_INFORMAR_ESTADO = 6;
	public static final double LIMITE_INF_PORCENTAJE_COMENTARIOS_POR_METODO = 30;
	public static final double LIMITE_SUP_PORCENTAJE_COMENTARIOS_POR_METODO = 70;
	public static final double LIMITE_INF_COMPLEJIDAD_CICLOMATICA = 10;
	public static final double LIMITE_SUP_COMPLEJIDAD_CICLOMATICA = 20;
	public static final double LIMITE_INF_CANTIDAD_SO_COMPATIBLES = 1;
	public static final double LIMITE_SUP_CANTIDAD_SO_COMPATIBLES = 3;
	public static final double LIMITE_INF_CANTIDAD_PASOS_INSTALACION = 3;
	public static final double LIMITE_SUP_CANTIDAD_PASOS_INSTALACION = 7;
	
	public static final double MEJOR_CALIFICACION = 3;

	public static double calcularCalidad(Caracteristicas caracteristicas) {
		
		double valorAlcanzado = calcularValorAlcanzado(caracteristicas);
		
		double valorMaximo = calcularValorMaximo(caracteristicas);
		
		double resultado = (valorAlcanzado/valorMaximo) * 100; 
		
		calificarCaracteristica(caracteristicas, resultado);
		
		return resultado;
	}
	
	private static double calcularValorMaximo(Caracteristicas caracteristicas) {
		
		double cantidadCaracteristicas = 0;
		
		if(caracteristicas.getEncriptacionDatos() != null && caracteristicas.getInicioSesionUsuarios() != null) {
			cantidadCaracteristicas ++;
		}
		
		if(caracteristicas.getOrdenError() != null) {
			cantidadCaracteristicas ++;
		}
		
		if(caracteristicas.getUsoProcesador() != null) {
			cantidadCaracteristicas ++;
		}
		
		if(caracteristicas.getTiempoSinInformarEstado() != null) {
			cantidadCaracteristicas ++;
		}
		
		if(caracteristicas.getProteccionDatosProcesados() != null && caracteristicas.getLogActividades() != null) {
			cantidadCaracteristicas ++;
		}
		
		if(caracteristicas.getReanudarActividadAnteFalla() != null && caracteristicas.getReanudarEnEstadoAnterior() != null) {
			cantidadCaracteristicas ++;
		}
		
		if(caracteristicas.getPorcentajeComentariosPorMetodo() != null) {
			cantidadCaracteristicas ++;
		}
		
		if(caracteristicas.getComplejidadCiclomatica() != null) {
			cantidadCaracteristicas ++;
		}
		
		if(caracteristicas.getAyudaContextual() != null && caracteristicas.getManualUsuarioIncorporado() != null) {
			cantidadCaracteristicas ++;
		}
		
		if(caracteristicas.getCapacidadDeSerOperado() != null) {
			cantidadCaracteristicas ++;
		}
		
		if(caracteristicas.getCantSOCompatibles() != null) {
			cantidadCaracteristicas ++;
		}
		
		if(caracteristicas.getCantPasosInstalacion() != null) {
			cantidadCaracteristicas ++;
		}
		
		return cantidadCaracteristicas * MEJOR_CALIFICACION;
	}

	private static double calcularValorAlcanzado(Caracteristicas caracteristicas) {
		
		double valor = 0;
		
		if(caracteristicas.getEncriptacionDatos() != null && caracteristicas.getInicioSesionUsuarios() != null) {
			 
			valor += medirCaracteristicaBooleana(caracteristicas.getEncriptacionDatos(), caracteristicas.getInicioSesionUsuarios());

		}
		
		if(caracteristicas.getOrdenError() != null) {
			
			valor += medirCaracteristicaEnIntervalo(caracteristicas.getOrdenError(), LIMITE_SUP_ORDEN_ERROR, LIMITE_INF_ORDEN_ERROR, false);
			
		}
		
		if(caracteristicas.getUsoProcesador() != null) {
			
			valor += medirCaracteristicaEnIntervalo(caracteristicas.getUsoProcesador(), LIMITE_SUP_USO_PROCESADOR, LIMITE_INF_USO_PROCESADOR, false);
		
		}
		
		if(caracteristicas.getTiempoSinInformarEstado() != null) {
			
			valor += medirCaracteristicaEnIntervalo(caracteristicas.getTiempoSinInformarEstado(), LIMITE_SUP_TIEMPO_SIN_INFORMAR_ESTADO, LIMITE_INF_TIEMPO_SIN_INFORMAR_ESTADO, false);
		
		}
		
		if(caracteristicas.getProteccionDatosProcesados() != null && caracteristicas.getLogActividades() != null) {
			 
			valor += medirCaracteristicaBooleana(caracteristicas.getProteccionDatosProcesados(), caracteristicas.getLogActividades());

		}
		
		if(caracteristicas.getReanudarActividadAnteFalla() != null && caracteristicas.getReanudarEnEstadoAnterior() != null) {
			 
			valor += medirCaracteristicaBooleana(caracteristicas.getReanudarActividadAnteFalla(), caracteristicas.getReanudarEnEstadoAnterior());
		
		}
		
		if(caracteristicas.getPorcentajeComentariosPorMetodo() != null) {
			
			valor += medirCaracteristicaEnIntervalo(caracteristicas.getPorcentajeComentariosPorMetodo(), LIMITE_SUP_PORCENTAJE_COMENTARIOS_POR_METODO, LIMITE_INF_PORCENTAJE_COMENTARIOS_POR_METODO, true);
		
		}
		
		if(caracteristicas.getComplejidadCiclomatica() != null) {
			
			valor += medirCaracteristicaEnIntervalo(caracteristicas.getComplejidadCiclomatica(), LIMITE_SUP_COMPLEJIDAD_CICLOMATICA, LIMITE_INF_COMPLEJIDAD_CICLOMATICA, false);
		
		}
		
		if(caracteristicas.getAyudaContextual() != null && caracteristicas.getManualUsuarioIncorporado() != null) {
			 
			valor += medirCaracteristicaBooleana(caracteristicas.getAyudaContextual(), caracteristicas.getManualUsuarioIncorporado());
		
		}
		
		if(caracteristicas.getCapacidadDeSerOperado() != null) {
			
			if(caracteristicas.getCapacidadDeSerOperado() == Calificacion.BUENO) {
				valor +=3;
			}
			else if(caracteristicas.getCapacidadDeSerOperado() == Calificacion.REGULAR) {
				valor += 2;
			}
			else {
				valor ++;
			}
		}
		
		if(caracteristicas.getCantSOCompatibles() != null) {
			
			valor += medirCaracteristicaEnIntervalo(caracteristicas.getCantSOCompatibles(), LIMITE_SUP_CANTIDAD_SO_COMPATIBLES, LIMITE_INF_CANTIDAD_SO_COMPATIBLES, true);
		
		}
		
		if(caracteristicas.getCantPasosInstalacion() != null) {
			
			valor += medirCaracteristicaEnIntervalo(caracteristicas.getCantPasosInstalacion(), LIMITE_SUP_CANTIDAD_PASOS_INSTALACION, LIMITE_INF_CANTIDAD_PASOS_INSTALACION, false);
		
		}
		
		return valor;
	}
	
	
	
	//la logicaPosiva quiere decir que cuanto mayor sea el valor de la caracteristica mejor es
	private static double medirCaracteristicaEnIntervalo(Double caracteristica, double limiteSup, double limiteInf, boolean logicaPositiva) {
		
			if(logicaPositiva) {
				if(caracteristica >= limiteSup) {
					return 3;
				}
				else if(caracteristica <= limiteInf) {
					return 1;
				}
				
			}
			else {
				if(caracteristica >= limiteSup) {
					return 1;
				}
				else if(caracteristica <= limiteInf) {
					return 3;
				}
				
			}
		//si se encuentra dentro del intervalo es regular(2)
		return 2;
	}
	
	
	
	private static double medirCaracteristicaBooleana(Boolean proposicion1, Boolean proposicion2) {
		
		if(proposicion1  && proposicion2) {
			return 3;
		}
		else if( (!proposicion1  && proposicion2 ) || (proposicion1  && !proposicion2 ) ){
			return 2;
		}
		else {
			return 1;
		}
	}
	
	private static void calificarCaracteristica(Caracteristicas caracteristicas, Double resultado) {
		
		int cantidadMalos = 0;
		
		// Se califica la característica Seguridad de Acceso..
		if(caracteristicas.getEncriptacionDatos() && caracteristicas.getInicioSesionUsuarios()) {
			caracteristicas.setSeguridadAcceso(Calificacion.BUENO);
		} else if (caracteristicas.getEncriptacionDatos() || caracteristicas.getInicioSesionUsuarios()) {
			caracteristicas.setSeguridadAcceso(Calificacion.REGULAR);
		} else {
			caracteristicas.setSeguridadAcceso(Calificacion.MALO);
			cantidadMalos ++;
		}		

		// Se califica la característica Exactitud de los Resultados.
		if (caracteristicas.getOrdenError() >= -3) {
			caracteristicas.setExactitudResultados(Calificacion.MALO);
			cantidadMalos ++;
		} else if (caracteristicas.getOrdenError() <= -7) {
			caracteristicas.setExactitudResultados(Calificacion.BUENO);
		} else {
			caracteristicas.setExactitudResultados(Calificacion.REGULAR);
		}
		
		// Se califica la característica Utilización de Recursos.
		if (caracteristicas.getUsoProcesador() >= 30.00) {
			caracteristicas.setUtilizacionRecursos(Calificacion.MALO);
			cantidadMalos ++;
		} else if (caracteristicas.getUsoProcesador() <= 10.00) {
			caracteristicas.setUtilizacionRecursos(Calificacion.BUENO);
		} else {
			caracteristicas.setUtilizacionRecursos(Calificacion.REGULAR);
		}
		
		// Se califica la característica Comportamiento Frente al Tiempo.
		if (caracteristicas.getTiempoSinInformarEstado() >= 6) {
			caracteristicas.setComportamientoFrenteTiempo(Calificacion.MALO);
			cantidadMalos ++;
		} else if (caracteristicas.getTiempoSinInformarEstado() <= 2) {
			caracteristicas.setComportamientoFrenteTiempo(Calificacion.BUENO);
		} else {
			caracteristicas.setComportamientoFrenteTiempo(Calificacion.REGULAR);
		}
		
		// Se califica la característica Tolerancia a Fallos.
		if (caracteristicas.getProteccionDatosProcesados() && caracteristicas.getLogActividades()) {
			caracteristicas.setToleranciaFallos(Calificacion.BUENO);
		} else if (caracteristicas.getProteccionDatosProcesados() || caracteristicas.getLogActividades()) {
			caracteristicas.setToleranciaFallos(Calificacion.REGULAR);
		} else {
			caracteristicas.setToleranciaFallos(Calificacion.MALO);
			cantidadMalos ++;
		}
		
		// Se califica la característica Capacidad de Recuperación de Errores.
		if (caracteristicas.getReanudarActividadAnteFalla() && caracteristicas.getReanudarEnEstadoAnterior()) {
			caracteristicas.setCapacidadRecuperacionErrores(Calificacion.BUENO);
		} else if (caracteristicas.getReanudarActividadAnteFalla() || caracteristicas.getReanudarEnEstadoAnterior()) {
			caracteristicas.setCapacidadRecuperacionErrores(Calificacion.REGULAR);
		} else {
			caracteristicas.setCapacidadRecuperacionErrores(Calificacion.MALO);
			cantidadMalos ++;
		}
		
		// Se califica la característica Capacidad del Código de ser Analizado.
		if (caracteristicas.getPorcentajeComentariosPorMetodo() <= 30.00) {
			caracteristicas.setCapacidadDeSerAnalizado(Calificacion.MALO);
			cantidadMalos ++;
		} else if (caracteristicas.getPorcentajeComentariosPorMetodo() > 70.00) {
			caracteristicas.setCapacidadDeSerAnalizado(Calificacion.BUENO);
		} else {
			caracteristicas.setCapacidadDeSerAnalizado(Calificacion.REGULAR);
		}
		
		// Se califica la característica Capacidad del Código de ser Cambiado.
		if (caracteristicas.getComplejidadCiclomatica() >= 20) {
			caracteristicas.setCapacidadDeSerAnalizado(Calificacion.MALO);
			cantidadMalos ++;
		} else if (caracteristicas.getPorcentajeComentariosPorMetodo() <= 10) {
			caracteristicas.setCapacidadDeSerAnalizado(Calificacion.BUENO);
		} else {
			caracteristicas.setCapacidadDeSerAnalizado(Calificacion.REGULAR);
		}		
		
		// Se califica la característica Capacidad de ser Entendido.
		if (caracteristicas.getAyudaContextual() && caracteristicas.getManualUsuarioIncorporado()) {
			caracteristicas.setCapacidadDeSerEntendido(Calificacion.BUENO);
		} else if (caracteristicas.getAyudaContextual() || caracteristicas.getManualUsuarioIncorporado()) {
			caracteristicas.setCapacidadDeSerEntendido(Calificacion.REGULAR);
		} else {
			caracteristicas.setCapacidadDeSerEntendido(Calificacion.MALO);
			cantidadMalos ++;
		}
		
		// Se califica la característica Capacidad de ser Operado.
		if (caracteristicas.getCapacidadDeSerOperado().equals(Calificacion.MALO)) {
			cantidadMalos ++;
		}
		
		// Se califica la característica Adaptabilidad.
		if (caracteristicas.getCantSOCompatibles() == 1) {
			caracteristicas.setAdaptabilidad(Calificacion.MALO);
			cantidadMalos ++;
		} else if (caracteristicas.getCantSOCompatibles() == 2) {
			caracteristicas.setAdaptabilidad(Calificacion.REGULAR);
		} else {
			caracteristicas.setAdaptabilidad(Calificacion.BUENO);
		}
		
		// Se califica la característica Instalabilidad.
		if (caracteristicas.getCantPasosInstalacion() >= 7) {
			caracteristicas.setAdaptabilidad(Calificacion.MALO);
			cantidadMalos ++;
		} else if (caracteristicas.getCantPasosInstalacion() <= 3) {
			caracteristicas.setAdaptabilidad(Calificacion.BUENO);
		} else {
			caracteristicas.setAdaptabilidad(Calificacion.REGULAR);
		}	
		
		// Se califica toda la aplicación en función del resultado.
		if (resultado <= 40.00 || cantidadMalos > 0) {
			caracteristicas.setResultadoFinal(Calificacion.MALO);
		} else if (resultado >= 70.00) {
			caracteristicas.setResultadoFinal(Calificacion.BUENO);
		} else {
			caracteristicas.setResultadoFinal(Calificacion.REGULAR);
		}
		
	}

}
