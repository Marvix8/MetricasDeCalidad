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
		
		return (valorAlcanzado/valorMaximo) * 100;
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
		
		if(caracteristicas.getAyduaContextual() != null && caracteristicas.getManualUsuarioIncorporado() != null) {
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
		
		if(caracteristicas.getAyduaContextual() != null && caracteristicas.getManualUsuarioIncorporado() != null) {
			 
			valor += medirCaracteristicaBooleana(caracteristicas.getAyduaContextual(), caracteristicas.getManualUsuarioIncorporado());
		
		}
		
		if(caracteristicas.getCapacidadDeSerOperado() != null) {
			
			if(caracteristicas.getCapacidadDeSerOperado() == CapacidadDeSerOperado.BUENO) {
				valor +=3;
			}
			else if(caracteristicas.getCapacidadDeSerOperado() == CapacidadDeSerOperado.REGULAR) {
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

}
