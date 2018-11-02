package edu.unlam.metricas_calidad;

public class Caracteristicas {
	
	private Boolean encriptacionDatos;
	private Boolean inicioSesionUsuarios;
	private Double usoProcesador;
	private Double tiempoSinInformarEstado;
	private Boolean proteccionDatosProcesados;
	private Boolean logActividades;
	private Boolean reanudarActividadAnteFalla;
	private Boolean reanudarEnEstadoAnterior;
	private Double	porcentajeComentariosPorMetodo;
	private Double complejidadCiclomatica;
	private Boolean ayudaContextual;
	private Boolean manualUsuarioIncorporado;
	private Double cantSOCompatibles;
	private Double cantPasosInstalacion;
	
	/*
	 * Calificación de cada una de las Características Analizadas
	 */
	private Calificacion seguridadAcceso;
	private Calificacion exactitudResultados;
	private Calificacion utilizacionRecursos;
	private Calificacion comportamientoFrenteTiempo;
	private Calificacion toleranciaFallos;
	private Calificacion capacidadRecuperacionErrores;
	private Calificacion capacidadDeSerAnalizado;
	private Calificacion capacidadDeSerCambiado;
	private Calificacion capacidadDeSerEntendido;
	private Calificacion capacidadDeSerOperado;
	private Calificacion adaptabilidad;
	private Calificacion instalabilidad;
	
	private Calificacion resultadoFinal;
	
	public Boolean getEncriptacionDatos() {
		return encriptacionDatos;
	}
	
	public void setEncriptacionDatos(Boolean encriptacionDatos) {
		this.encriptacionDatos = encriptacionDatos;
	}
	
	public Boolean getInicioSesionUsuarios() {
		return inicioSesionUsuarios;
	}
	
	public void setInicioSesionUsuarios(Boolean inicioSesionUsuarios) {
		this.inicioSesionUsuarios = inicioSesionUsuarios;
	}
	
	public Double getUsoProcesador() {
		return usoProcesador;
	}
	
	public void setUsoProcesador(Double usoProcesador) throws CaracteristicaException {
		
		if(usoProcesador < 0 || usoProcesador > 100) {
			throw new CaracteristicaException("El uso del procesador debe ser un valor entre 0 y 100\n");
		}
		this.usoProcesador = usoProcesador;
	}
	
	public Double getTiempoSinInformarEstado() {
		return tiempoSinInformarEstado;
	}
	
	public void setTiempoSinInformarEstado(Double tiempoSinInformarEstado) throws CaracteristicaException {
		
		if(tiempoSinInformarEstado <= 0) {
			throw new CaracteristicaException("El tiempo debe ser un valor mayor a 0\n");
		}
		this.tiempoSinInformarEstado = tiempoSinInformarEstado;
	}
	
	public Boolean getProteccionDatosProcesados() {
		return proteccionDatosProcesados;
	}
	
	public void setProteccionDatosProcesados(Boolean proteccionDatosProcesados) {
		this.proteccionDatosProcesados = proteccionDatosProcesados;
	}
	
	public Boolean getLogActividades() {
		return logActividades;
	}
	
	public void setLogActividades(Boolean logActividades) {
		this.logActividades = logActividades;
	}
	
	public Boolean getReanudarActividadAnteFalla() {
		return reanudarActividadAnteFalla;
	}
	
	public void setReanudarActividadAnteFalla(Boolean reanudarActividadAnteFalla) {
		this.reanudarActividadAnteFalla = reanudarActividadAnteFalla;
	}
	
	public Boolean getReanudarEnEstadoAnterior() {
		return reanudarEnEstadoAnterior;
	}
	
	public void setReanudarEnEstadoAnterior(Boolean reanudarEnEstadoAnterior) {
		this.reanudarEnEstadoAnterior = reanudarEnEstadoAnterior;
	}
	
	public Double getPorcentajeComentariosPorMetodo() {
		return porcentajeComentariosPorMetodo;
	}
	
	public void setPorcentajeComentariosPorMetodo(Double porcentajeComentariosPorMetodo) throws CaracteristicaException {
		
		if(porcentajeComentariosPorMetodo < 0 || porcentajeComentariosPorMetodo > 100) {
			throw new CaracteristicaException("El porcentaje debe ser un valor entre 0 y 100\n");
		}
		this.porcentajeComentariosPorMetodo = porcentajeComentariosPorMetodo;
	}
	
	public Double getComplejidadCiclomatica() {
		return complejidadCiclomatica;
	}
	
	public void setComplejidadCiclomatica(Double complejidadCiclomatica) throws CaracteristicaException {
		
		if(complejidadCiclomatica <= 0) {
			throw new CaracteristicaException("La complejidad ciclomatica debe ser un valor mayor a 0\n");
		}
		this.complejidadCiclomatica = complejidadCiclomatica;
	}
	
	public Boolean getAyudaContextual() {
		return ayudaContextual;
	}
	
	public void setAyudaContextual(Boolean ayduaContextual) {
		this.ayudaContextual = ayduaContextual;
	}
	
	public Boolean getManualUsuarioIncorporado() {
		return manualUsuarioIncorporado;
	}
	
	public void setManualUsuarioIncorporado(Boolean manualUsuarioIncorporado) {
		this.manualUsuarioIncorporado = manualUsuarioIncorporado;
	}
	
	public Calificacion getCapacidadDeSerOperado() {
		return capacidadDeSerOperado;
	}
	
	public void setCapacidadDeSerOperado(Calificacion capacidadDeSerOperado) {
		this.capacidadDeSerOperado = capacidadDeSerOperado;
	}
	
	public Double getCantSOCompatibles() {
		return cantSOCompatibles;
	}
	
	public void setCantSOCompatibles(Double cantSOCompatibles) throws CaracteristicaException {
		
		if(cantSOCompatibles <= 0) {
			throw new CaracteristicaException("La cantidad de sistemas operativos compatibles debe ser un valor mayor a 0\n");
		}
		this.cantSOCompatibles = cantSOCompatibles;
	}
	
	public Double getCantPasosInstalacion() {
		return cantPasosInstalacion;
	}
	
	public void setCantPasosInstalacion(Double cantPasosInstalacion) throws CaracteristicaException {
		
		if(cantPasosInstalacion <= 0) {
			throw new CaracteristicaException("La cantidad de pasos para la instalacion debe ser un valor mayor a 0\n");
		}
		this.cantPasosInstalacion = cantPasosInstalacion;
	}

	public Calificacion getSeguridadAcceso() {
		return seguridadAcceso;
	}

	public void setSeguridadAcceso(Calificacion seguridadAcceso) {
		this.seguridadAcceso = seguridadAcceso;
	}

	public Calificacion getExactitudResultados() {
		return exactitudResultados;
	}

	public void setExactitudResultados(Calificacion exactitudResultados) {
		this.exactitudResultados = exactitudResultados;
	}

	public Calificacion getUtilizacionRecursos() {
		return utilizacionRecursos;
	}

	public void setUtilizacionRecursos(Calificacion utilizacionRecursos) {
		this.utilizacionRecursos = utilizacionRecursos;
	}

	public Calificacion getComportamientoFrenteTiempo() {
		return comportamientoFrenteTiempo;
	}

	public void setComportamientoFrenteTiempo(Calificacion comportamientoFrenteTiempo) {
		this.comportamientoFrenteTiempo = comportamientoFrenteTiempo;
	}

	public Calificacion getToleranciaFallos() {
		return toleranciaFallos;
	}

	public void setToleranciaFallos(Calificacion toleranciaFallos) {
		this.toleranciaFallos = toleranciaFallos;
	}

	public Calificacion getCapacidadRecuperacionErrores() {
		return capacidadRecuperacionErrores;
	}

	public void setCapacidadRecuperacionErrores(Calificacion capacidadRecuperacionErrores) {
		this.capacidadRecuperacionErrores = capacidadRecuperacionErrores;
	}

	public Calificacion getCapacidadDeSerAnalizado() {
		return capacidadDeSerAnalizado;
	}

	public void setCapacidadDeSerAnalizado(Calificacion capacidadDeSerAnalizado) {
		this.capacidadDeSerAnalizado = capacidadDeSerAnalizado;
	}

	public Calificacion getCapacidadDeSerCambiado() {
		return capacidadDeSerCambiado;
	}

	public void setCapacidadDeSerCambiado(Calificacion capacidadDeSerCambiado) {
		this.capacidadDeSerCambiado = capacidadDeSerCambiado;
	}

	public Calificacion getCapacidadDeSerEntendido() {
		return capacidadDeSerEntendido;
	}

	public void setCapacidadDeSerEntendido(Calificacion capacidadDeSerEntendido) {
		this.capacidadDeSerEntendido = capacidadDeSerEntendido;
	}

	public Calificacion getAdaptabilidad() {
		return adaptabilidad;
	}

	public void setAdaptabilidad(Calificacion adaptabilidad) {
		this.adaptabilidad = adaptabilidad;
	}

	public Calificacion getInstalabilidad() {
		return instalabilidad;
	}

	public void setInstalabilidad(Calificacion instalabilidad) {
		this.instalabilidad = instalabilidad;
	}

	public Calificacion getResultadoFinal() {
		return resultadoFinal;
	}

	public void setResultadoFinal(Calificacion resultadoFinal) {
		this.resultadoFinal = resultadoFinal;
	}

}
